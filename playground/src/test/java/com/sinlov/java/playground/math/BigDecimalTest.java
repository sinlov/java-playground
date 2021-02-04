package com.sinlov.java.playground.math;

import org.junit.Test;
import test.TempTest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalTest extends TempTest {

    private BigDecimal bigDecimalA;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        bigDecimalA = new BigDecimal("0.1143");
    }

    @Test
    public void test_new_big_decimal() {
        double a1 = 25.10;
        BigDecimal a = new BigDecimal("0.1143");
        System.out.println("a = " + a);
        BigDecimal b = new BigDecimal("12");
        System.out.println("b = " + b);
        System.out.println("=======");
        BigDecimal wipeYuan = a.remainder(BigDecimal.TEN);
        System.out.println("wipeYuan = " + wipeYuan);
        BigDecimal bai = new BigDecimal("100");
        BigDecimal wipeJiao = a.multiply(bai).remainder(bai).divide(bai, 2, RoundingMode.HALF_DOWN);
        System.out.println("wipeJiao = " + wipeJiao);
        BigDecimal wipeFen = a.multiply(bai).remainder(BigDecimal.TEN).divide(bai, RoundingMode.CEILING);
        System.out.println("wipeFen = " + wipeFen);
    }

    @Test
    public void test_compute() {
        BigDecimal remainder = bigDecimalA.remainder(BigDecimal.TEN, new MathContext(1));
        System.out.println("remainder = " + remainder);
        BigDecimal[] bigDecimals = bigDecimalA.divideAndRemainder(BigDecimal.TEN);
        System.out.println("bigDecimals[0] = " + bigDecimals[0]);
        System.out.println("bigDecimals[1] = " + bigDecimals[1]);
        double ad = bigDecimalA.doubleValue();
        java.text.DecimalFormat dJiao = new java.text.DecimalFormat("0.#");
        String formatJiao = dJiao.format(ad);
        BigDecimal formatBigJiao = new BigDecimal(formatJiao);
        System.out.println("formatBigJiao = " + formatBigJiao);
    }

    @Test
    public void test_format() {
        double c = 3.154215;
        java.text.DecimalFormat myFormat = new java.text.DecimalFormat("0.00");
        String decimalFormat = myFormat.format(c);
        System.out.println("decimalFormat = " + decimalFormat);
        double f1 = 111231.5585;
        BigDecimal f = new BigDecimal(f1);
        //保留2位小数
        double letRoundHalfUp = f.setScale(2, RoundingMode.HALF_UP).doubleValue();
        System.out.println("letRoundHalfUp = " + letRoundHalfUp);
    }
}
