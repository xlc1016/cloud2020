package com.xlc.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sun.xml.internal.bind.v2.runtime.Name;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentHystrixService
{
    //服务降级
    public String payment_ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+"payment_ok,id: "+id;
    }



    @HystrixCommand(fallbackMethod = "payment_timeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds" ,value = "5000")
    })
    public String payment_timeout(Integer id){
        //int age = 10/0;
        Integer timeout=3000;
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"payment_timeout,id: "+id+"(●'◡'●)";
    }

    public String payment_timeoutHandler(Integer id){


        return "线程池："+Thread.currentThread().getName()+"8001payment_timeoutHandler,id: "+id+"系统繁忙请稍后再试！！！";

    }

    // 服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求的次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少跳闸

    })
   public String paymentCircuitBreaker(@PathVariable("id") Integer id) {

        if (id < 0) {
            throw new RuntimeException("*******id不能为负数");
        }

        return Thread.currentThread().getName() + "\t" + "流水号：" + IdUtil.simpleUUID();

    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能使负数。请从新输入"+id;
    }
}
