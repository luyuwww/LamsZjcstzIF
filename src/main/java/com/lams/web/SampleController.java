package com.lams.web;

import com.lams.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by luyuwww on 2015-03-17.
 */
@Controller
public class SampleController {

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

    @Autowired
    NoticeService noticeService;
}
