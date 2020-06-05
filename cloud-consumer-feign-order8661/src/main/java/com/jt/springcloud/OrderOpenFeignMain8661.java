package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: jingteng
 * @date: 2020/4/20 23:07
 * 分布式事务：seata
 *      客户端TC的版本：0.7.1
 *      TM、RM的maven版本：2.1.0
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeignMain8661 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain8661.class,args);
    }
}
