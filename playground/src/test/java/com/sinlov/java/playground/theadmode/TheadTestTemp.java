package com.sinlov.java.playground.theadmode;

public class TheadTestTemp {
    protected static void go(Runnable runnable) {
        new Thread(runnable).start();
    }
}
