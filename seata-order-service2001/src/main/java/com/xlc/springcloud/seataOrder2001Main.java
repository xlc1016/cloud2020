package com.xlc.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自带创建
//@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class seataOrder2001Main {
    public static void main(String[] args){
        SpringApplication.run(seataOrder2001Main.class,args);
    }
}
