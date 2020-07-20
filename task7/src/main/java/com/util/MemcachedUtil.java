package com.util;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Component
public class MemcachedUtil {

    private Logger logger = Logger.getLogger(MemcachedUtil.class);
    @Autowired
    private static  MemcachedClient memcachedClient;
    private   int EXPtime = 60*60; //seconds
    static {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:memcached.xml");
        memcachedClient = applicationContext.getBean(MemcachedClient.class);
    }

   //set添加缓存，如果key  已经存在,那么覆盖掉原来的key，相当于更新操作
    public void set(String key,Object value)  {
        try {
            memcachedClient.set(key, EXPtime,value);
            logger.error("set添加成功");
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            logger.error("set添加失败");
            e.printStackTrace();
        }
    }
    //添加缓存操作 add的key 不存在则会新创建一个key  若存在则不会添加
    public void add(String key,Object value)  {
        try {
            memcachedClient.add(key, EXPtime,value);
            logger.error("add添加成功");
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            logger.error("add添加失败");
            e.printStackTrace();
        }
    }
    //获取缓存内容
    public Object get(String key){
        try {
            return memcachedClient.get(key);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            logger.error("获取内容失败");
            e.printStackTrace();
        }
        return null;
    }
    //删除缓存
    public void delete(String key){
        try {
            memcachedClient.delete(key);
            logger.error("删除成功");
        }catch (TimeoutException | InterruptedException | MemcachedException e){
            logger.error("删除失败");
            e.printStackTrace();
        }

    }
    //更新缓存
    public void replace(String key,Object value){
        try {
            memcachedClient.replace(key,EXPtime,value);
            logger.error("更新成功");
        }catch (TimeoutException | InterruptedException | MemcachedException e){
            logger.error("更新失败");
            e.printStackTrace();
        }
    }
}

