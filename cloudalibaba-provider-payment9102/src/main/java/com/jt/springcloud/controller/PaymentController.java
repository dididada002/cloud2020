package com.jt.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.jt.springcloud.modul.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: jingteng
 * @date: 2020/4/13 23:44
 */
@RestController
@RequestMapping("/nacos/pay")
@Slf4j
public class PaymentController {

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @GetMapping("/lb/{id}")
    public String getPaymentPort(@PathVariable Integer id){
        return "nacos service port : " + port + " ，接收到的id为 ： " + id;
    }

    @GetMapping("/test/time/out")
    public Result testTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Result.success("nacos service port : " + port);
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
