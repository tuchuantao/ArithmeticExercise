package com.kevin.arithmetic;

public class Solution3 {

    public static void main(String[] args) {
        String result = solution("10 10 11 12 12 11 16");
        System.out.print(result);
    }

    private static String solution(String line) {
        String[] array = line.split(" ");
        java.util.HashMap<String, Integer> mapData = new java.util.HashMap<>(array.length / 2 + 1);
        java.util.ArrayList<String> numberOneList = new java.util.ArrayList<>();
        java.util.ArrayList<String> numberTwoList = new java.util.ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length(); ) {
                String num = array[i].subSequence(j, j + 9).toString();
                if (i == 0) {
                    numberOneList.add(num);
                } else {
                    numberTwoList.add(num);
                }
                j += 9;
            }
        }
        for (int i = 0; i < numberOneList.size() - 1; i++) {
            if (i < numberTwoList.size()) {
                int numberOne = Integer.valueOf(numberOneList.get(i));
                int numberTwo = Integer.valueOf(numberTwoList.get(i));
                int result = numberOne - numberTwo;
                if (result > 0) {
                    String resultStr = "000000000" + String.valueOf(result);
                    numberOneList.set(i, resultStr.substring(resultStr.length() - 9, resultStr.length()));
                } else {
                    int numberOneNext = Integer.valueOf(numberOneList.get(i + 1));
                    if (numberOneNext > 0)
                }
            } else {
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        for ()

            // 返回处理后的结果
            return result;
    }
}
