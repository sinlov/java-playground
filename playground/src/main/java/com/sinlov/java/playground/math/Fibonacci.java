package com.sinlov.java.playground.math;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 17/6/15.
 */
public class Fibonacci {

    public static long fibonacci(long n) {
        if (n <= 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static long fibonacciNormal(long n) {
        if (n <= 2) {
            return 1;
        }
        int n1 = 1, n2 = 1, sn = 0;
        for (int i = 0; i < n - 2; i++) {
            sn = n1 + n2;
            n1 = n2;
            n2 = sn;
        }
        return sn;
    }

}
