package com.sinlov.java.playground.thread;

import org.junit.Test;
import test.TempTest;

import static org.junit.Assert.*;

public class ThreadLifecycleTest extends TempTest {

    private ThreadLifecycle threadLifecycle;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        threadLifecycle = new ThreadLifecycle();
        threadLifecycle.newThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Test
    public void newThread() {
        threadLifecycle.newThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Test
    public void onRunnable() {
        threadLifecycle.onRunnable();
    }

    @Test
    public void onRunning() {
        threadLifecycle.onRunning();
    }

    @Test
    public void onBlocked() {
        threadLifecycle.onBlocked();
    }

    @Test
    public void onWaiting() {
        threadLifecycle.onWaiting();
    }

    @Test
    public void onTimedWaiting() {
        threadLifecycle.onTimedWaiting();
    }

    @Test
    public void onTerminated() {
        threadLifecycle.onTerminated();
    }
}