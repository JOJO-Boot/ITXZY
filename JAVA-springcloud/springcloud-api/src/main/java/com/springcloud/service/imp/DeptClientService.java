package com.springcloud.service.imp;

import com.springcloud.pojo.Dept;
import com.springcloud.service.DeptClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)//fallbackFactory  熔断降级
public interface DeptClientService {

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean addDept(Dept dept);

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept queryById(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> queryAll();
}
