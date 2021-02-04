package com.sinlov.java.playground.thread;

import org.junit.Test;
import test.TempTest;

import static org.junit.Assert.*;

public class LockSafeDemoTest extends TempTest {

    private LockSafeDemo demo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        demo = new LockSafeDemo();
    }

    @Test
    public void test_join() {
        Thread threadOne = new Thread(demo);
        Thread threadTwo = new Thread(demo);
        try {
            threadOne.start();
            threadTwo.start();
            threadTwo.join();
            threadOne.join();
            int nowA = demo.getA();
            System.out.println("nowA = " + nowA);
            assertEquals(LockUnSafeDemo.COUNT * 2, nowA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}