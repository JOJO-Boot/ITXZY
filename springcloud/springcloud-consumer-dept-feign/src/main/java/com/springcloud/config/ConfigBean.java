package com.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration//等价于spring中的 applicationContext.xml
public class ConfigBean {

    //配置负载均衡实现RestTemplate
    //RoundRobinRule  轮询
    //RandomRule  随机
    //AvailabilityFilteringRule  过滤掉访问故障的服务，对剩下的服务进行轮询
    //RetryRule  先按照轮询获取服务，如果获取失败，则在指定的时间内重试
    @Bean
    @LoadBalanced//Ribbon  负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
