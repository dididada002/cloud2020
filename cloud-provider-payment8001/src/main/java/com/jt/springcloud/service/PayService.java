package com.jt.springcloud.service;

import com.jt.springcloud.entity.Payment;

/**
 * @author: jingteng
 * @date: 2020/4/13 23:45
 */
public interface PayService {
    long create(Payment form);

    Payment getById(Long id);
}
