package com.jt.pattern.proxy.staticproxy;

/**
 * @author: jingteng
 * @date: 2020/6/11 0:49
 */
public class TeacherDao implements ITeachetDao {
    @Override
    public void teach() {
        System.out.println("老师授课中。。。");
    }
}
