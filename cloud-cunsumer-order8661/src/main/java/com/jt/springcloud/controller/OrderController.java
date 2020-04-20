package com.jt.springcloud.controller;

import com.jt.springcloud.lb.LoadBalancer;
import com.jt.springcloud.modul.request.PayCreateForm;
import com.jt.springcloud.modul.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author: jingteng
 * @date: 2020/4/14 21:26
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

//    public static final String url = "http://localhost:8001";
    public static final String url = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/pay")
    public Result create(@RequestBody PayCreateForm form){
        return restTemplate.postForObject(url + "/pay/create",form,Result.class);

    }

    @GetMapping("/get/by/{id}")
    public Result getById(@PathVariable("id") Long id){
        return restTemplate.getForObject(url + "/pay/get/by/"+id,Result.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        //根据服务ID获取服务信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/pay/lb",String.class);

    }
}
