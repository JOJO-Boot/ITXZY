package com.springsecurity.confin;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//AOP思想
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限默认到登录页,需要开启登录页面 loginPage("/toLogin") 定制登录页  登陆认证  xxxxParameter 为前端name值
        http.formLogin().loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/login");

        //关闭csrf功能  //注销失败可能原因
        http.csrf().disable();
        //注销
        http.logout().logoutSuccessUrl("/");
        //开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
    }


    //认证   在内存中读取
    //springboot2.1.0可以直接用
    //在spring security 需要进行密码加密    passwordEncoder()
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("qqq").password(new BCryptPasswordEncoder().encode("123")).roles("vip2")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("111")).roles("vip1","vip2","vip3");
    }
}
