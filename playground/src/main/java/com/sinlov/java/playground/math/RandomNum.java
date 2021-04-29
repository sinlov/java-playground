package com.sinlov.java.playground.math;

import java.util.Random;

public final class RandomNum {

    private static final Random generator = new Random();

    /**
     * 随机数生成工具
     * 可以生成 正负数
     * 使用方法: RandomNum.sum(最小数,最大数);
     */
    public static int positiveNegativeValue(int max) {
        return max - (int) (Math.random() * max) * 2;
    }

    public static double randomDouble(double min, double max) {
        return min + (generator.nextDouble() * (max - min));
    }

    private RandomNum() {
    }
}

