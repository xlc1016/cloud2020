package com.xlc.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
* @author :xlc
* @date: 2020-4-16
* @description: 替换ribbon的负责均衡规则
*/
@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule(){
        return  new RandomRule(); // 随机方式
    }
}
