package com.sinlov.java.playground.thread;

public class LockUnSafeDemo implements Runnable {

    public static final int COUNT = 100000;
    private static int a = 0;

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            a++;
        }
    }

    public int getA() {
        return a;
    }
}
