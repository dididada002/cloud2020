package com.jt.dubbo.model;

import java.io.Serializable;

/**
 * @author: jingteng
 * @date: 2020/6/4 20:51
 */
public class TestBean implements Serializable {
    private String name;
    private Long id;
    private Integer num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }


}
