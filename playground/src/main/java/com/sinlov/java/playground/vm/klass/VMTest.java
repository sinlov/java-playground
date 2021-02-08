package com.sinlov.java.playground.vm.klass;

public class VMTest {
    interface interTest {
        void show();
    }

    public static class Base {
        private int a = 1;

        public void print() {
            System.out.println("Base");
        }
    }

    public static class Base2 extends Base {
        public int a;

        public Base2(int a) {
            this.a = a;
        }

        public void print() {
            System.out.println("Base2");
        }
    }

    public static class A extends Base2 implements interTest {
        public int b;

        public A(int a, int b) {
            super(a);
            this.b = b;
        }

        @Override
        public void show() {
            System.out.println("a->" + a + ",b=" + b);
        }

        public void print() {
            System.out.println("A");
        }
    }

    public static class B extends A {
        private int c;

        public B(int a, int b) {
            super(a, b);
            c = 3;
        }

        @Override
        public void show() {
            System.out.println("a->" + a + ",b=" + b + ",c=" + c);
        }

        public void print() {
            System.out.println("B");
        }
    }

}
