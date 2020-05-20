package com.xlc.springcloud.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface IAccountDao {

/**
* @author :xlc
* @date: 2020-5-15
* @description: 扣减账户余额
*/
    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);

}
