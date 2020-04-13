package com.jt.springcloud.controller;

import com.jt.springcloud.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jingteng
 * @date: 2020/4/13 23:44
 */
@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Autowired
    private PayService payService;


}
