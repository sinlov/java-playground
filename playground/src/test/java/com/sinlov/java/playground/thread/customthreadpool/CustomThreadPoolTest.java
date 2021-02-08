package com.sinlov.java.playground.thread.customthreadpool;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.TempTest;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.JVM)
public class CustomThreadPoolTest extends TempTest {
    private static final int TEST_INIT_SIZE = 100;

    @Test
    public void test_a_ascending_thread() {
        CustomThreadPool customThreadPool = new CustomThreadPool();
        for (int i = 0; i < TEST_INIT_SIZE; i++) {
            TestThreadAscending testThread = new TestThreadAscending(i, "thread-" + i);
            customThreadPool.execute(testThread);
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_a_descending_thread() {
        CustomThreadPool customThreadPool = new CustomThreadPool();
        for (int i = 0; i < TEST_INIT_SIZE; i++) {
            TestThreadDescending testThread = new TestThreadDescending(i, "thread-" + i);
            customThreadPool.execute(testThread);
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class TestThreadAscending extends AscendingCustomThread {


        public TestThreadAscending(int priority, String name) {
            super(priority, name);
        }

        @Override
        public void run() {
            System.out.println("TestThreadAscending: run name= " + this.getName() + " priority: " + this.gettPriority());
        }
    }

    static class TestThreadDescending extends DescendingCustomThread {

        @Override
        public void run() {
            System.out.println("TestThreadDescending: run name= " + this.getName() + " priority: " + this.gettPriority());
        }

        public TestThreadDescending(int priority, String name) {
            super(priority, name);
        }

    }

    static class TestDestroyThread extends AscendingCustomThread {

        public TestDestroyThread(int priority, String name) {
            super(priority, name);
        }

        @Override
        public void run() {
            try {
                TimeUnit.MICROSECONDS.sleep(10);
                System.out.println("TestDestroyThread: run name= " + this.getName() + " priority: " + this.gettPriority());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test_z_destroy() {
        CustomThreadPool customThreadPool = new CustomThreadPool();
        for (int i = 0; i < TEST_INIT_SIZE; i++) {
            TestDestroyThread testThread = new TestDestroyThread(i, "thread-" + i);
            customThreadPool.execute(testThread);
        }
        try {
            TimeUnit.MICROSECONDS.sleep(100);
            customThreadPool.destroy();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}