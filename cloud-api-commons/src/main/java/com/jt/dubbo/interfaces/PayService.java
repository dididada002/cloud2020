package com.jt.dubbo.interfaces;


import com.jt.dubbo.model.TestBean;

import java.util.List;

/**
 * @author: jingteng
 * @date: 2020/6/4 20:49
 */
public interface PayService {
    List<TestBean> test(String serial);
}
