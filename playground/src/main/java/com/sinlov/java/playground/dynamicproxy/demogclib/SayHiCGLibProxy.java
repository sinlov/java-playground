package com.sinlov.java.playground.dynamicproxy.demogclib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * use cglib:cglib:3.3.0 <br/>
 * <a href="https://github.com/cglib/cglib/wiki">https://github.com/cglib/cglib/wiki</a>
 */
public class SayHiCGLibProxy implements MethodInterceptor {

    private String methodName;
    private ProxyHandler handler;

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (handler != null) {
            if (method.getName().equals(methodName)) {
                return handler.doReturn();
            }
        }

        return proxy.invokeSuper(obj, args);
    }

    @SuppressWarnings("unchecked")
    public <T> T doProxy(Class<?> cls, String methodName, ProxyHandler handler) {
        this.methodName = methodName;
        this.handler = handler;
        return (T) Enhancer.create(cls, this);
    }

    public interface ProxyHandler {
        Object doReturn();
    }
}
