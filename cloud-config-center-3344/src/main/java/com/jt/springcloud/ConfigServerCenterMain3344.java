package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: jingteng
 * @date: 2020/7/18 23:14
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerCenterMain3344.class,args);
    }
}
