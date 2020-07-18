package com.jt.springcloud.service;

import com.jt.springcloud.entity.Payment;
import com.jt.springcloud.modul.request.HysTestForm;
import com.jt.springcloud.modul.vo.Result;

/**
 * @author: jingteng
 * @date: 2020/4/13 23:45
 */
public interface PayService {
    long create(Payment form);

    Payment getById(Long id);

    Result testTimeOut(HysTestForm form);

    Result testOk(HysTestForm form);
}
