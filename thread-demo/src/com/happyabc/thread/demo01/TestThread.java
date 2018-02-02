package com.happyabc.thread.demo01;

import com.happyabc.thread.demo01.TicketThread;

class TestThread {
    public static void main(String[] args) {
        /**
         * 这里是两个线程对象，执行自己各自的方法栈
         */
        TicketThread ticketThread = new TicketThread();
        TicketThread ticketThread2 = new TicketThread();
        ticketThread.start();
        ticketThread2.start();
    }
}


