package com.happyabc.abs;

public class Test {

    static void hook(AbaMyFrame i) {
        i.paint();
    }

    public static void main(String[] args) {
        hook(new MyFrame());
    }
}