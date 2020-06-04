package com.jt.dubbo.controller;

import com.jt.dubbo.model.TestBean;
import com.jt.dubbo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: jingteng
 * @date: 2020/6/4 22:20
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class TestController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/test")
    public List<TestBean> test(){
        log.info("into order.test ");
        List<TestBean> test = orderService.test("123");
        return test;
    }
}
