package com.jt.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author: jingteng
 * @date: 2020/4/20 21:56
 * 自定义Ribbon负载均衡算法
 */
public interface LoadBalancer {
    /**
     * 初始化集群数
     * */
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
