package com.sinlov.java.playground.collection.datestringset;

import org.junit.Before;
import org.junit.Test;
import test.TempTest;

import java.util.Date;
import java.util.Iterator;
import java.util.SortedSet;

import static org.junit.Assert.*;

public class DateStringTreeSetTest extends TempTest {

    private static final String FIRST_MARK = "FIRST_MARK";
    private static final String LAST_MARK = "LAST_MARK";
    private static final String MID_MARK = "MID_MARK";
    private static final String SAVE_MARK = "SAVE_MARK";
    private static final int TEST_INIT_SIZE = 5;

    private DateStringTreeSet<DateLineString> timeLineSet;
    private int count = 0;
    private long nowDate;
    private long saveDate;
    private DateLineString midItem;
    private DateLineString firstItem;
    private DateLineString lastItem;
    private DateLineString saveItem;
    private DateLineString saveItem1;

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        nowDate = System.currentTimeMillis();
        saveDate = nowDate + 4;
        saveItem = saveItem(SAVE_MARK);
        saveDate++;
        saveItem1 = saveItem(SAVE_MARK);
        initSet();
        addData();
        printNowSet(timeLineSet);
    }

    @Test
    public void test_01_print_first_last() throws Exception {
        DateLineString pollFirstItem = timeLineSet.pollFirst();
        long fistItemTime = pollFirstItem.getTime().getTime();
        System.out.println("fistItemTime = " + fistItemTime);
        String firstItemContent = pollFirstItem.getContent();
        System.out.println("firstItemContent = " + firstItemContent);
        assertEquals(FIRST_MARK, firstItemContent);
        DateLineString pollLastItem = timeLineSet.pollLast();
        long lastItemTime = pollLastItem.getTime().getTime();
        System.out.println("lastItemTime = " + lastItemTime);
        String lastItemContent = pollLastItem.getContent();
        System.out.println("pollLastItem = " + lastItemContent);
        assertEquals(LAST_MARK, lastItemContent);
    }

    @Test
    public void test_02_mid_mark_before() throws Exception {
        SortedSet<DateLineString> headSet = timeLineSet.headSet(midItem);
        Iterator<DateLineString> iterator = headSet.iterator();
        printIteratorInfo(iterator);
    }

    @Test
    public void test_03_join() throws Exception {
        DateStringTreeSet<DateLineString> d = new DateStringTreeSet<DateLineString>(new DescendingDateString<>()) {
        };
        d.addAll(timeLineSet);
        printNowSet(d);
        d.add(saveItem);
        d.add(saveItem1);
        printNowSet(d);
        SortedSet<DateLineString> dateLineStrings = d.subSet(lastItem, true, saveItem, true);
        Iterator<DateLineString> iterator = dateLineStrings.iterator();
        printIteratorInfo(iterator);
    }

    private void printNowSet(DateStringTreeSet<DateLineString> set) {
        System.out.println("===========");
        Iterator<DateLineString> iterator = set.iterator();
        printIteratorInfo(iterator);
        System.out.println("===========");
    }

    private void printIteratorInfo(Iterator<DateLineString> iterator) {
        while (iterator.hasNext()) {
            DateLineString next = iterator.next();
            String content = next.getContent();
            long time = next.getTime().getTime();
            System.out.println("content = " + content + " | time = " + time);
        }
    }

    private void addData() {
        firstItem = initItem(FIRST_MARK);
        timeLineSet.add(firstItem);
        for (int i = 0; i < TEST_INIT_SIZE; i++) {
            timeLineSet.add(initItem(7));
        }
        midItem = initItem(MID_MARK);
        timeLineSet.add(midItem);
        timeLineSet.remove(midItem);
        timeLineSet.add(midItem);
        for (int i = 0; i < TEST_INIT_SIZE; i++) {
            timeLineSet.add(initItem(8));
        }
        lastItem = initItem(LAST_MARK);
        timeLineSet.add(lastItem);
    }

    private DateLineString initItem(String content) {
        DateLineString item = new DateLineString();
        item.setContent(content);
        long date = nowDate + this.count;
        item.setTime(new Date(date));
        this.count++;
        return item;
    }

    private DateLineString initItem(int count) {
        DateLineString item = new DateLineString();
        item.setContent(randomString(count));
        long date = nowDate + this.count;
        item.setTime(new Date(date));
        this.count++;
        return item;
    }

    private void initSet() {
        if (timeLineSet == null) {
            timeLineSet = new DateStringTreeSet<DateLineString>();
        }
        timeLineSet.clear();
    }

    private DateLineString saveItem(String content) {
        DateLineString item = new DateLineString();
        item.setContent(content);
        item.setTime(new Date(saveDate));
        this.count++;
        return item;
    }
}