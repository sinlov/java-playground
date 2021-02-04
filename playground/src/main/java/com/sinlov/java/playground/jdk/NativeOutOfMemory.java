package com.sinlov.java.playground.jdk;

import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 *     sinlov
 *
 *     /\__/\
 *    /`    '\
 *  ≈≈≈ 0  0 ≈≈≈ Hello world!
 *    \  --  /
 *   /        \
 *  /          \
 * |            |
 *  \  ||  ||  /
 *   \_oo__oo_/≡≡≡≡≡≡≡≡o
 *
 * </pre>
 * Created by sinlov on 17/5/21.
 */
public class NativeOutOfMemory {

    public void countNowMaxThreadCount() {
        for (int i = 0; ; i++) {
            System.out.println("now thread count: [" + i + "]");
            new Thread(new HoldThread()).start();
        }
    }

    class HoldThread extends Thread {
        CountDownLatch cdl = new CountDownLatch(1);

        public HoldThread() {
            this.setDaemon(true);
        }

        public void run() {
            try {
                cdl.await();
            } catch (InterruptedException e) {
            }
        }
    }
}
