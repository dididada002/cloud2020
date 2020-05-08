package com.jt.sharding.interfaces;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author: jingteng
 * @date: 2020/5/8 22:33
 */
@Mapper
@Component
public interface OrderMapper {

    @Insert("insert into t_order(price,user_id,order_status) values (#{price},#{userId},#{status})")
    int insertOrder(@Param("price")BigDecimal price,@Param("userId")Long userId,@Param("status")String status);
/*
    @Select("<script> SELECT t.order_id,t.order_status,t.price,t.user_id" +
            "        FROM t_order AS t WHERE t.order_id IN " +
            "        <foreach collection='idList' open='(' close=')' item='id' separator=','>" +
            "            #{id}" +
            "        </foreach>" +"</script>")*/
    List<Map> selectOrderListByIdList(@Param("idList")List<Long> idList);

    List<Map> selectOrderListByUserId(@Param("userId")Long userId);

}
