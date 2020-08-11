package com.swagger.controller;

import com.swagger.pojo.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "Hello";
    }

    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public Student student(){
        return new Student();
    }

    @ApiOperation("hello控制类")
    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String hello2(@ApiParam("用户名") String username){
        return "hello" + username;
    }
}
