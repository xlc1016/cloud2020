package com.xlc.springcloud.controller;


import com.xlc.springcloud.entities.CommonResult;
import com.xlc.springcloud.entities.Payment;
import com.xlc.springcloud.lb.ILoadBalanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

 //  private static final String PAYMENT_URL="http://localhost:8001";
 //  private static final String PAYMENT_URL="http://CLOUD-PRVIDE-SRVICE";
   private static final String PAYMENT_URL="http://localhost:8001";


   @Resource
   private RestTemplate restTemplate;

   @Resource
   private DiscoveryClient discoveryClient;
    /**
     * 自定义的负载均衡
     */
   @Resource
   private ILoadBalanced loadBalanced;




    @GetMapping(value = "/consumer/payment/create")
      public CommonResult create(Payment payment){

        return restTemplate.postForObject(PAYMENT_URL+"/payment/save",payment,CommonResult.class);

      }
      @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

      }
      /**
      * @author :xlc
      * @date: 2020-4-17
      * @description:自定义轮询方法
      */
      @GetMapping(value = "/consumer/payment/lb")
      public String getPaymentLB(){
          List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PRVIDE-SRVICE");
          if(instances !=null || instances.size()> 0) {

              ServiceInstance instance = loadBalanced.instance(instances);
              URI uri = instance.getUri();
              return restTemplate.getForObject(uri+"/payment/lb",String.class);
          }else {
              return  null;
          }

      }

    //============> zipkin + sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        String result = restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin", String.class);
        return result;
    }

}
