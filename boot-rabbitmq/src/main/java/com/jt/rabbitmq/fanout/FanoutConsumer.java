package com.jt.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: jingteng
 * @date: 2020/4/22 22:33
 */
@Component
public class FanoutConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//如果不指定值，默认绑定的是临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")
            )
    })
    public void receive1(String msg) {
        System.out.println("fanout.message1: " + msg);
    }
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//如果不指定值，默认绑定的是临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")
            )
    })
    public void receive2(String msg){
        System.out.println("fanout.message2: " + msg);
    }
}
