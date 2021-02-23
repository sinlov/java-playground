package com.sinlov.java.playground.base;

import org.junit.Test;
import test.TempTest;

import static org.junit.Assert.*;

public class SignificanceTest extends TempTest {
    @Test
    public void test_floating_loss_sequence() {
        assertNotEquals(0.3, 0.1 + 0.2, Double.NaN);
        assertEquals(0.3, 0.1 + 0.2, Double.POSITIVE_INFINITY);
    }
}
