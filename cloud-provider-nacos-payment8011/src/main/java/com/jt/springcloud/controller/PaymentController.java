package com.jt.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.jt.springcloud.entity.Payment;
import com.jt.springcloud.modul.vo.Result;
import com.jt.springcloud.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @author: jingteng
 * @date: 2020/4/13 23:44
 */
@RestController
@RequestMapping("/pay")
@Slf4j
public class PaymentController {


    @Resource
    private DiscoveryClient discoveryClient;

    @Autowired
    private PayService payService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/get/by/{id}")
    public Result getById(@PathVariable("id") Long id){
        log.info("pay.getById requestbody: " + id);
        log.info("我被请求了:{}",port);
        Payment result = payService.getById(id);
        log.info("pay.getById respondbody: " + JSON.toJSONString(result));
        Result success = Result.success(result);
        success.setMsg("port; "+ port);
        System.out.println();
        return success;
    }

}
