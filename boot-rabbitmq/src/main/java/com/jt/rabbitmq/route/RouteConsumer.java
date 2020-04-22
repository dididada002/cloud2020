package com.jt.rabbitmq.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: jingteng
 * @date: 2020/4/22 22:42
 */
@Component
public class RouteConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//如果不指定值，默认绑定的是临时队列
                    exchange = @Exchange(value = "directs",type = "direct"),//自定义交换机类型和名称
                    key = {"info","error"}
            )
    })
    public void receive1(String msg) {
        System.out.println("direct.message1: " + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//如果不指定值，默认绑定的是临时队列
                    exchange = @Exchange(value = "directs",type = "direct"),//自定义交换机类型和名称
                    key = {"info","error","test"}
            )
    })
    public void receive2(String msg) {
        System.out.println("direct.message2: " + msg);
    }
}
