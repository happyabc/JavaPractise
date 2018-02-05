package com.happyabc.thread.demo03;

public class MyHeart {

    public static void main(String[] args) {
        HeartBitThread myBit = new HeartBitThread(1000);
        Thread t1 = new Thread(myBit, "t1");
        Thread t2 = new Thread(myBit, "t2");
        t1.start();
        t2.start();
    }
}
