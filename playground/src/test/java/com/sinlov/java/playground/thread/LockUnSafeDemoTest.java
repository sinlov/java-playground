package com.sinlov.java.playground.thread;

import org.junit.Test;
import test.TempTest;

import static org.junit.Assert.*;

public class LockUnSafeDemoTest extends TempTest {

    private LockUnSafeDemo lockUnSafeDemo;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        lockUnSafeDemo = new LockUnSafeDemo();
    }

    @Test
    public void getA() {
        assertNotEquals(0, lockUnSafeDemo.getA());
    }

    @Test
    public void test_join() {
        Thread threadOne = new Thread(lockUnSafeDemo);
        Thread threadTwo = new Thread(lockUnSafeDemo);

        try {
            threadOne.start();
            threadTwo.start();
            threadTwo.join();
            threadOne.join();
            int nowA = lockUnSafeDemo.getA();
            System.out.println("nowA = " + nowA);
//            assertNotEquals(LockUnSafeDemo.COUNT * 2, nowA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}