package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: jingteng
 * @date: 2020/4/14 21:22
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain8661 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8661.class,args);
    }
}
