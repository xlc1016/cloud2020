package com.xlc.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xlc.springcloud.alibaba.controller.handler.CustomerBlockHandler;
import com.xlc.springcloud.entities.CommonResult;
import com.xlc.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ReteLimitController {


    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommonResult byResource(){
        return  new CommonResult(200,"按资源名称限流测试OK",
                new Payment(2020L,"serial001"));
    }
    public CommonResult handlerException(BlockException b){

        return  new CommonResult(444,b.getClass().getCanonicalName()+"\t ( ▼-▼ )");

    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"按客户自定义",new Payment(2020L,"serial002"));
    }
}
