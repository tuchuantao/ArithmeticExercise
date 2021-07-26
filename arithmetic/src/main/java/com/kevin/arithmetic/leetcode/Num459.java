package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/26
 * Desc:
 */
public class Num459 {
  /**
   * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
   *
   * 示例 1:
   * 输入: "abab"
   * 输出: True
   * 解释: 可由子字符串 "ab" 重复两次构成。
   *
   * 示例 2:
   * 输入: "aba"
   * 输出: False
   *
   * 示例 3:
   * 输入: "abcabcabcabc"
   * 输出: True
   * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
   */
  public boolean repeatedSubstringPattern11(String s) { // 暴力枚举 O(n^2)
    int len = s.length();
    for (int i = 1; i * 2 <= len; i++) {
      if (len % i == 0) { // 无法平分，直接舍去
        boolean match = true;
        String target = s.substring(0, i);
        for (int j = i; j <= len - i; j += i) {
          if (!target.equals(s.substring(j, j + i))) {
            match = false;
            break;
          }
        }
        if (match) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean repeatedSubstringPattern22(String s) { // 字符串匹配  abab + abab
    return (s + s).indexOf(s, 1) != s.length();
  }

  public boolean repeatedSubstringPattern(String s) { // KMP

    return false;
  }

  public static void main(String[] args) {
//    boolean result = new Num459().repeatedSubstringPattern("aabaaba");
    boolean result = new Num459().repeatedSubstringPattern("abab");
    System.out.println("result=" + result);
  }
}
