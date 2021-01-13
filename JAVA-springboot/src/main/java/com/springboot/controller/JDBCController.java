package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库信息
    //若没有实体类，map获取数据库信息
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from try";
        List<Map<String,Object>> mapList = jdbcTemplate.queryForList(sql);
        return mapList;
    }
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into task.try(name,phone) values ('小明','1234')";
        jdbcTemplate.update(sql);
        return "add-OK";
    }
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update task.try set name = ?,phone = ? where id = " + id;

        //封装 传递两个参数就是new Object[2]
        Object[] objects= new Object[2];
        objects[0] = "小王";
        objects[1] = "2222222";
        //sql是预编译 所以需要传递object
        jdbcTemplate.update(sql,objects);
        return "update-OK";
    }

    @GetMapping("/deleteUser/{id}")
    public String addUser(@PathVariable("id") int id){
        String sql = "delete from task.try where id = ?";
        jdbcTemplate.update(sql,id);
        return "delete-OK";
    }
}
