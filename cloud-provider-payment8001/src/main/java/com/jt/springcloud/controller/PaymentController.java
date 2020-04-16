package com.jt.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.jt.springcloud.entity.Payment;
import com.jt.springcloud.modul.request.PayCreateForm;
import com.jt.springcloud.modul.vo.Result;
import com.jt.springcloud.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @PostMapping("/create")
    public Result create(@RequestBody PayCreateForm form){
        log.info("pay.create requestbody: " + JSON.toJSONString(form));
        Payment bean = new Payment();
        BeanUtils.copyProperties(form,bean);
        long result = payService.create(bean);
        log.info("pay.create result: " + result);
        Result success = Result.success(result);
        success.setMsg("port; "+ port);
        return success;
    }

    @GetMapping("/get/by/{id}")
    public Result getById(@PathVariable("id") Long id){
        log.info("pay.getById requestbody: " + id);
        Payment result = payService.getById(id);
        log.info("pay.getById requestbody: " + result.toString());
        Result success = Result.success(result);
        success.setMsg("port; "+ port);
        return success;
    }


    /**
     * 获取该服务对外暴露的服务信息
     * */
    @GetMapping("/service/list")
    public Object descovery(){

        //获取全部服务的信息
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> {
            log.info("***element : " + service);
        });

        //根据服务ID获取服务信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            log.info("instance信息：" + JSON.toJSONString(instance));
        });
        return this.discoveryClient;
    }

}
