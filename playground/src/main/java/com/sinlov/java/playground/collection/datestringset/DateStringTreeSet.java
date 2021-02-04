package com.sinlov.java.playground.collection.datestringset;

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
public class DateStringTreeSet<T extends DateLineString> extends TreeSet<T> {

    public DateStringTreeSet() {
    }

    public DateStringTreeSet(Collection<? extends T> c) {
        super(c);
    }

    public DateStringTreeSet(SortedSet<T> s) {
        super(s);
    }

    public DateStringTreeSet(Comparator<? super T> comparator) {
        super(comparator);
    }
}

