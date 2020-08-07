package com.bootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    //登录
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){
        //具体业务
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功添加session
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //告诉用户登陆失败
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
    }
    //注销
    @RequestMapping("/user/logout")
     public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
