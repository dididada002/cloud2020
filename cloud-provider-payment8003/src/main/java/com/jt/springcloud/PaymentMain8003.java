package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: jingteng
 * @date: 2020/4/13 22:25
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8003.class,args);
    }
}
