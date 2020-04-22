package com.xlc.springcloud.dao;


import com.xlc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IPaymentDao {

    public  int  save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
