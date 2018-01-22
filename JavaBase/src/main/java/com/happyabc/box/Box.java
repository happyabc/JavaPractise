package com.happyabc.box;

import org.junit.Test;

public class Box {
    /**
     * 自动装箱
     * 从1.5之后支持自动装箱 ，在编译器帮助我们改进了代码。
     * 先编译器，再虚拟机
     *
     */
    @Test
    public  void box() {
        Integer a=new Integer(1000);
        Integer b=1000;
        Integer c=1000;
        /**
         *
         */
        System.out.println(b==c);
        System.out.println("i=(" + a + ")=" + a.getClass() + "@" + a.hashCode());
        System.out.println("i=(" + b + ")=" + b.getClass() + "@" + b.hashCode());

    }

    /**
     * 自动拆箱
     * 编译器帮忙在做
     * 
     */
    @Test
    public  void unbox() {
        Integer a=new Integer(1000);
        Integer b=1000;
        int c=b;
        System.out.println(c);

    }
}
