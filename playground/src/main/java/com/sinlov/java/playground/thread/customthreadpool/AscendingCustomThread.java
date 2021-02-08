package com.sinlov.java.playground.thread.customthreadpool;

public class AscendingCustomThread extends Thread implements Comparable<AscendingCustomThread> {

    private final int tPriority;

    public int gettPriority() {
        return tPriority;
    }

    public AscendingCustomThread(int priority, String name) {
        super(name);
        tPriority = priority;
    }

    @Override
    public int compareTo(AscendingCustomThread o) {
        return tPriority - o.gettPriority();
    }
}
