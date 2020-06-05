package com.jt.springcloud.service.impl;

import com.jt.springcloud.entity.Order;
import com.jt.springcloud.interfaces.OrderMapper;
import com.jt.springcloud.model.request.OrderForm;
import com.jt.springcloud.modul.request.PayCreateForm;
import com.jt.springcloud.modul.vo.Result;
import com.jt.springcloud.service.OrderService;
import com.jt.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: jingteng
 * @date: 2020/6/5 19:32
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private PaymentFeignService paymentFeignService;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Result create(OrderForm form) {
        Order order = new Order();
        order.setPrice(form.getPrice());
        order.setOrderStatus(0);
        order.setUpdateTime(new Date());
        orderMapper.insert(order);

        PayCreateForm payCreateForm = new PayCreateForm();
        payCreateForm.setSerial("123123");
        Result payResult = paymentFeignService.create(payCreateForm);
        return null;
    }
}
