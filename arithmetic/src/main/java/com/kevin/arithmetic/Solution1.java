package com.kevin.arithmetic;


/**
 * Kevin-Tu on 2018/5/14.
 */
public class Solution1 {

    public static void main(String[] args) {
        String result = solution("111");
        System.out.print(result);
    }

private static String solution(String line) {
    // 在此处理单行数据
    int number = Integer.parseInt(line);
    int mixSystem = number + 1;
    for (int i = 2; i < number; i++) {
        int remainder = number % i;
        int n = number / i;
        while (n > 0 && remainder == (n % i)) {
            n = n / remainder;
            if (n == 0) {
                return String.valueOf(i);
            }
        }
    }
    // 返回处理后的结果
    return String.valueOf(mixSystem);
}
}
/*
    int n = Integer.parseInt(line);
    int s = n + 1;
    for (int i = 2; i <= n; i++) {
        int r = n % i;
        int t = n / i;
        while (t > 0 && (r == t % i)) {
        t = t / i;
        }
        if (t == 0) {
        s = i;
        break;
        }
        }
    return String.valueOf(s);*/
