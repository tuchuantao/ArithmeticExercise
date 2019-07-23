package com.kevin.arithmetic;

import java.util.Scanner;

/**
 * Create by Kevin-Tu on 2019/7/23.
 */
public class Solution10 {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            int inputNum = Integer.valueOf(line);

            if (inputNum <= 0) {
                System.out.println("0");
            } else if (inputNum == 1) {
                System.out.println("1");
            } else if (inputNum == 2) {
                System.out.println("2");
            } else {
                int lastOneNumber = 2;
                int lastTwoNumber = 1;
                int temp;
                for (int index = 3; index <= inputNum; index++) {
                    temp = lastOneNumber;
                    lastOneNumber = lastOneNumber + lastTwoNumber;
                    lastTwoNumber = temp;
                }
                System.out.println("" + lastOneNumber);
            }
            // System.out.println("answer");
        }
    }
}
