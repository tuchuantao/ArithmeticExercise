package com.kevin.arithmetic;

/**
 * Kevin-Tu on 2018/5/14.
 */
public class Solution2 {

    public static void main(String[] args) {
        String result = solution("10 10 11 12 12 11 16");
        System.out.print(result);
    }

    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(" ");
        java.util.HashMap<String, Integer> mapData = new java.util.HashMap<>(array.length / 2 + 1);
        for(String number : array) {
            Integer value = mapData.get(number);
            if(null != value) {
                mapData.put(number, ++value);
            } else {
                mapData.put(number, 1);
            }
        }
        String result = "";
        for(java.util.Map.Entry entry : mapData.entrySet()) {
            if(((int) entry.getValue()) == 1) {
                result = (String) entry.getKey();
            }
        }
        // 返回处理后的结果
        return result;
    }

}
