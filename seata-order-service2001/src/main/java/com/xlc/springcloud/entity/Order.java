package com.xlc.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
* @author :xlc
* @date: 2020-5-13
* @description: 订单类实体
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id; // 订单id
    private Long userId ; // 账号id
    private Long productId ; // 产品id
    private Integer count ; // 数量
    private BigDecimal money ;
    private Integer status;  // 0 未完成 ；1 完成

}
