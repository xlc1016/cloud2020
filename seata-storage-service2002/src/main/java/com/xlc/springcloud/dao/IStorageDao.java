package com.xlc.springcloud.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IStorageDao {
    
    /**
    * @author :xlc
    * @date: 2020-5-15
    * @description: 扣减库存数量
    */
    void decrease(@Param("productId")Long productId, @Param("count") Integer count);
}
