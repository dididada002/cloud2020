package com.jt.springcloud.service;

import com.jt.springcloud.model.request.OrderForm;
import com.jt.springcloud.modul.vo.Result;

/**
 * @author: jingteng
 * @date: 2020/6/5 19:32
 */
public interface OrderService {
    Result create(OrderForm form);
}
