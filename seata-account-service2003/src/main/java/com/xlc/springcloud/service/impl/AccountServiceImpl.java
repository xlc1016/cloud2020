package com.xlc.springcloud.service.impl;


import com.xlc.springcloud.dao.IAccountDao;
import com.xlc.springcloud.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class AccountServiceImpl  implements IAccountService{

    @Resource
    private IAccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId,money);
    }
}
