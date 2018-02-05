package com.happyabc.thread.notify;

public class MonitorDemo {

    public static void main(String[] args) {
        System.out.println("ID="+Thread.currentThread().getId());
        System.out.println("Name="+Thread.currentThread().getName());
        System.out.println("Priority="+Thread.currentThread().getPriority());
        System.out.println("is alive="+Thread.currentThread().isAlive());
        System.out.println("is demon="+Thread.currentThread().isDaemon());

        System.out.println("Count0="+Thread.activeCount());
        Object object = new Object();
        T1 t1 = new T1();
        t1.setObject(object);
        T2 t2 = new T2();
        t2.setObject(object);
        new Thread(t1, "T1").start();
        new Thread(t2, "T2").start();
        System.out.println("Count1="+Thread.activeCount());
    }
}
