package com.sinlov.java.playground.theadmode;

/**
 * class just use like chan
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
 * Created by sinlov on 2018/11/15.
 */
public class Chan<T extends ChanMessage> {

    private T message;
    private boolean empty = true;

    public synchronized T pop() {
        try {
            while (empty) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void put(T message) {
        try {
            while (!empty) {
                wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}
