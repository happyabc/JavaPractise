package com.happyabc.thread.demo02;

public class TicketThread implements Runnable {
    private  int num = 20;

    @Override
    public  void run() {
        while (true) {
            synchronized (this){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (num == 0) {
                    return;
                } else {
                    num--;
                    System.out.println(Thread.currentThread().getName() + "目前剩余票数：" + " " + num);
                }
            }
        }
    }
}
