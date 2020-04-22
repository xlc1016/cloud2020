package com.xlc.springcloud.service;


import com.xlc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface IPaymentService {

    public  int  save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
