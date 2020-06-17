package com.controller;

import com.pojo.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LayoutController {

//    @Autowired
//    private StudentService studentService;

    @RequestMapping("/home")//为控制器指定可以处理的请求URL
    public String hello(){
        return "body1";
    }

//    @RequestMapping("/home")
//    public String home(Long id,Model model){
//        Student student = studentService.selectByPrimaryKey(id);
//        model.addAttribute("student",student);
//        return "body1";
//    }
}
