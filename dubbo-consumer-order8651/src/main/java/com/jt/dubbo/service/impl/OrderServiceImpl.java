package com.jt.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.jt.dubbo.interfaces.PayService;
import com.jt.dubbo.model.TestBean;
import com.jt.dubbo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jingteng
 * @date: 2020/6/4 22:06
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Reference(loadbalance = "roundrobin")//发现服务注解
    PayService payService;
    @Override
    public List<TestBean> test(String orderId) {
        List<TestBean> test = payService.test(orderId);
        System.out.println(JSON.toJSONString(test));
        return test;
    }
}
