package com.sinlov.java.playground.thread.customthreadpool;

public interface ICustomThreadPool {

    void execute(Runnable task);

    void destroy();
}
