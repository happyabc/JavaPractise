package com.happyabc.thread.notify;

public class T2 implements Runnable {
    private Object object;

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "is startd");
            try {
                object.notify();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "is end");
        }

    }
}
