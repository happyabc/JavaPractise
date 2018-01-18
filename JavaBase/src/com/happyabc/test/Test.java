package com.happyabc.test;

public class Test {

    static void hook(IMyFrame i) {
        i.paint();
    }

    public static void main(String[] args) {
        hook(new MyFrame());
    }
}