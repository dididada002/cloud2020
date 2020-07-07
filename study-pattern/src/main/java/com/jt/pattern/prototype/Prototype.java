package com.jt.pattern.prototype;

import java.io.*;

/**
 * @author: jingteng
 * @date: 2020/7/7 18:27
 */
public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A("111", 123,new C(123123123));
        A b = a.deepClone();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
class C implements Serializable {
    private int testa;

    public C(int testa) {
        this.testa = testa;
    }
}

class A implements Cloneable, Serializable {
    private String name;
    private int age;
    private C c;

    public A(String name, int age, C c) {
        this.name = name;
        this.age = age;
        this.c = c;
    }

    @Override
    protected A clone() throws CloneNotSupportedException {
        return (A) super.clone();
    }

    //深拷贝--序列化
    public A deepClone(){
        //创建流对象
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            A copyValue = (A)ois.readObject();
            return copyValue;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                ois.close();
                bos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
