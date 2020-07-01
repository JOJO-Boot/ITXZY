package com.controller;

import com.pojo.Student;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {

 @Autowired
 private StudentService studentService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(Model model){
        List<Student> studentList = studentService.selectByHot(1);
        model.addAttribute("studentList",studentList);
        return "body1";
    }
    @RequestMapping(value = "/u/profession",method = RequestMethod.GET)
    public String profession(){
        return "body2";
    }

}
