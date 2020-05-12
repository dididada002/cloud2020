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


    public static final String serviceId = "CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/pay")
    public Result create(@RequestBody PayCreateForm form){
        URI uri = getUriByInstanceName(serviceId);
        return restTemplate.postForObject(uri + "/pay/create",form,Result.class);

    }

    @GetMapping("/get/by/{id}")
    public Result getById(@PathVariable("id") Long id){
        URI uri = getUriByInstanceName(serviceId);
        return restTemplate.getForObject(uri + "/pay/get/by/"+id,Result.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        URI uri = getUriByInstanceName(serviceId);
        return restTemplate.getForObject(uri+"/pay/lb",String.class);

    }
    private URI getUriByInstanceName(String instanseName){
        List<ServiceInstance> instances = discoveryClient.getInstances(instanseName);
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(instances);
        return instance.getUri();
    }
}
