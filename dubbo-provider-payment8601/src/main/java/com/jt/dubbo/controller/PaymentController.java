package com.jt.dubbo.controller;

import com.alibaba.fastjson.JSON;
import com.jt.dubbo.interfaces.PayService;
import com.jt.dubbo.model.TestBean;
import com.jt.springcloud.modul.request.PayCreateForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public List<TestBean> create(@RequestBody PayCreateForm form){
        log.info("pay.create requestbody: " + JSON.toJSONString(form));
        List<TestBean> result = payService.test(form.getSerial());
        log.info("pay.create result: " + result);
        return result;
    }

}
