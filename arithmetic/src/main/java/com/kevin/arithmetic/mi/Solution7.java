package com.kevin.arithmetic.mi;

/**
 * Kevin-Tu on 2018/5/14.
 */
public class Solution7 {

    public static void main(String[] args) {
        //String result = solution("3,4,-1,1");
        //String result = solution("-1,-3,-5");
        String result = solution("1,2,3");
        System.out.print(result);
    }

    private static String solution(String line) {
    // 在此处理单行数据
    String[] array = line.split(",");
    int[] numberArr = new int[array.length];
    for (String numberStr : array) {
        int number = Integer.parseInt(numberStr);
        if (number > 0 && number - 1 < numberArr.length) {
            numberArr[number - 1] = 1;
        }
    }
    int i = 0;
    for (; i < numberArr.length; i++) {
        if (numberArr[i] == 0) {
            break;
        }
    }

    // 返回处理后的结果
    return String.valueOf(i + 1);
    }
}
