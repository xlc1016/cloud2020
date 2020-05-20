package com.xlc.springcloud.dao;

import com.xlc.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author :xlc
* @date: 2020-5-13
* @description: 订单接口
*/
@Mapper
public interface IOrder {

    // 创建订单
    void create(Order order);

    // 修改订单状态
    void update(@Param("userId")Long userId, @Param("status") Integer status);
}
