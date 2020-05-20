package com.xlc.springcloud.service;


import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

public interface IAccountService {

    
    /**
    * @author :xlc
    * @date: 2020-5-15
    * @description: 扣减账户余额
    */
    public  void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);
}
