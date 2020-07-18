package com.jt.springcloud.model.request;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: jingteng
 * @date: 2020/6/5 19:26
 */
@Data
public class OrderForm {
    private BigDecimal price;
}
