package com.jc.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhoufei on 2020/7/2.
 */
@Controller
public class ViewController {
    @RequestMapping("/roleLogin")
    public String roleLogin(){
        return "roleLogin";
    }

    @RequestMapping("/main1")
    public String main1(){
        return "main1";
    }

}
