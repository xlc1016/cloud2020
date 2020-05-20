package com.xlc.springcloud.service;


import com.xlc.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-storage-service")
public interface IStorageService {


    @PostMapping("storage/decrease")
    public CommonResult decrease(@RequestParam("productId")
                                         Long productId, @RequestParam("count") Integer count);
}
