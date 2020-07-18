package com.jt.springcloud.service.impl;

import com.jt.springcloud.entity.Payment;
import com.jt.springcloud.interfaces.PaymentMapper;
import com.jt.springcloud.modul.request.HysTestForm;
import com.jt.springcloud.modul.vo.Result;
import com.jt.springcloud.service.PayService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: jingteng
 * @date: 2020/4/13 23:45
 */
@Service
@Slf4j
@DefaultProperties(defaultFallback = "globalHandler")//异常全局处理降级
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

    @Override
    /*@HystrixCommand(fallbackMethod = "testTimeOutHandler",commandProperties = {//规定这个接口被调用在多长时间内属于正常范围
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" ,value = "2000")
    })*/
    @HystrixCommand
    public Result testTimeOut(HysTestForm form) {
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String result = "线程池 "  + Thread.currentThread().getName() + ".....timeout    id:   " +form.getId();
        log.info(result);
        return Result.success(result);
    }

    public Result globalHandler(){
        return Result.successBusFail("我是客户端，我出错了。。。进行全局处理。。进行降级");
    }

    //豪猪客提供的兜底方法
    public Result testTimeOutHandler(HysTestForm form) {
        String result = "超时了，线程池 "  + Thread.currentThread().getName() + ".....testTimeOutHandler    id:   " +form.getId();
        log.info("超时后调用的方法：     "+result);
        return Result.success(result);
    }

    @Override
    public Result testOk(HysTestForm form) {
        String result = "线程池 "  + Thread.currentThread().getName() + ".....testOk    id:   " +form.getId();
        log.info(result);
        return Result.success(result);
    }

    @Override
    @HystrixCommand(fallbackMethod = "testRongDuan_handler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "3"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "20"),//失败率达到多少后跳闸
    })
    public Result testRongDuan(Integer id) {
        if (id > 0){
            throw new RuntimeException("****  id 不能为负数  异常");
        }
        return Result.success("服务的熔断测试成功。。。。");
    }

    public Result testRongDuan_handler(Integer id) {
        return Result.failureParam("id 不能为负数，发生错误了");
    }
}
