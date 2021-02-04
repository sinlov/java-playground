package com.sinlov.java.playground.collection.timelineset;

import org.junit.Before;
import org.junit.Test;
import test.TempTest;

import java.util.Iterator;
import java.util.SortedSet;

import static org.junit.Assert.*;

public class TimeStringTreeSetTest extends TempTest {

    private static final String FIRST_MARK = "FIRST_MARK";
    private static final String LAST_MARK = "LAST_MARK";
    private static final String MID_MARK = "MID_MARK";
    private static final String SAVE_MARK = "SAVE_MARK";
    private static final int TEST_INIT_SIZE = 5;

    private int count = 0;
    private long nowDate;
    private long saveDate;
    private TimeLineString saveItem;
    private TimeLineString saveItem1;
    private TimeStringTreeSet<TimeLineString> timeLineSet;
    private TimeLineString midItem;
    private TimeLineString firstItem;
    private TimeLineString lastItem;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        nowDate = System.currentTimeMillis();
        saveDate = nowDate + 4;
        saveItem = saveItem(SAVE_MARK);
        saveDate++;
        saveItem1 = saveItem(SAVE_MARK);
    }

    @Test
    public void test_01_default_print() throws Exception {
        timeLineSet = new TimeStringTreeSet<TimeLineString>();
        addData(timeLineSet);
        timeLineSet.add(saveItem);
        printTimeLineSetAscending(timeLineSet);
    }

    @Test
    public void test_02_descending_print() throws Exception {
        timeLineSet = new TimeStringTreeSet<TimeLineString>(new DescendingTimeString<>());
        addData(timeLineSet);
        timeLineSet.add(saveItem);
        printTimeLineSetAscending(timeLineSet);
    }

    @Test
    public void test_03_ascending_print() throws Exception {
        timeLineSet = new TimeStringTreeSet<TimeLineString>(new AscendingTimeString<>());
        addData(timeLineSet);
        timeLineSet.add(saveItem);
        printTimeLineSetAscending(timeLineSet);
    }

    @Test
    public void test_04_descending_before() throws Exception {
        timeLineSet = new TimeStringTreeSet<TimeLineString>(new DescendingTimeString<>());
        addData(timeLineSet);
        SortedSet<TimeLineString> headSet = timeLineSet.headSet(midItem, true);
        Iterator<TimeLineString> iterator = headSet.iterator();
        printIteratorInfo(iterator);
    }

    @Test
    public void test_05_remove() throws Exception {
        timeLineSet = new TimeStringTreeSet<TimeLineString>(new DescendingTimeString<>());
        addData(timeLineSet);
        timeLineSet.remove(firstItem);
        printTimeLineSetAscending(timeLineSet);
    }

    @Test
    public void test_06_join() throws Exception {
        timeLineSet = new TimeStringTreeSet<TimeLineString>();
        addData(timeLineSet);
        TimeStringTreeSet<TimeLineString> descSet = new TimeStringTreeSet<>(new DescendingTimeString<>());
        descSet.addAll(timeLineSet);
        printTimeLineSetAscending(descSet);
        descSet.add(saveItem);
        descSet.add(saveItem1);
        printTimeLineSetAscending(descSet);
        SortedSet<TimeLineString> sortedSet = descSet.subSet(lastItem, true, saveItem1, true);
        printIteratorInfo(sortedSet.iterator());
    }


    private void printTimeLineSetAscending(TimeStringTreeSet<TimeLineString> timeLineSet) {
        System.out.println("===========");
        Iterator<TimeLineString> iterator = timeLineSet.iterator();
        printIteratorInfo(iterator);
        System.out.println("===========");
    }

    private void printIteratorInfo(Iterator<TimeLineString> iterator) {
        while (iterator.hasNext()) {
            TimeLineString next = iterator.next();
            String content = next.getContent();
            long time = next.getTime();
            System.out.println("content = " + content + " | time = " + time);
        }
    }

    private void addData(TimeStringTreeSet<TimeLineString> timeLineSet) {
        firstItem = initItem(FIRST_MARK);
        timeLineSet.add(firstItem);
        for (int i = 0; i < TEST_INIT_SIZE; i++) {
            this.timeLineSet.add(initItem(randomString(7)));
        }
        midItem = initItem(MID_MARK);
        timeLineSet.add(midItem);
        for (int i = 0; i < TEST_INIT_SIZE; i++) {
            timeLineSet.add(initItem(randomString(8)));
        }
        lastItem = initItem(LAST_MARK);
        timeLineSet.add(lastItem);
    }

    private TimeLineString saveItem(String content) {
        TimeLineString timeLineString = new TimeLineString();
        timeLineString.setContent(content);
        timeLineString.setTime(saveDate);
        return timeLineString;
    }

    private TimeLineString initItem(String content) {
        TimeLineString item = new TimeLineString();
        item.setContent(content);
        long date = nowDate + this.count;
        item.setTime(date);
        this.count++;
        return item;
    }

    private TimeLineString initItem(int count) {
        TimeLineString item = new TimeLineString();
        item.setContent(randomString(count));
        long date = nowDate + this.count;
        item.setTime(date);
        this.count++;
        return item;
    }
}