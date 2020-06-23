package com.service;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    //用户名查找是否有相同用户
    User findUser(String username);
    //用户名，密码查找
    User findAll(@Param("username") String username, @Param("password") String password);
    //名称获取密码
    String getPassword(String username);
    //id 查找是否存在
    User findById(Integer id);
    //添加用户，返回id
    int addUser(User user);
}
