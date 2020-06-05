package com.jt.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: jingteng
 * @date: 2020/6/4 20:44
 */
@SpringBootApplication
@EnableDubbo//开启基于注解的dubbo功能
public class PaymentMain8601 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8601.class,args);
    }
}
