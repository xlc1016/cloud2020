package com.xlc.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDE-HYSTIX-SRVICE",fallback = PaymentFallbackService.class)
//@FeignClient("cloud-provide-hystix-srvice")
public interface PaymentService {


    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id);
}
