package com.jt.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author: jingteng
 * @date: 2020/4/22 22:00
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class RabbitMQMain8771 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQMain8771.class,args);
    }
}
