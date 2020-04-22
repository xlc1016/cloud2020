package com.xlc.springcloud.controller;

import com.xlc.springcloud.config.FeignConfig;
import com.xlc.springcloud.entities.CommonResult;
import com.xlc.springcloud.entities.Payment;
import com.xlc.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/conumer/payMent/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        return  paymentFeignService.getPaymentById(id);

    }


    @GetMapping(value = "/conumer/payment/feign/tiemout")
    public String getPaymetTiemOut(){
        return paymentFeignService.getPaymetTiemOut();
    }



}
