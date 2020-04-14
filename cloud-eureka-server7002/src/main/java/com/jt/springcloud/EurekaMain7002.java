package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: jingteng
 * @date: 2020/4/14 22:55
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
    /**
    * http://eureka7002.com:7002/
    * */
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class);
    }
}
