package com.jt.sharding.interfaces;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author: jingteng
 * @date: 2020/5/8 22:33
 */
@Mapper
@Component
public interface OrderMapper {

    @Insert("insert into t_order(price,user_id,order_status) values (#{price},#{userId},#{status})")
    int insertOrder(@Param("price")BigDecimal price,@Param("userId")Long userId,@Param("status")String status);
}
