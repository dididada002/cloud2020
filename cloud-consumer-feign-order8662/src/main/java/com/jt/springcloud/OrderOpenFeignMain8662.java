package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: jingteng
 * @date: 2020/4/20 23:07
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderOpenFeignMain8662 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain8662.class,args);
    }
}
