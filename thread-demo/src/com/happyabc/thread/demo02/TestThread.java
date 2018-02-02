package com.happyabc.thread.demo02;

import com.happyabc.thread.demo02.TicketThread;

class TestThread {
    public static void main(String[] args) {
        /**
         * 这里是两个线程对象，执行自己各自的方法栈
         */


        TicketThread ticketThread = new TicketThread();
        TicketThread ticketThread2 = new TicketThread();

        new Thread(ticketThread, "工人").start();
        new Thread(ticketThread2, "学生").start();
    }
}


