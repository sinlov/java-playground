package com.sinlov.java.playground.thread.customthreadpool;

public class DescendingCustomThread extends Thread implements Comparable<DescendingCustomThread> {

    private final int tPriority;

    public int gettPriority() {
        return tPriority;
    }

    public DescendingCustomThread(int priority, String name) {
        super(name);
        tPriority = priority;
    }

    @Override
    public int compareTo(DescendingCustomThread o) {
        return o.gettPriority() - tPriority;
    }
}
