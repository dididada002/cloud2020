package com.jt.rabbitmq.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: jingteng
 * @date: 2020/4/22 22:25
 */
@Component
public class WorkConsumer {

    /**
     * 默认在Spring AMQP实现中Work这种方式是公平调度，如果需要实现能者多劳需要额外配置
     * */
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String msg){
        System.out.println("work.message1: " + msg);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String msg){
        System.out.println("work.message2: " + msg);
    }
}
