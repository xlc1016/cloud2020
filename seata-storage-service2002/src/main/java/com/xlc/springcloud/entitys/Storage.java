package com.xlc.springcloud.entitys;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long  id; // id
    private Long productId; //  产品id
    private Integer total; // 库存总数
    private Integer used; //  已用库存
    private Integer residue; // 剩余库存
}
