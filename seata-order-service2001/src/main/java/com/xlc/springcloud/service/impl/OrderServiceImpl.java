package com.xlc.springcloud.service.impl;

import com.xlc.springcloud.dao.IOrder;
import com.xlc.springcloud.entity.Order;
import com.xlc.springcloud.service.IAccountService;
import com.xlc.springcloud.service.IOrderService;
import com.xlc.springcloud.service.IStorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class OrderServiceImpl implements IOrderService {



    @Resource
    private IOrder orderDao;

    @Resource
    private IAccountService accountService;

    @Resource
    private IStorageService storageService;

    @Override
    @GlobalTransactional(name = "xlc_create_order",rollbackFor = Exception.class)
    public void create(Order order) {
        orderDao.create(order);
        storageService.decrease(order.getProductId(),order.getCount());

        accountService.decrease(order.getUserId(),order.getMoney());

        orderDao.update(order.getUserId(),0);
    }

    @Override
    public void update(Long userId, Integer status) {
        orderDao.update(userId,status);
    }
}
