package com.kevin.arithmetic.mi;

public class Solution3 {

    public static void main(String[] args) {
        String result = solution("1231231237812739878951331231231237812739878951331231231237812739878951331230000000000000000000000001 - 331231231237812739878951331231231");
        System.out.print(result);
    }

    private static String solution(String line) {
        String[] array = line.split(" - ");
        java.util.ArrayList<String> numberOneList = new java.util.ArrayList<>();
        java.util.ArrayList<String> numberTwoList = new java.util.ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int length = array[i].length();
            for (int j = length; j >= 0; ) {
                String num = array[i].subSequence(j - 9 >= 0 ? j - 9 : 0, j).toString();
                if (i == 0) {
                    numberOneList.add(num);
                } else {
                    numberTwoList.add(num);
                }
                j -= 9;
            }
        }
        for (int i = 0; i < numberOneList.size(); i++) {
            if (i < numberTwoList.size()) {
                int numberOne = Integer.valueOf(numberOneList.get(i));
                int numberTwo = Integer.valueOf(numberTwoList.get(i));
                int result = numberOne - numberTwo;
                if (result > 0) {
                    String resultStr = "000000000" + String.valueOf(result);
                    numberOneList.set(i, resultStr.substring(resultStr.length() - 9, resultStr.length()));
                } else {
                    int j = i + 1;
                    int numberOneNext = 0;
                    for (; j < numberOneList.size(); j++) {
                        numberOneNext = Integer.valueOf(numberOneList.get(j));
                        if (numberOneNext > 0) {
                            break;
                        }
                    }

                    numberOneNext -= 1;
                    String numberOneNextStr = "000000000" + String.valueOf(numberOneNext);
                    numberOneList.set(j, numberOneNextStr.substring(numberOneNextStr.length() - 9, numberOneNextStr.length()));

                    result += 1000000000;
                    String resultStr = "000000000" + String.valueOf(result);
                    numberOneList.set(i, resultStr.substring(resultStr.length() - 9, resultStr.length()));
                    if (j - i > 1) {
                        for (int k = i + 1; k < j; k++) {
                            numberOneList.set(k, "999999999");
                        }
                    }
                }
            } else {
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = numberOneList.size() - 1; i >= 0; i--) {
            result.append(numberOneList.get(i));
        }

        // 返回处理后的结果
        return result.toString();
    }
}
