package com.happyabc.loadindex;

public class Animal {
    final int a = 9;

    static {
        System.out.println(" 我在Animal 的static中");
    }

    Animal() {

        System.out.println(" 我在Animal 的构造方法中");
    }

    final void eat() {

        System.out.println(" 我在吃食物" + a);
    }

    void eat(String food) {
        System.out.println(" 我在吃食物");
    }
}
