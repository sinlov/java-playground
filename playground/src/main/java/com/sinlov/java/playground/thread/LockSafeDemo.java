package com.sinlov.java.playground.thread;

public class LockSafeDemo implements Runnable {

    public static final int COUNT = 100;
    private static int a = 0;

    @Override
    public synchronized void run() {
        try {
            for (int i = 0; i < COUNT; i++) {
                Thread.sleep(1);
                a++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getA() {
        return a;
    }
}
