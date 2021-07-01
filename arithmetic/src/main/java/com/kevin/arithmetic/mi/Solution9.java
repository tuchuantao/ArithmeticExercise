package com.kevin.arithmetic.mi;


import java.util.Scanner;

/**
 * Create by Kevin-Tu on 2019/7/23.
 */
public class Solution9 {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            String[] inputArr = line.split(" ");
            if (inputArr.length == 2) {
                int removeCount = Integer.valueOf(inputArr[1]);
                if (inputArr[0].length() <= removeCount) {
                    System.out.println("0");
                } else {
                    StringBuilder numberStr = new StringBuilder(inputArr[0]);
                    for (int index = 0; index < removeCount; index++) {
                        if (numberStr.charAt(0) > numberStr.charAt(1)) {
                            numberStr.deleteCharAt(0);
                        } else if (numberStr.length() >= 3) {
                            if (numberStr.charAt(1) > numberStr.charAt(2)) {
                                numberStr.deleteCharAt(1);
                            } else {
                                numberStr.deleteCharAt(2);
                            }
                        } else {
                            numberStr.deleteCharAt(1);
                        }
                    }
                    int numberStrLength = numberStr.length();
                    for (int index = 0; index < numberStrLength; ) {
                        if (numberStr.charAt(index) == '0') {
                            numberStr.deleteCharAt(index);
                            numberStrLength--;
                        } else {
                            break;
                        }
                    }
                    if (numberStr.length() > 0) {
                        System.out.println(numberStr.toString());
                    } else {
                        System.out.println("0");
                    }
                }

            } else {
                System.out.println("input error");
            }
            // System.out.println("answer");
        }
    }
}
