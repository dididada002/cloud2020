package com.jt.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: jingteng
 * @date: 2020/4/22 22:48
 */
@Component
public class TopicConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//如果不指定值，默认绑定的是临时队列
                    exchange = @Exchange(value = "topics",type = "topic"),//自定义交换机类型和名称
                    key = {"user.save","user.*"}
            )
    })
    public void receive1(String msg) {
        System.out.println("topic.message1: " + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//如果不指定值，默认绑定的是临时队列
                    exchange = @Exchange(value = "topics",type = "topic"),//自定义交换机类型和名称
                    key = {"user.save","user.#"}
            )
    })
    public void receive2(String msg) {
        System.out.println("topic.message2: " + msg);
    }
}
