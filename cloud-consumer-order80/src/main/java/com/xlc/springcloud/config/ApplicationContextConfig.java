package com.xlc.springcloud.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced  // 表示RestTemplate开启了负载均衡
    public RestTemplate getTestTemplate(){
        return  new RestTemplate();
    }
}
