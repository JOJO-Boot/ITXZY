package com.springboot.controller;

import com.springboot.pojo.Tbstudent;
import com.springboot.service.TbstudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TbstudentController {

    @Autowired
    private TbstudentService tbstudentService;

    @RequestMapping("/list")
    public List<Tbstudent> list(){
        List<Tbstudent> studentList = tbstudentService.selectAll();
        for (Tbstudent tbstudent : studentList){
            System.out.println(tbstudent);
        }
        return studentList;
    }
}
