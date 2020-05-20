package com.xlc.springcloud.entitys;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @author :xlc
* @date: 2020-5-15
* @description: 账户实体
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    private Long id; // id
    private Long userId; // 用户id
    private Integer total; // 总额
    private Integer used; // 已用额度
    private Integer residue; // 剩余额度
}
