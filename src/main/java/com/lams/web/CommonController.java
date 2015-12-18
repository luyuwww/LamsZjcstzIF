package com.lams.web;

import com.lams.service.NoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    NoticeService noticeService;
}
