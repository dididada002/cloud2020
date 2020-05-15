package com.jt.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: jingteng
 * @date: 2020/4/20 21:59
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new  AtomicInteger(0);

    /**
     * 负载均衡的核心算法，记录请求的次数
     * */
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****第几次访问,次数next; " + next);
        return next;
    }

    /**
     * 获取请求需要到达哪台机器
     * */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
