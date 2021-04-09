package com.sinlov.java.javamock;

public class ClassLoadSequence {
    public static final String TAG = "static filed";

    static {
        System.out.println("static method");
    }

    public ClassLoadSequence() {
        System.out.println(TAG);
    }

    public static void main(String[] args) {
        ClassLoadSequence sequence = new ClassLoadSequence();
        System.out.println("main");
    }
}
