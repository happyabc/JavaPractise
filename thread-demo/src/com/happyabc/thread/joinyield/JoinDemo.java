package com.happyabc.thread.joinyield;

public class JoinDemo implements Runnable {
    static volatile int b = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            b++;
        }
    }

    public static void main(String[] args) {
        JoinDemo joinDemo = new JoinDemo();
        Thread j = new Thread(joinDemo);
        j.start();
        try {
           // j.join();    加上是1000 不 加是0 或者很小的事情
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(b);
    }
}
