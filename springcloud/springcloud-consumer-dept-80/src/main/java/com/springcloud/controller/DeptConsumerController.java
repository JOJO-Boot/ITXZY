package com.springcloud.controller;


import com.springcloud.pojo.Dept;
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
    private RestTemplate restTemplate;

    //Ribbon  这里的地址应该是一个变量，通过服务名来访问
//    private static final String RET_URL_PREFIX = "http://localhost:8001";
    private static final String RET_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public Boolean add(Dept dept){
        return restTemplate.postForObject(RET_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id){
        return restTemplate.getForObject(RET_URL_PREFIX + "/dept/get/" + id,Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> queryAll(){
        return restTemplate.getForObject(RET_URL_PREFIX + "/dept/list",List.class);
    }
}
