package com.kevin.arithmetic;

public class AATest {

    public static void main(String[] args) {
        testDoWhile();
    }

    public static void testDoWhile() {
        int i = 0;

        do {
            System.out.println("int i=" + ++i);
        } while (i < 100);
    }
}
