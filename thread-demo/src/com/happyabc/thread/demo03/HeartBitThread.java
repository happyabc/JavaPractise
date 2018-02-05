package com.happyabc.thread.demo03;

public class HeartBitThread implements Runnable {


    private long time;
    private boolean flag = false;

    public HeartBitThread(long time) {
        this.time = time;
    }

    public HeartBitThread() {
    }

    @Override
    public synchronized void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " is Running");
        if (flag) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
