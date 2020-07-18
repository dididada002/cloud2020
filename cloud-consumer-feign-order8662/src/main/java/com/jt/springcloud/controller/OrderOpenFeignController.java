package com.jt.springcloud.controller;

import com.jt.springcloud.model.request.OrderForm;
import com.jt.springcloud.modul.request.HysTestForm;
import com.jt.springcloud.modul.vo.Result;
import com.jt.springcloud.service.HystricPaymentFeignService;
import com.jt.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jingteng
 * @date: 2020/4/20 23:27
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderOpenFeignController {
//    @Resource
//    private PaymentFeignService paymentFeignService;

    @Autowired
    private HystricPaymentFeignService hystricPaymentFeignService;

    @Autowired
    private OrderService orderService;


    @PostMapping("/hys/ok")
    public Result testOk(@RequestBody HysTestForm form){
        return hystricPaymentFeignService.testOk(form);
    }

    @PostMapping("/hys/rongduan")
    public Result testRongDuan(@RequestBody HysTestForm form){
        return hystricPaymentFeignService.testRongDuan(form);
    }

    @PostMapping("/hys/timeout")
    @HystrixCommand(fallbackMethod = "testTimeOutHandler",commandProperties = {//规定这个接口被调用在多长时间内属于正常范围
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" ,value = "1000")
    })
    public Result testTimeOut(@RequestBody HysTestForm form){
        return hystricPaymentFeignService.testTimeOut(form);
    }

    public Result testTimeOutHandler(@RequestBody HysTestForm form){
        return Result.successBusFail("我是客户端，我出错了。。。进行降级");
    }

    @PostMapping("/pay")
    public Result create(@RequestBody OrderForm form){
        return orderService.create(form);
    }


/*
    @GetMapping("/get/by/{id}")
    public Result getById(@PathVariable("id") Long id){
        return paymentFeignService.getById(id);
    }

    @GetMapping("/test/time/out")
    public Result testTimeOut(){
        return paymentFeignService.testTimeOut();
    }*/
}
