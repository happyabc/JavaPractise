package com.happyabc.abs;

public abstract class AbaMyFrame {
    /**
     * 抽象类中的方法必须有方法体，没有方法体，则该方法为抽象方法；
     * 子类不一定要重写父类的所有方法。
     * implement和extends 继承的区别
     * 重写implement的方法不用@override，extends 需要@override。
     */
    void paint() {

    }

    abstract String getResult();
    
    abstract  int add();
}

