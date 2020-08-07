package com.bootmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 根目录下的文件在配置类中配置好些
 * 视图解析器
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer{

    //自定义视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    //自定义的国际化组件
    //方法名只能为 localeResolver
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())//添加自己创建的拦截器
                .addPathPatterns("/**")//拦截所有
                .excludePathPatterns("/index.html","/","/user/login","/static/**");//除了这些都拦截
    }
}
