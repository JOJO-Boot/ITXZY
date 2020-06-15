package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutController {


    @RequestMapping("/home")//为控制器指定可以处理的请求URL
    public String hello(){
        return "body1";
    }
}
