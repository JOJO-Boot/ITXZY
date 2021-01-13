package com.dao;

import com.pojo.User;

public interface UserMapper {
    //用户名查找是否有相同用户
    User findUser(String username);
    //用户名，密码查找
    User findAll(String username, String password);
    //名称获取密码
    String getPassword(String username);
    //id 查找是否存在
    User findById(Integer id);
    //添加用户，返回id
    int addUser(User user);
}
