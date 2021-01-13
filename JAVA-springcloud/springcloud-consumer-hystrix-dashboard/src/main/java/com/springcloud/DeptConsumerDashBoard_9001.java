package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启Dashboard页面

public class DeptConsumerDashBoard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerDashBoard_9001.class,args);
    }
}
