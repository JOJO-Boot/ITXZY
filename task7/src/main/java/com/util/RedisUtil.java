package com.util;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


@Component
public class RedisUtil {

    private Logger logger = Logger.getLogger(RedisUtil.class);

    private static final RedisTemplate redisTemplate;
    static {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:redis.xml");
        redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");
    }
    //添加缓存
    public void set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            logger.info("redis添加");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("redis添加失败");
        }
    }
    //添加缓存
    public void set(String key,String value){
        try {
            redisTemplate.opsForValue().set(key,value);
            logger.info("redis添加");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("redis添加失败");
        }
    }

    //获取缓存
    public Object get(Object key){
        try{
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("redis获取失败");
        }
        return null;
    }
}
