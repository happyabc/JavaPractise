package com.happyabc.thread.demo01;

public class TicketThread extends Thread {
    private int num = 20;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (num <= 0) {
                return;
            } else {
                num--;
                System.out.println(Thread.currentThread().getName() + "目前剩余票数：" + " " + num);
            }
        }
    }
}
