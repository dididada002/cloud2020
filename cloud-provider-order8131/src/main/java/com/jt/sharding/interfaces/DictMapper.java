package com.jt.sharding.interfaces;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author: jingteng
 * @date: 2020/5/10 11:36
 */
@Mapper
@Component
public interface DictMapper {
    int insert(@Param("dictId")Long dictId, @Param("type")String type, @Param("code")String code, @Param("value")String value);
}
