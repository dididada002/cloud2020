package com.jt.springcloud.controller;

import com.jt.springcloud.model.request.OrderForm;
import com.jt.springcloud.modul.vo.Result;
import com.jt.springcloud.service.OrderService;
import com.jt.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: jingteng
 * @date: 2020/4/20 23:27
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderOpenFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/pay")
    public Result create(@RequestBody OrderForm form){
        return orderService.create(form);
    }

    @GetMapping("/get/by/{id}")
    public Result getById(@PathVariable("id") Long id){
        return paymentFeignService.getById(id);
    }

    @GetMapping("/test/time/out")
    public Result testTimeOut(){
        return paymentFeignService.testTimeOut();
    }
}
