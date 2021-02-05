package com.sinlov.java.playground.thread;

public class LockUnSafeDemo implements Runnable {

    public static final int COUNT = 100;
    private static int a = 0;

    @Override
    public void run() {
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
