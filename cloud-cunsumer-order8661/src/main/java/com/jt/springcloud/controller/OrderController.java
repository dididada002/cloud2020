package com.jt.springcloud.controller;

import com.jt.springcloud.modul.request.PayCreateForm;
import com.jt.springcloud.modul.vo.Result;
import lombok.extern.slf4j.Slf4j;
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

    public static final String url = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/pay")
    public Result create(@RequestBody PayCreateForm form){
        return restTemplate.postForObject(url + "/pay/create",form,Result.class);

    }

    @GetMapping("/get/by/{id}")
    public Result getById(@PathVariable("id") Long id){
        return restTemplate.getForObject(url + "/pay/get/by/"+id,Result.class);
    }
}
