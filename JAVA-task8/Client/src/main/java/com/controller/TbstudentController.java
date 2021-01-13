package com.controller;

import com.pojo.Tbstudent;
import com.service.TbstudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class TbstudentController {

    @Autowired
    private TbstudentService tbstudentService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Tbstudent> studentList = tbstudentService.selectAll();
        model.addAttribute("studentList",studentList);
        return "student";
    }
    @RequestMapping("/test")
    public String ss(){
        return "test";
    }
}
