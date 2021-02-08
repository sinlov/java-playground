package com.sinlov.java.playground.vm.klass;

import org.junit.Test;
import test.TempTest;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import static org.junit.Assert.*;

public class VMTestTest extends TempTest {

    @Override
    public void setUp() throws Exception {
        super.setUp();

    }

    @Test
    public void test_klass() {
        VMTest.A a = new VMTest.A(1, 2);
        a.show();
        VMTest.A[] a2 = {a, new VMTest.B(2, 3)};
        try {
            System.out.println("test_klass getProcessID: " + getProcessID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final int getProcessID() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])
                .intValue();
    }

}