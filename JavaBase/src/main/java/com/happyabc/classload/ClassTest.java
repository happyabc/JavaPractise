package com.happyabc.classload;

public class ClassTest {
    private static final  int a=2*3;//编译时常量
    public static final int b=(int)(Math.random()*5); //不是编译时常量,主动使用，会导致类的初始化。
    static {
        System.out.println(" ClassTest init!");
    }
    public static void main(String[] args) {
        System.out.println("a="+ClassTest.a);

    }
}
