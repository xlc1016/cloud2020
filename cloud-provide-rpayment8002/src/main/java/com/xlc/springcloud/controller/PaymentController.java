package com.xlc.springcloud.controller;


import com.xlc.springcloud.entities.CommonResult;
import com.xlc.springcloud.entities.Payment;
import com.xlc.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@Slf4j
public class PaymentController {


    @Resource
    private IPaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;


    @PostMapping(value="/payment/save")
    public CommonResult save(@RequestBody Payment payment){

        int number = paymentService.save(payment);
        log.info("插入成功:"+number);

        if (number>0) {
            return new CommonResult(200, "添加数据成功--serverPort"+serverPort, number);
        }else{

            return  new CommonResult(444,"添加失败",null);
        }

    }
  @GetMapping(value="/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
      Payment payment = paymentService.getPaymentById(id);

      if (payment != null) {
          return new CommonResult(200, "查询ok--serverPort"+serverPort, payment);
      }else{
          return  new CommonResult(444,"没有数据",null);
      }

  }

    @GetMapping(value = "/payment/lb")
    public String  getServerPort(){
        return serverPort;
    }





}
