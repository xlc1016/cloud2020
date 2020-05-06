package com.xlc.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CouldAlibabaProviderPayment9002Main {
    public static void main(String[] args){
        SpringApplication.run(CouldAlibabaProviderPayment9002Main.class,args);
    }
}
