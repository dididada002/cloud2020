package com.jt.springcloud.service.impl;

import com.jt.springcloud.entity.Payment;
import com.jt.springcloud.interfaces.PaymentMapper;
import com.jt.springcloud.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: jingteng
 * @date: 2020/4/13 23:45
 */
@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public long create(Payment form) {
        int insert = paymentMapper.insert(form);
        return form.getId();
    }

    @Override
    public Payment getById(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}
