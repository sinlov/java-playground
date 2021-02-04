package com.sinlov.java.playground.thread;

public class LockSafeDemo implements Runnable {

    public static final int COUNT = 10000;
    private static int a = 0;

    @Override
    public synchronized void run() {
        for (int i = 0; i < COUNT; i++) {
            a++;
        }
    }

    public int getA() {
        return a;
    }
}
