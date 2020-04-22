package com.xlc.springcloud.service;


import org.apache.ibatis.annotations.Param;
import com.xlc.springcloud.entities.Payment;

public interface IPaymentService {

    public  int  save(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
