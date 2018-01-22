package com.happyabc.loadindex;

public class TestResult {
    /**
     * 加载顺序
     *  1；父类的static
     *  2：子类的static
     *  3：父类的构造方法
     *  4：子类的构造方法
     *
     * @param args
     */
    public static void main(String[] args) {
        Animal d = new Dog();
        d.eat();

        Dog b=new Dog();
        b.eat();
    }
}
