package com.xlc.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZkController {

    public static final String ORDER_URL="http://cloud-prvide-srvice";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String getPaymentZk(){


        String result = restTemplate.getForObject(ORDER_URL + "/payment/zk", String.class);

        return result;


    }
}
