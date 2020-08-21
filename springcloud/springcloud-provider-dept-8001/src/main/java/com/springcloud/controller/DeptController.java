package com.springcloud.controller;

import com.springcloud.pojo.Dept;
import com.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
   private DeptService deptService;

    //获取配置信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept getDept(@PathVariable("id") Long id){
        Dept dept =  deptService.queryById(id);
        if(dept == null){
            throw new RuntimeException("Fail");
        }
        return dept;
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }


    //注册进来的微服务~，获取一些消息，多人共同开发时使用   ====================可以不写==============
    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        //获取微服务列表清单
        List<String> services = client.getServices();
        System.out.println("services===============>" + services);

        //得到一个具体的微服务信息,通过具体的微服务id，
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");

        for (ServiceInstance instance : instances){
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getServiceId() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t"
            );
        }
        return this.client;
    }
}
