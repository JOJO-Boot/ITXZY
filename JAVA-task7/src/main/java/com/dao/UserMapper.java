package com.dao;

import com.pojo.User;

public interface UserMapper {
    //用户名查找是否有相同用户
    User findUser(String username);
    //手机号查询用户
    User findUserByPhone(String phone);
    //id 查找是否存在
    User findById(Integer id);
    //添加用户，返回id
    int addUser(User user);

}
