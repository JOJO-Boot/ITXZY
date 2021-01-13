package com.springcloud.controller;


import com.springcloud.pojo.Dept;
import com.springcloud.service.imp.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    //消费者不能有service层

    @Autowired
    private DeptClientService deptClientService = null;



    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public Boolean add(Dept dept){
        return this.deptClientService.addDept(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public Dept queryById(@PathVariable("id") long id){
        return this.deptClientService.queryById(id);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> queryAll(){
        return this.deptClientService.queryAll();
    }
}
