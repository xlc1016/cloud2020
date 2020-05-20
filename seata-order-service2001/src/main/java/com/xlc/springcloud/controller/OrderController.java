package com.xlc.springcloud.controller;


import com.xlc.springcloud.entity.CommonResult;
import com.xlc.springcloud.entity.Order;
import com.xlc.springcloud.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @author :xlc
* @date: 2020-5-13
* @description:
*/

@RestController
@Slf4j
public class OrderController {

    @Resource
    private IOrderService service;


    @GetMapping(value = "/createOrder")
    public CommonResult create(Order order){
        service.create(order);

        return new CommonResult(200,"创建订单成功");

    }
    @GetMapping(value = "/test")
    public  String  test(){

        log.info("test反问成功！");

        return  "11111";
    }
}
