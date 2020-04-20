package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: jingteng
 * @date: 2020/4/20 23:07
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeignMain8661 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain8661.class,args);
    }
}
