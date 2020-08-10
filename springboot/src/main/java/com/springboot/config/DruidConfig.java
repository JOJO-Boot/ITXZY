package com.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控  web.xml
    //因为Springboot内置了servlet容器，所以没有web.xml 代替方法 ServletRegistrationBean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");

        //后台需要有人登录,账号密码设置
        Map<String,String> initParameters = new HashMap<>();

        //添加配置  登录的key 是固定的，必须是 loginUsername   loginPassword
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");

        //允许谁登录
        initParameters.put("allow","");//value为空表明都可以登录

        //禁止登录  initParameters.put("qzn","192.169.2.1") 主机名，主机IP

        bean.setInitParameters( initParameters);
        return bean;
    }

    //filter过滤器
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParameters = new HashMap<>();

        //不过滤的东西
        initParameters.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParameters);
        return bean;
    }
}
