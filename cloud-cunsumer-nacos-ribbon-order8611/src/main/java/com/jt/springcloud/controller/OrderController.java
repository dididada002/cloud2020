package com.jt.springcloud.controller;

import com.jt.springcloud.modul.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

/**
 * @author: jingteng
 * @date: 2020/4/14 21:26
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

//    public static final String url = "http://localhost:8001";
//区分大小写，和服务端应用名大小写一样
    public static final String url1 = "http://cloud-payment-nacos-service1";
    public static final String url2 = "http://cloud-payment-nacos-service2";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;


    @GetMapping("/get/bySer1/{id}")
    public Result getByIdSer1(@PathVariable("id") Long id){
        return restTemplate.getForObject(url1 + "/pay/get/by/"+id,Result.class);
    }

    @GetMapping("/get/bySer2/{id}")
    public Result getByIdSer2(@PathVariable("id") Long id){
        return restTemplate.getForObject(url2 + "/pay/get/by/"+id,Result.class);
    }
}
