package com.xlc.springcloud.service.impl;

import com.xlc.springcloud.dao.IStorageDao;
import com.xlc.springcloud.service.IStorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class StorageServiceImpl implements IStorageService {


    @Resource
    private IStorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId,count);
    }
}
