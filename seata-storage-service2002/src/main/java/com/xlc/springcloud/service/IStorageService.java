package com.xlc.springcloud.service;


import org.apache.ibatis.annotations.Param;

public interface IStorageService {
    public void decrease(@Param("productId")Long productId, @Param("count") Integer count);
}
