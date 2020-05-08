package com.jt.sharding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: jingteng
 * @date: 2020/5/8 0:09
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableDiscoveryClient
public class OrderProviderMain8331 {
    public static void main(String[] args) {
        SpringApplication.run(OrderProviderMain8331.class,args);
    }
}
