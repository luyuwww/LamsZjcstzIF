package com.lams.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by luyuwww on 2015-03-17.
 */
@Controller
public class SampleController {

    @RequestMapping("/")
    public String index() {
        System.out.println("index222");
        return "index";
    }
}
