package com.sinlov.java.playground.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    public static final long taskUntilFinished = 2 * 1000l;
    public static final int RUN_COUNT = 30;
    private long nowTimeCount = 0;
    private long fibonacciCount = 0;
    private long fibonacciStart = 3;
    private long timeMark = 0;

    @Test
    public void fibonacci() {
        timeMark = System.currentTimeMillis();
        int n = RUN_COUNT;
        for (int i = 1; i <= n; i++) {
            nowTimeCount = nowTimeCount + taskUntilFinished;
            if (nowTimeCount > fibonacciCount) {
                fibonacciCount = Fibonacci.fibonacci(fibonacciStart++) * 1000;
                System.out.println("i = " + i + " |nowTimeCount: " + nowTimeCount);
                System.out.println(Fibonacci.fibonacci(fibonacciStart));
                System.out.println(fibonacciCount);
            }
        }
        System.out.println("Time use: " + (System.currentTimeMillis() - timeMark));
    }

    @Test
    public void fibonacciNormal() {
        int n = RUN_COUNT;
        for (int i = 1; i <= n; i++) {
            nowTimeCount = nowTimeCount + taskUntilFinished;
            if (nowTimeCount > fibonacciCount) {
                fibonacciCount = Fibonacci.fibonacciNormal(fibonacciStart++) * 1000;
                System.out.println("i = " + i + " |nowTimeCount: " + nowTimeCount);
                System.out.println(Fibonacci.fibonacciNormal(fibonacciStart));
                System.out.println(fibonacciCount);
            }
        }
    }
}