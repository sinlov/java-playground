package com.sinlov.java.playground.lock.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CASABAResolve {
    static AtomicStampedReference<Integer> index
            = new AtomicStampedReference<Integer>(10, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            int stamp = index.getStamp();
            System.out.println(Thread.currentThread().getName()
                    + " the version 1: " + stamp);
            index.compareAndSet(10, 11, index.getStamp(), index.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()
                    + " the version 2: " + index.getStamp());
            index.compareAndSet(11, 10, index.getStamp(), index.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()
                    + " the version 3: " + index.getStamp());
        }, "bob").start();

        new Thread(() -> {
            try {
                int stamp = index.getStamp();
                System.out.println(Thread.currentThread().getName()
                        + " the version 1: " + stamp);
                TimeUnit.SECONDS.sleep(2);
                boolean isSuccess = index.compareAndSet(10, 12,
                        index.getStamp(), index.getStamp() + 1);
                System.out.println(Thread.currentThread().getName()
                        + " this change isSuccess： " + isSuccess + " now version: " + index.getStamp());
                System.out.println(Thread.currentThread().getName()
                        + " now index: " + index.getReference());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "lee").start();
    }
}
