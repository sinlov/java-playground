package com.sinlov.java.playground.collection.timelineset;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

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
public class TimeStringTreeSet<T extends TimeLineString> extends TreeSet<T> {

    public TimeStringTreeSet() {
    }

    public TimeStringTreeSet(Collection<? extends T> c) {
        super(c);
    }

    public TimeStringTreeSet(SortedSet<T> s) {
        super(s);
    }

    public TimeStringTreeSet(Comparator<? super T> comparator) {
        super(comparator);
    }
}

