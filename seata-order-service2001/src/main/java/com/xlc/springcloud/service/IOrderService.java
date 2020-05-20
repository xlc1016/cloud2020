package com.xlc.springcloud.service;


import com.xlc.springcloud.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
* @author :xlc
* @date: 2020-5-13
* @description:order 的service
*/

public interface IOrderService {

    // 创建订单
   public  void create(Order order);

    // 修改订单状态
    public  void update(@Param("userId")Long userId, @Param("status") Integer status);
}
