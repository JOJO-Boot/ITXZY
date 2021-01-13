package com.service.imp;

import com.dao.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User findUser(String username) {
        return userMapper.findUser(username);
    }

    @Override
    public User findUserByPhone(String phone) {
        return userMapper.findUser(phone);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
    @Override
    public int addUser(User user) {
        userMapper.addUser(user);return user.getId();
    }
}
