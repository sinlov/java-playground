package com.sinlov.java.playground.lock.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo extends Thread {
    private static final int COUNT = 100;
    private final String alias;
    private final ReentrantLock lock;
    private static int counter = 0;

    public String getAlias() {
        return alias;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            lock.lock();
            try {
                TimeUnit.MICROSECONDS.sleep(10);
                System.out.println("counter = " + counter);
                counter++;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public ReentrantLockDemo(String alias, boolean fair) {
        this.alias = alias;
        this.lock = new ReentrantLock(fair);
    }

    public static void main(String[] args) {
        ReentrantLockDemo bob = new ReentrantLockDemo("bob", false);
        ReentrantLockDemo lee = new ReentrantLockDemo("lee", false);

        try {
            bob.start();
            lee.start();
            bob.join();
            lee.join();
            System.out.println("ReentrantLockDemo.counter = " + ReentrantLockDemo.counter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
