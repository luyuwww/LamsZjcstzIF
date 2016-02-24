package com.lams.web;

import ch.qos.logback.classic.Logger;
import com.lams.service.NoticeService;
import com.lams.util.DES;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by luyuwww on 2015-03-17.
 */
@Controller
public class CommonController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 列出所有用户 测试方法
     */
    @RequestMapping(value="/getUsers" , method = RequestMethod.GET)
    public String userList(Model model){
        model.addAttribute("userlist", noticeService.listAllUser());
        return "userlist";
    }

    /**
     *  流程过来的消息 需要发送到 邮件和待办
     */
    @RequestMapping(value="/sendMsg" , method = RequestMethod.POST)
    public void sendMsg(@RequestParam String  userCodes , @RequestParam String varsJson , @RequestParam String actTaskID){
        if(StringUtils.isNotEmpty(varsJson) && StringUtils.isNotEmpty(actTaskID)){
            noticeService.sendActivitiMsg(userCodes, varsJson , actTaskID);
        }
    }

    /**
     *  当流程结束 申请人或者流程管理员销毁流程的时候 调用销毁待办
     */
    @RequestMapping(value="/sendDestoryMsg" , method = RequestMethod.POST)
    public void sendDestoryMsg(@RequestParam String  operUserCode , @RequestParam String actTaskId){
        if(StringUtils.isNotEmpty(operUserCode) && StringUtils.isNotEmpty(actTaskId)){
            noticeService.sendDestoryMsg(operUserCode, actTaskId);
        }
    }

    /**
     * 单点登录
     * http://localhost:83/LamsZjcstzIF/sso?usercode=ROOT&token=sdsdfdsf
     */
    @RequestMapping(value="/sso" , method = RequestMethod.GET)
    public String sso(@RequestParam String  userID , @RequestParam String token ){
        String lamsUrl = "http://"+lamsIP+"/Lams/directLogin?usercode=";
        String usercode = "";
        try {
            System.out.println("=======================");
            System.out.println(userID);
            System.out.println("=======================");
            usercode = DES.decrypt(userID , desKey);
            System.out.println("*************************");
            System.out.println(usercode);
            System.out.println("*************************");
            lamsUrl = lamsUrl + usercode;
            log.error("验证成功可以登录档案系统!");
        } catch (Exception e) {
            lamsUrl = lamsUrl;
            log.error("验证失败!");
            e.printStackTrace();
        }
        return "redirect:" + lamsUrl;
    }

    @Autowired
    NoticeService noticeService;

    @Autowired
    @Value("${lams.ip}")
    private String lamsIP;//档案服务器ip

    @Autowired
    @Value("${des.key}")
    private String desKey;//单点的机密串

    private Logger log =  (Logger) LoggerFactory.getLogger(this.getClass());
}
