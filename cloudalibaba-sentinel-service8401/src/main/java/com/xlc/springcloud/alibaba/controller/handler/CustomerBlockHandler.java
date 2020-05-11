package com.xlc.springcloud.alibaba.controller.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xlc.springcloud.entities.CommonResult;

import javax.smartcardio.CommandAPDU;

public class CustomerBlockHandler {

    public static  CommonResult handlerException(BlockException b){

        return new CommonResult(4444,"按客户自定义 ,global handlerException-----1)");

    }

    public static CommonResult handlerException2(BlockException b){

        return new CommonResult(4444,"按客户自定义 ,global handlerException-----2)");

    }
}
