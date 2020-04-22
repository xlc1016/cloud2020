package com.xlc.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ILoadBalanced {

    ServiceInstance instance (List<ServiceInstance> serviceInstanceList);
}
