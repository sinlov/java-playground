package com.sinlov.java.playground.thread.customthreadpool;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomThreadPool implements ICustomThreadPool {

    /**
     * work of this thread pool
     */
    private static final int WORK_NUMBER = 4;
    private static final int WORK_MAX = 1000;

    /**
     * task queue with priority must static
     */
    private static PriorityBlockingQueue<Runnable> taskQueue = new PriorityBlockingQueue<Runnable>();
    private final WorkerThread[] workerThreads;
    private final AtomicInteger atomicInteger;
    private final int maxWorker;
    private final AtomicInteger sumWorker;


    @Override
    public void execute(Runnable task) {
        if (sumWorker.incrementAndGet() > maxWorker) { // each runnable execute and increment
            return;
        }
        taskQueue.add(task);
    }

    @Override
    public void destroy() {
        for (int i = 0; i < workerThreads.length; i++) {
            workerThreads[i].setRunning(false);
        }
    }

    public CustomThreadPool() {
        this(WORK_NUMBER, WORK_MAX);
    }

    public CustomThreadPool(int workNumber, int maxWorkers) {
        maxWorker = maxWorkers;
        // start init work thread
        sumWorker = new AtomicInteger();
        atomicInteger = new AtomicInteger();
        workerThreads = new WorkerThread[workNumber];
        for (int i = 0; i < workerThreads.length; i++) {
            workerThreads[i] = new WorkerThread();
            Thread thread = new Thread(workerThreads[i], "CustomThreadPool-Worker-" + atomicInteger.incrementAndGet());
            System.out.println("init thread.getName(); = " + thread.getName());
            thread.start();
        }
    }

    class WorkerThread extends Thread {
        private boolean isRunning = true;

        @Override
        public void run() {
            try {
                while (isRunning) {
                    synchronized (WorkerThread.class) {
                        System.out.println("before taskQueue.size = " + taskQueue.size());
                        Runnable runnable = taskQueue.take();
                        if (runnable != null) {
                            runnable.run();
                        }
                        System.out.println("after taskQueue.size = " + taskQueue.size());
                        runnable = null;
                        sumWorker.decrementAndGet(); // each runnable finish and decrement
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void setRunning(boolean running) {
            isRunning = running;
        }
    }
}
