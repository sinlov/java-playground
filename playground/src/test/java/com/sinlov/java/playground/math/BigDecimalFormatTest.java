package com.sinlov.java.playground.math;

import org.junit.Test;
import test.TempTest;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalFormatTest extends TempTest {
    @Test
    public void test_format_simple() {
        double a1 = 25.10;
        BigDecimal a = new BigDecimal("0.1143");
        System.out.println("a = " + a);
        BigDecimal b = new BigDecimal("12.1");
        System.out.println("b = " + b);
        BigDecimal c = new BigDecimal("13");
        System.out.println("c = " + c);

        DecimalFormat df2 = new DecimalFormat("####0.00");
        String df2a = df2.format(a);
        System.out.println("df2a = " + df2a);
        String df2b = df2.format(b);
        System.out.println("df2b = " + df2b);
        String df2c = df2.format(c);
        System.out.println("df2c = " + df2c);

        DecimalFormat df3 = new DecimalFormat("####0.##");
        String df3a = df3.format(a);
        System.out.println("df3a = " + df3a);
        String df3b = df3.format(b);
        System.out.println("df3b = " + df3b);
        String df3c = df3.format(c);
        System.out.println("df3c = " + df3c);
    }
}
