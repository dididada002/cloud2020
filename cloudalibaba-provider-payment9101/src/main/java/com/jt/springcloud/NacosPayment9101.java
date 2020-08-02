package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: jingteng
 * @date: 2020/8/2 16:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosPayment9101 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPayment9101.class,args);
    }
}
