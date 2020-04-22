package com.jt.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: jingteng
 * @date: 2020/4/22 22:02
 */
@SpringBootTest(classes = RabbitMQMain8771.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //hello world
    @Test
    public void testHello(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    //work
    @Test
    public void testWork(){
        rabbitTemplate.convertAndSend("work","work模型");
    }
}
