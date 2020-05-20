package com.xlc.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.xlc.springcloud.dao"})
public class MybatisConfig {

}
