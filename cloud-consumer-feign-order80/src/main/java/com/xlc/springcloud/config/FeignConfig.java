package com.xlc.springcloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feigenLoggerLevl(){
        return  Logger.Level.FULL;
    }

}
