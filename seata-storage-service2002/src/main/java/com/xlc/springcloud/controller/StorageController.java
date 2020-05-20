package com.xlc.springcloud.controller;


import com.xlc.springcloud.entitys.CommonResult;
import com.xlc.springcloud.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class StorageController {

    @Resource
    private IStorageService storageService;


    @RequestMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId")
                                         Long productId,@RequestParam("count") Integer count){

        storageService.decrease(productId,count);
        return  new CommonResult(200,"扣减库存成功");
    }
}
