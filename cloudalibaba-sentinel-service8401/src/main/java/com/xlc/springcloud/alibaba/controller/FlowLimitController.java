package com.xlc.springcloud.alibaba.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {


    @GetMapping(value = "/testA")
    public String testA(){
        return "----------------testA";
    }

    @GetMapping(value = "/testB")
    public String testB(){
        return "----------------testB";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey" ,blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1 ,
                             @RequestParam(value = "p2",required = false) String p2){
        int age = 10/0 ;
        return "----------------testHotKey";
    }

    public  String deal_testHotKey(String p1 , String p2 , BlockException e){
        return "----------------deal_testHotKey ( ▼-▼ )";
    }

}
