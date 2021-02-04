package com.sinlov.java.playground.theadmode;

import java.util.ArrayList;
import java.util.List;

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
 * Created by sinlov on 2018/11/15.
 */
public class CatchChan<T extends ChanMessage> {
    private List<T> lists = new ArrayList<>();
    private int size;

    public CatchChan(int size) {
        this.size = size;
    }

    public synchronized T pop() {
        try {
            while (lists.size() == 0) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        T message = lists.remove(0);
        notifyAll();
        return message;
    }

    public synchronized void put(T message) {
        try {
            while (lists.size() >= size) {
                wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        lists.add(message);
        notifyAll();
    }
}
