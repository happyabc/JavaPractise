package com.happyabc.loadindex;

public class Dog extends Animal {
    static {
        System.out.println(" 我在Dog 的static中");
    }

    Dog() {

        System.out.println(" 我在Dog 的 构造方法中" + super.a);
    }

    void wang() {

    }

}
