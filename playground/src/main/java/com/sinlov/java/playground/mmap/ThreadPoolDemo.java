package com.sinlov.java.playground.mmap;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    /**
     * 往ioc容器中注入一个自定义的线程池
     * 核心线程数为30
     * 最大线程数为30
     * 临时线程等待任务时间为30s
     * 阻塞队列的长度为10
     * 拒绝策略为丢弃新任务
     *
     * @return {@link ThreadPoolExecutor}
     */
    public static ThreadPoolExecutor newTreadPoolBase() {
        return new ThreadPoolExecutor(30,
                30,
                30,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.AbortPolicy()
        );
    }
}
