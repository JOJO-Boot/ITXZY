package com.bootredis;

import com.bootredis.pojo.User;
import com.bootredis.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class BootRedisApplicationTests {

    @Autowired
   private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

        //获取连接
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();
        connection.flushAll();

        //set  get 操作
        redisTemplate.opsForValue().set("key","zzz");
        redisTemplate.opsForValue().get("key");
    }

    @Test
    public void test() throws JsonProcessingException {

        //真是开发都用json来传递对象
        User user = new User("qqq",6);
        String jsonUser = new ObjectMapper().writeValueAsString(user);

        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
