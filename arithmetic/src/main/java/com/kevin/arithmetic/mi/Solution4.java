package com.kevin.arithmetic.mi;

/**
 * Kevin-Tu on 2018/5/14.
 */
public class Solution4 {

    public static void main(String[] args) {
        String result = solution("100,4,200,1,3,2");
        System.out.print(result);
    }

    private static String solution(String line) {
        String[] array = line.split(",");

        java.util.HashSet<Integer> numberSet = new java.util.HashSet<>();
        int result = 0;
        if (array.length > 0) {
            result = 1;
            for (String numberStr : array) {
                Integer number = Integer.valueOf(numberStr);
                numberSet.add(number);
                int resultNew = calculate(number, numberSet, 1);
                if (resultNew > result) {
                    result = resultNew;
                }
            }
        }
        return String.valueOf(result);
    }

    private static int calculate(int number, java.util.HashSet<Integer> numberSet, int result) {
        int numberBefore = number - 1;
        int numberNext = number + 1;
        if (numberSet.contains(numberBefore)) {
            result++;
            result = calculateBefore(numberBefore, numberSet, result);
        }
        if (numberSet.contains(numberNext)) {
            result++;
            result = calculateNext(numberNext, numberSet, result);
        }
        return result;
    }

    private static int calculateBefore(int number, java.util.HashSet<Integer> numberSet, int result) {
        int numberBefore = number - 1;
        if (numberSet.contains(numberBefore)) {
            result++;
            result = calculateBefore(numberBefore, numberSet, result);
        }
        return result;
    }

    private static int calculateNext(int number, java.util.HashSet<Integer> numberSet, int result) {
        int numberNext = number + 1;
        if (numberSet.contains(numberNext)) {
            result++;
            result = calculateNext(numberNext, numberSet, result);
        }
        return result;
    }
}
