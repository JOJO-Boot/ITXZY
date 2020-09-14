package com.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //3.shiroFilterFactoryBean

    @Bean(name = " ShiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);


        /*
        添加shiro内置管理器
        anon:无需认证
        authc:必须认证才能访问
        user:必须拥有记住我才能访问
        perms:拥有对某个资源的得权限才能访问
        role:拥有某个角色权限才能访问
        logout:注销
         */
        Map<String, String> filterMap = new LinkedHashMap<String, String>();

        //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
        //perms括号中的内容是权限的值
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
        //拦截/user/之后的所有请求
        filterMap.put("/user/*","authc");


        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录请求
        bean.setLoginUrl("/toLogin");
        //设置未授权请求
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }
    //2.DefaultWebSecurityManager
    @Bean(name = "getDefaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //1.创建realm对象
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合shiroDialect:用来整合shiro和thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
