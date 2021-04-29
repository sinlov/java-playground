package com.sinlov.java.playground.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomNumTest {

    @Test
    public void positiveNegativeValue() {
        for (int i = 0; i < 100; i++) {
            int value = RandomNum.positiveNegativeValue(10);
            System.out.println("value = " + value);
            assertTrue(value < 11);
            assertTrue(value > -11);
        }
    }

    @Test
    public void randomDouble() {
        double aDouble = RandomNum.randomDouble(0.1, 0.8);
        assertTrue(aDouble < 0.8);
        assertTrue(aDouble > 0.1);
    }
}