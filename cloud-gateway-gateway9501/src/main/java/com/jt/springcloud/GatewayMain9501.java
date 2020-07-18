package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: jingteng
 * @date: 2020/7/18 20:11
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9501 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9501.class,args);
    }
}
