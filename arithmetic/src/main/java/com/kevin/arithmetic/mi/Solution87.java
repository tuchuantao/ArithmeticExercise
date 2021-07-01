package com.kevin.arithmetic.mi;

/**
 * Kevin-Tu on 2018/5/14.
 */
public class Solution87 {

    public static void main(String[] args) {
        String result = solution("aabbccc");
        //String result = solution("aaccbd");
        //String result = solution("xxxaaabbbeeeccc");
        System.out.print(result);
    }

    private static String solution(String line) {
        // 在此处理单行数据
        char[] array = line.toCharArray();
        java.util.HashMap<Character, Integer> charSet = new java.util.HashMap<>();
        String result = "NO";
        for (char singleChar : array) {
            Integer numbers = charSet.get(singleChar);
            if (numbers == null || numbers == 0) {
                charSet.put(singleChar, 1);
            } else {
                charSet.put(singleChar, ++numbers);
            }
        }
        int maxCount = 0;
        java.util.ArrayList<Character> maxStrList = new java.util.ArrayList<>();
        int minCount = 0;
        java.util.ArrayList<Character> minStrList = new java.util.ArrayList<>();
        for (java.util.Map.Entry<Character, Integer> entry : charSet.entrySet()) {
            if (entry.getValue() > maxCount) {
                if (minCount != 0) {
                    return result;
                }
                minCount = maxCount;
                maxCount = entry.getValue();
                minStrList.addAll(maxStrList);
                maxStrList.clear();
                maxStrList.add(entry.getKey());
            } else if (entry.getValue() < maxCount) {
                if (minCount != 0 && entry.getValue() != minCount) {
                    return result;
                }
                minCount = entry.getValue();
                minStrList.add(entry.getKey());
            } else {
                maxStrList.add(entry.getKey());
            }
        }

        if (minCount == 0 || maxCount == minCount) {
            result = "YES";
        } else if (maxCount - minCount == 1) {
            if (maxStrList.size() > 1 && minStrList.size() > 1) {
                result = "NO";
            } else {
                result = "YES";
            }
        }
        // 返回处理后的结果
        return result;


        /*// 在此处理单行数据
        // 只能处理最大重复数位偶数的情况
        char[] array = line.toCharArray();
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = result ^ array[i];
        }
        // 返回处理后的结果
        return ((result <= 'z' && result >= 'a') || result == 0) ? "YES" : "NO";*/
    }
}
