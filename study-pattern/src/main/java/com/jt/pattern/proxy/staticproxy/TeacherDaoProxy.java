package com.jt.pattern.proxy.staticproxy;

/**
 * @author: jingteng
 * @date: 2020/6/11 0:49
 * 静态代理：代理对象
 */
public class TeacherDaoProxy implements ITeachetDao {

    //目标对象，通过接口来聚合
    private ITeachetDao target;

    public TeacherDaoProxy(ITeachetDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理。。");
        target.teach();
        System.out.println("结束代理。。。");
    }
}
