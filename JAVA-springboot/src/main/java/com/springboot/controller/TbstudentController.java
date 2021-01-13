package com.springboot.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.pojo.Tbstudent;
import com.springboot.service.TbstudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    /**
     * 使用pagehelper进行分页，并封装进map
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/list2")
    public Object list(int page,int size){

        PageHelper.startPage(page,size);
        List<Tbstudent> studentList = tbstudentService.selectAll();
        PageInfo<Tbstudent> pageInfo = new PageInfo<>(studentList);
        Map<String,Object> data = new HashMap<>();
        data.put("total_size",pageInfo.getTotal());
        data.put("total_page",pageInfo.getPages());
        data.put("current_page",page);
        data.put("data",pageInfo.getList());
        return data;
    }


}
