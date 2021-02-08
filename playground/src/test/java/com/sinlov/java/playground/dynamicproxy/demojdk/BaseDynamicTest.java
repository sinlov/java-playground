package com.sinlov.java.playground.dynamicproxy.demojdk;

import org.junit.Test;
import test.TempTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class BaseDynamicTest extends TempTest {
    @Test
    public void test_dynamic_proxy() {
        BaseDynamicProxy base = new BaseDynamicProxy();

        BaseDynamicInterface proxyInterface = (BaseDynamicInterface) Proxy.newProxyInstance(base.getClass().getClassLoader(), base.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("sayString")) {
                    return "say proxy something";
                }
                return method.invoke(base, args);
            }
        });
        assertEquals("do say string", base.sayString());
        base.getProxy(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("sayString")) {
                    return "say proxy something";
                }
                return method.invoke(base, args);
            }
        });
        assertEquals("say proxy something", proxyInterface.sayString());
    }
}