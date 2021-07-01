package com.kevin.arithmetic.mi;

/**
 * Kevin-Tu on 2018/5/14.
 */
public class Solution5 {

    public static void main(String[] args) {
        String result = solution("12,13,14,5,6,7,8,9,10");
        System.out.print(result);
    }

private static String solution(String line) {
    String[] array = line.split(",");
    int beginIndex = 0;
    int length = array.length;
    for (int i = 0; i < length - 1; i++) {
        if (Integer.valueOf(array[i]) > Integer.valueOf(array[i + 1])) {
            beginIndex = i + 1;
            break;
        }
    }
    int result = beginIndex + (length - 1) / 2;
    result = result >= length ? result - length : result;
    return String.valueOf(array[result]);
}
}
