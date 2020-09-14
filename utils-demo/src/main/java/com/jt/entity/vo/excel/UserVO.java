package com.jt.entity.vo.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: jingteng
 * @date: 2020/9/14 22:06
 */
@Data
public class UserVO extends BaseRowModel implements Serializable {
    private static final long serialVersionUID = -5227895893890004504L;
    @ExcelProperty(value = "id",index = 0)
    private Integer id;
    @ExcelProperty(value = "姓名",index = 1)
    private String name;
}
