package com.kevin.arithmetic.other;

/**
 * 输出给定数字下一个比它大的数字  1234 输出 1243，1243 输出 1324；3421输出
 *
 * Create by Kevin-Tu on 2020/9/10.
 */
public class NearNumber {

    public static void main(String[] args) {
        int inputNum = 1234;
        int result = findNearNumber(inputNum);
        System.out.println("输入：" + inputNum + "  结果：" + result);
        inputNum = 1243;
        result = findNearNumber(inputNum);
        System.out.println("输入：" + inputNum + "  结果：" + result);
        inputNum = 3421;
        result = findNearNumber(inputNum);
        System.out.println("输入：" + inputNum + "  结果：" + result);
        inputNum = 4321;
        result = findNearNumber(inputNum);
        System.out.println("输入：" + inputNum + "  结果：" + result);

    }

    private static int findNearNumber(int number) {
        if (number < 10) {
            return number;
        }
        char[] numArr = String.valueOf(number).toCharArray();
        int len = numArr.length;
        int changeIndex = -1;
        // 1、从后往前寻找，找到第一个降序的位置
        for (int i = len - 2; i >= 0; i--) {
            if (numArr[i] < numArr[i + 1]) {
                changeIndex = i;
                break;
            }
        }
        if (changeIndex < 0) {
            return number;
        }
        char changeIndexValue = numArr[changeIndex];

        // 2、递增排序
        int maxIndex;
        char temp;
        int handleNum = -1;
        for (int i = changeIndex + 1; i < len - 1; i++) {
            maxIndex = changeIndex + 1;
            handleNum++;
            for (int j = changeIndex + 2; j < len - handleNum; j++) {
                if (numArr[maxIndex] > numArr[j]) {
                    temp = numArr[maxIndex];
                    numArr[maxIndex] = numArr[j];
                    numArr[j] = temp;
                    maxIndex = j;
                } else {
                    maxIndex = j;
                }
            }
        }

        // 3、找到第一个比changeIndexValue大的值
        for (int i = changeIndex + 1; i < len; i++) {
            if (numArr[i] > changeIndexValue) {
                numArr[changeIndex] = numArr[i];
                numArr[i] = changeIndexValue;
                break;
            }
        }
        return Integer.valueOf(String.valueOf(numArr));
    }
}
