package com.sinlov.java.playground.collection.timelineset;

import java.util.Comparator;

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
 * Created by sinlov on 17/12/27.
 */
public class DescendingTimeString<D extends TimeLineString> implements Comparator<D> {

    @Override
    public int compare(D o1, D o2) {
        int res = -(Long.valueOf(o1.getTime()).compareTo(o2.getTime()));
        if (res == 0) {
            res = -(o1.getContent().compareTo(o2.getContent()));
        }
        return res;
    }

}
