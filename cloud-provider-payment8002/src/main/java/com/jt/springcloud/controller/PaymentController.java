package com.jt.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.jt.springcloud.entity.Payment;
import com.jt.springcloud.modul.request.PayCreateForm;
import com.jt.springcloud.modul.vo.Result;
import com.jt.springcloud.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: jingteng
 * @date: 2020/4/13 23:44
 */
@RestController
@RequestMapping("/pay")
@Slf4j
public class PaymentController {

    @Autowired
    private PayService payService;

    @PostMapping("/create")
    public Result create(@RequestBody PayCreateForm form){
        log.info("pay.create requestbody: " + JSON.toJSONString(form));
        Payment bean = new Payment();
        BeanUtils.copyProperties(form,bean);
        long result = payService.create(bean);
        log.info("pay.create result: " + result);
        return Result.success(result);
    }

    @GetMapping("/get/by/{id}")
    public Result getById(@PathVariable("id") Long id){
        log.info("pay.getById requestbody: " + id);
        Payment result = payService.getById(id);
        log.info("pay.getById requestbody: " + result.toString());
        return Result.success(result);
    }


}