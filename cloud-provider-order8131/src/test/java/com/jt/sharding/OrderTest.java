package com.jt.sharding;

import com.jt.sharding.interfaces.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author: jingteng
 * @date: 2020/5/8 22:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderProviderMain8331.class)
public class OrderTest {
    @Autowired
    private OrderMapper orderMapper;
    @Test
    public void testInsert(){
        orderMapper.insertOrder(new BigDecimal("12.2"),1L,"success");
    }
}
