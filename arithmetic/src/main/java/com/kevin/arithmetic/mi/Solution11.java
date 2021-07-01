package com.kevin.arithmetic.mi;

import java.util.Scanner;

/**
 * Create by Kevin-Tu on 2019/7/23.
 */
public class Solution11 {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] strArr = line.split(" ");
            if (strArr.length == 2) {
                StringBuilder longStr;
                StringBuilder shortStr;
                if (strArr[0].length() > strArr[1].length()) {
                    longStr = new StringBuilder(strArr[0]);
                    shortStr = new StringBuilder(strArr[1]);
                } else {
                    longStr = new StringBuilder(strArr[1]);
                    shortStr = new StringBuilder(strArr[0]);
                }

                int strIndex;
                for (int index = 0; index < shortStr.length(); index++) {
                    strIndex = longStr.indexOf(String.valueOf(shortStr.charAt(index)));
                    if (strIndex == -1) {
                        System.out.println("false");
                        break;
                    } else {
                        if (index == shortStr.length() - 1) {
                            System.out.println("true");
                        } else {
                            longStr.deleteCharAt(strIndex);
                        }
                    }
                }
            } else {
                System.out.println("input error");
            }
            // System.out.println("answer");
        }
    }
}
