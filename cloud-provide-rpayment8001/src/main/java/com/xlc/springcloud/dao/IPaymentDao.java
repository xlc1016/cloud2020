package com.xlc.springcloud.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.xlc.springcloud.entities.Payment;

@Mapper
public interface IPaymentDao {

    public  int  save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
