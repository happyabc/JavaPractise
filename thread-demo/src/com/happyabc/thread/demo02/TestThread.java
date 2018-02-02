package com.happyabc.thread.demo02;

import com.happyabc.thread.demo02.TicketThread;

class TestThread {
    public static void main(String[] args) {
        /**
         * 共同的线程处理对象，跑两个线程来处理
         */

        TicketThread ticketThread = new TicketThread();

        new Thread(ticketThread, "工人").start();
        new Thread(ticketThread, "学生").start();
    }
}


