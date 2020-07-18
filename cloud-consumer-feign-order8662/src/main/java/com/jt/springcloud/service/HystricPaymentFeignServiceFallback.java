package com.jt.springcloud.service;

import com.jt.springcloud.modul.request.HysTestForm;
import com.jt.springcloud.modul.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: jingteng
 * @date: 2020/7/17 11:57
 * 异常时调用相关方法
 */
@Component
@Slf4j
public class HystricPaymentFeignServiceFallback implements HystricPaymentFeignService {
    @Override
    public Result testOk(HysTestForm form) {
        String result = "异常时调用，线程池 "  + Thread.currentThread().getName() + ".....testOk    id:   " +form.getId();
        log.info(result);
        return Result.failureParam(result);
    }

    @Override
    public Result testTimeOut(HysTestForm form) {
        String result = "异常时调用，线程池 "  + Thread.currentThread().getName() + ".....testTimeOut    id:   " +form.getId();
        log.info(result);
        return Result.failureParam(result);
    }
}
