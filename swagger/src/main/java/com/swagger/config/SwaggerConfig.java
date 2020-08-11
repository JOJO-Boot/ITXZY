package com.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.ArrayList;


@Configuration
@EnableSwagger2  //开启swagger2
public class SwaggerConfig {

    //配置了swagger的实例
    @Bean
    public Docket docket(Environment environment){

        //设置显示的swagger的环境
        Profiles profile = Profiles.of("dev");
        //通过environment.acceptsProfiles(profile)判断目前是否处在自己的设定环境中
        boolean flag = environment.acceptsProfiles(profile);

        System.out.println(flag);

        return new Docket(DocumentationType.SWAGGER_2)
                //使用自定义的信息
                .apiInfo(apiInfo())
                //组的名字  识别
                .groupName("乔兆年")
                //是否启动swagger  false：不启动 true：启动
                .enable(flag)
                .select()
                //RequestHandlerSelectors 配置要扫描接口的方式
                //basePackage指定要扫描的包
                //any() 扫描全部   none()都不扫描
                //withClassAnnotation 扫描类上的注解
                //withMethodAnnotation 扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.swagger.controller"))
                //path()扫描的路径  只识别这个路径
                //.paths(PathSelectors.ant("/"))
                .build();
    }

    //配置了swagger的信息
    private ApiInfo apiInfo(){
        Contact contact = new Contact("", "", "");
        return new ApiInfo("Api Documentation",
                "Api Documentation",
                "1.0",
                "urn:tos",
                 contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

    //配置多个分组
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
}
