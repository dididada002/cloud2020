package com.jt.springcloud.service;

import com.jt.springcloud.modul.request.PayCreateForm;
import com.jt.springcloud.modul.vo.Result;
import org.springframework.stereotype.Component;

/**
 * @author: jingteng
 * @date: 2020/6/5 20:44
 * 如果远程服务调用失败，则调用该类中的相关方法
 */
@Component
public class PaymentFeignServiceFallback implements PaymentFeignService {
    @Override
    public Result getById(Long id) {
        return null;
    }

    @Override
    public Result testTimeOut() {
        return null;
    }

    @Override
    public Result create(PayCreateForm payCreateForm) {
        return Result.failureParam("fallback");
    }
}
