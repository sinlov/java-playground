package com.sinlov.java.playground.dynamicproxy.demogclib;

import org.junit.Test;
import test.TempTest;

import static org.junit.Assert.*;

public class SayHiCGLibProxyTest extends TempTest {

    @Test
    public void test_cglib_proxy() {
        SayHiCGLibProxy sayHiCGLibProxy = new SayHiCGLibProxy();
        SayHi proxy = sayHiCGLibProxy.doProxy(SayHi.class, "sayHi", new SayHiCGLibProxy.ProxyHandler() {
            @Override
            public Object doReturn() {
                return "say proxy Hi";
            }
        });
        assertEquals("say proxy Hi", proxy.sayHi());
    }
}