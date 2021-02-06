package com.sinlov.java.playground.lock.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CASABAQuestion {
    private static final AtomicInteger index = new AtomicInteger(10);

    public static void main(String[] args) {
        new Thread(() -> {
            index.compareAndSet(10, 11);
            boolean isSuccess = index.compareAndSet(11, 10);
            System.out.println(Thread.currentThread().getName() +
                    "： 10->11->10 isSuccess: " + isSuccess +
                    " now: " + +index.get());
        }, "bob").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                boolean isSuccess = index.compareAndSet(10, 12);
                System.out.println(Thread.currentThread().getName() +
                        "： index want 10, isSuccess: " + isSuccess
                        + " new set: " + index.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "lee").start();
    }
}
