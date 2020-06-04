package com.jt.dubbo.service.impl;

import com.jt.dubbo.interfaces.PayService;
import com.jt.dubbo.model.TestBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jingteng
 * @date: 2020/6/4 20:50
 */
@Service//暴露服务注解
@com.alibaba.dubbo.config.annotation.Service
public class PayServiceImpl implements PayService {
    @Override
    public List<TestBean> test(String serial) {
        List<TestBean> result = new ArrayList<>();
        TestBean testBean1 = new TestBean();
        testBean1.setName("name1");
        testBean1.setId(1L);
        testBean1.setNum(1);
        result.add(testBean1);

        TestBean testBean2 = new TestBean();
        testBean2.setName("name2");
        testBean2.setId(2L);
        testBean2.setNum(2);
        result.add(testBean2);

        return result;
    }
}
