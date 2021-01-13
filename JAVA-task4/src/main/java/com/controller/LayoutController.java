package com.controller;

import com.pojo.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutController {

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("position","山主");
        model.addAttribute("name","陈好人");
        model.addAttribute("description","真滴强");
        return "body1";
    }

    @RequestMapping("/body")
    public String body(){
        return "body2";
    }
}
