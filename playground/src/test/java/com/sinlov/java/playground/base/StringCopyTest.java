package com.sinlov.java.playground.base;

import org.junit.Test;
import test.TempTest;

import static org.junit.Assert.*;

public class StringCopyTest extends TempTest {
    private String chars;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        chars = "sunmingkaihf";
    }

    @Test
    public void test_copy() {
        String chars1 = new String(chars);
        assertEquals(chars1, chars);
        String chars11 = chars;
        assertEquals(chars1, chars11);
        String chars2 = null;
        String chars3 = null;
        if (chars1.length() > 3) {
            chars2 = chars.substring(8, chars1.length());
            chars3 = chars.substring(0, 3);
        }

        assertNotEquals(chars2, chars3);
    }
}
