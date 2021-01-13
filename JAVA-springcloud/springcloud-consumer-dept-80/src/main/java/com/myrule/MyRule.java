package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {

    //这里是配置 Ribbon  自定义Ribbon客户端  自定义的配置不应该与主启动类在同级

    @Bean
    public IRule QznRule(){
        return new RoundRobinRule();//默认是轮询，现在自定义为MyRandomRule
    }
}
