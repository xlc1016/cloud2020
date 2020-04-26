package com.xlc.springcloud.controller;


import com.xlc.springcloud.service.IPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.xlc.springcloud.entities.CommonResult;
import com.xlc.springcloud.entities.Payment;


import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class PaymentController {


    @Resource
    private IPaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;



    @GetMapping(value = "/payment/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****serviceName:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PRVIDE-SRVICE");
        for (ServiceInstance instance : instances) {
            log.info("****URl:"+instance.getUri());
        }


        return this.discoveryClient;


    }





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
  @GetMapping(value = "/payment/feign/tiemout")
  public String getPaymetTiemOut(){

// 暂停几秒
      try{
          TimeUnit.SECONDS.sleep(3);
      }catch (InterruptedException e){
          e.printStackTrace();
      }
        return  serverPort;
  }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){

        String result ="zipkin----zipkin (●'◡'●)";
        return result;
    }


}
