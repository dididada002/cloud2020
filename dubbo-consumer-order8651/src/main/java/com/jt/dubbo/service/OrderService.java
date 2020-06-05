package com.jt.dubbo.service;

import com.jt.dubbo.model.TestBean;

import java.util.List;

/**
 * @author: jingteng
 * @date: 2020/6/4 22:06
 */
public interface OrderService {
    List<TestBean> test(String orderId);
}
