package com.jt.springcloud.service.impl;

import com.jt.springcloud.entity.Order;
import com.jt.springcloud.interfaces.OrderMapper;
import com.jt.springcloud.model.request.OrderForm;
import com.jt.springcloud.modul.request.PayCreateForm;
import com.jt.springcloud.modul.vo.Result;
import com.jt.springcloud.service.OrderService;
import com.jt.springcloud.service.PaymentFeignService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: jingteng
 * @date: 2020/6/5 19:32
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private PaymentFeignService paymentFeignService;

    @Autowired
    private OrderMapper orderMapper;

    @GlobalTransactional
    @Transactional
    @Override
    public Result create(OrderForm form) {
        log.info("付款服务 XID: " + RootContext.getXID());
        Order order = new Order();
        order.setId(4L);
        order.setPrice(form.getPrice());
        order.setOrderStatus(0);
        order.setUpdateTime(new Date());
        orderMapper.updateByPrimaryKey(order);

        PayCreateForm payCreateForm = new PayCreateForm();
        payCreateForm.setSerial("4444444");
        Result payResult = paymentFeignService.create(payCreateForm);
        if (true){
            throw new RuntimeException("订单微服务测试失败！");
        }
        if ("fallback".equals(payResult.getMsg())){
            throw new RuntimeException("调用测试微服务失败！");
        }
        return null;
    }
}
