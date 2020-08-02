package com.jt.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: jingteng
 * @date: 2020/8/2 16:38
 */
@RestController
@Slf4j
@RequestMapping("/nacos/order")
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String SERVER_URL;

    @GetMapping("/payment/info/{id}")
    public String paymentInfo(@PathVariable Integer id){
        return restTemplate.getForObject(SERVER_URL + "/nacos/pay/lb/" + id ,String.class);
    }
}
