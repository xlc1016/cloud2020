package com.xlc.springcloud.service;


import com.xlc.springcloud.entities.CommonResult;
import com.xlc.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("CLOUD-PRVIDE-SRVICE")
public interface PaymentFeignService {

    @GetMapping(value="/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/tiemout")
    public String getPaymetTiemOut();

}
