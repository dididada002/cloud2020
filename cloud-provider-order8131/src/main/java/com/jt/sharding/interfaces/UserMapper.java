package com.jt.sharding.interfaces;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author: jingteng
 * @date: 2020/5/10 11:20
 */
@Mapper
@Component
public interface UserMapper {
    int insertUser(@Param("userId") Long userId, @Param("userName") String userName, @Param("status") Byte status);
}
