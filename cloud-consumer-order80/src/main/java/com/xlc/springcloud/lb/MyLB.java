package com.xlc.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Component
public class MyLB implements ILoadBalanced {

    // 原子类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getIntandcrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            //循环次数 不能大于正数类型的最大值
            next = current >= Integer.MAX_VALUE  ?0:current+1;

        }while (!this.atomicInteger.compareAndSet(current,next));

        System.out.println("@@@@@@@@@@@第几次访问服务器:"+next);
        return next;


    }
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstanceList) {
        int index = getIntandcrement() % serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
