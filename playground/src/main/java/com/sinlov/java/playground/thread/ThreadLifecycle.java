package com.sinlov.java.playground.thread;

/**
 * lifecycle in {@link Thread.State}
 */
public class ThreadLifecycle {

    private Runnable runnable;

    public void newThread(Runnable runnable) {
        this.runnable = runnable;
    }

    private void checkRunnable() {
        if (runnable == null) {
            throw new NullPointerException("runnable is empty");
        }
    }

    public void onRunnable() {
        checkRunnable();
        System.out.println("in runnable");
    }

    public void onRunning() {
        checkRunnable();
        System.out.println("in running");
    }

    public void onBlocked() {
        checkRunnable();
        System.out.println("in blocked");
    }

    public void onWaiting() {
        checkRunnable();
        System.out.println("in waiting");
    }

    public void onTimedWaiting() {
        checkRunnable();
        System.out.println("in time waiting");
    }

    public void onTerminated() {
        checkRunnable();
        System.out.println("in terminated");
    }
}
