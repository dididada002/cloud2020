package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: jingteng
 * @date: 2020/8/2 16:33
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrder9661 {
    public static void main(String[] args) {
        SpringApplication.run(NacosOrder9661.class,args);
    }
}
