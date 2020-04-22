package com.xlc.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xlc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymet_Global_Fallback")
public class OrderHystrixController {

    @Autowired
    private PaymentService paymentService;



    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id){
        return paymentService.payment_ok(id);
    }


//    @HystrixCommand(fallbackMethod = "payment_timeoutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds" ,value = "5000")
//    })
    @HystrixCommand
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){

        //int age =10 / 0;

        return  paymentService.payment_timeout(id);
    }

    public String payment_timeoutHandler(Integer id){


        return "线程池："+Thread.currentThread().getName()+"\t8000消费者自己,id: "+id+"系统繁忙请稍后再试！！！";

    }

    public String  paymet_Global_Fallback(){
        return  "global异常,请稍后再试 o(╥﹏╥)o" ;
    }



}
