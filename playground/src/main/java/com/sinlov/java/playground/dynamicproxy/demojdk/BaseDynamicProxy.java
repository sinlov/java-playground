package com.sinlov.java.playground.dynamicproxy.demojdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class BaseDynamicProxy implements BaseDynamicInterface {
    @Override
    public String sayString() {
        return "do say string";
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                this.getClass().getInterfaces(),
                handler);
    }
}
