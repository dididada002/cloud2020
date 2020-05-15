package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: jingteng
 * @date: 2020/4/13 22:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentMain8014 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain8014.class,args);
    }
}
