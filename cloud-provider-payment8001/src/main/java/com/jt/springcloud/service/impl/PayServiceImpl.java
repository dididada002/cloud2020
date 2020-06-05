package com.jt.springcloud.service.impl;

import com.jt.springcloud.entity.Payment;
import com.jt.springcloud.interfaces.PaymentMapper;
import com.jt.springcloud.service.PayService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: jingteng
 * @date: 2020/4/13 23:45
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    @Transactional
    public long create(Payment form) {
        log.info("付款服务 XID: " + RootContext.getXID());
        form.setId(12L);
        int insert = paymentMapper.updateByPrimaryKey(form);
        /*if (insert > 0){
            throw new RuntimeException("测试付款服务异常。。。。" );
        }*/
        return form.getId();
    }

    @Override
    public Payment getById(Long id) {
        return paymentMapper.selectByPrimaryKey(id);
    }
}
