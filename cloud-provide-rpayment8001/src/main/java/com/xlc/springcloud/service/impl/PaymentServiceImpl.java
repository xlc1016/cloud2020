package com.xlc.springcloud.service.impl;


import com.xlc.springcloud.dao.IPaymentDao;
import com.xlc.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;
import com.xlc.springcloud.entities.Payment;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements IPaymentService {


    @Resource
    private IPaymentDao paymentDao;
    @Override
    public int save(Payment payment) {
        int number = paymentDao.save(payment);
        return number ;
    }

    @Override
    public Payment getPaymentById(Long id) {
        Payment payment = paymentDao.getPaymentById(id);
        return payment;
    }
}
