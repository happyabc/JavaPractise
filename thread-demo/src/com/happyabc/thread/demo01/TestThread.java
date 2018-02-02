package com.happyabc.thread.demo01;

import com.happyabc.thread.demo01.TicketThread;

class TestThread {
    public static void main(String[] args) {
        /**
         * 这里是两个线程对象，执行自己各自的方法栈
         */
        TicketThread t1 = new TicketThread();
        TicketThread t2 = new TicketThread();
        t1.start();
        t2.start();
    }
}


