package jt.rabbitmq;

import com.jt.rabbitmq.SpringRabbitMQMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: jingteng
 * @date: 2020/6/4 16:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringRabbitMQMain.class)
public class Test1 {

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Test
    public void testAdmin(){
        rabbitAdmin.declareExchange(new DirectExchange("test1.direct",false,false));
        rabbitAdmin.declareExchange(new TopicExchange("test1.topic",false,false));
        rabbitAdmin.declareExchange(new FanoutExchange("test1.fanout",false,false));
    }
}
