package com.xlc.springcloud.controller;


import com.xlc.springcloud.entitys.CommonResult;
import com.xlc.springcloud.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@Slf4j
public class AccountController {


    @Resource
    private IAccountService accountService;


    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,
                                 @RequestParam("money")BigDecimal money){

        accountService.decrease(userId,money);

        return  new CommonResult(200,"扣减账户余额成功");
    }
}
