package com.jt.springcloud.controller;

import com.jt.springcloud.modul.vo.Result;
import com.jt.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/get/by/{id}")
    public Result getById(@PathVariable("id") Long id){
        return paymentFeignService.getById(id);
    }
}
