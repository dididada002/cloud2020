package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)   //手动加载ribbon负载均衡算法
public class NacosOrderMain8611 {
    public static void main(String[] args) {
        SpringApplication.run(com.jt.springcloud.NacosOrderMain8611.class,args);
    }
}
