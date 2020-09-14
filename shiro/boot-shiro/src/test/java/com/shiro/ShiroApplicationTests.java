package com.shiro;

import com.shiro.service.imp.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroApplicationTests {

    @Autowired
    UserServiceImp userServiceImp;

    @Test
    void contextLoads() {
        System.out.println(userServiceImp.queryUserByName("JOJO"));
    }

}
