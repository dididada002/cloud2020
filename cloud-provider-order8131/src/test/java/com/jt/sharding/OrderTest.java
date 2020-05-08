package com.jt.sharding;

import com.alibaba.fastjson.JSON;
import com.jt.sharding.interfaces.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        for (int i = 0; i < 10; i++) {
            orderMapper.insertOrder(new BigDecimal(i),1L,"success");
        }
    }

    @Test
    public void testSelect(){
        List<Long> idList = new ArrayList<>();
        idList.add(465649694131879936L);
        idList.add(465649694186405888L);
        idList.add(465648797230301185L);
        List<Map> maps = orderMapper.selectOrderListByIdList(idList);
        System.out.println(JSON.toJSON(maps));
    }

    @Test
    public void testSelectNoOrderId(){
        List<Map> maps = orderMapper.selectOrderListByUserId(1L);
        System.out.println(JSON.toJSON(maps));
    }
}
