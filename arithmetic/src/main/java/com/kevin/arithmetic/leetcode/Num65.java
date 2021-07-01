package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/6/18
 * Desc: https://leetcode-cn.com/problems/valid-number/
 */
public class Num65 {

  public boolean isNumber(String s) {
    int dotCount = 0;
    int eCount = 0;
    int eEndNumCount = 0;
    int eEndUnitCount = 0;
    int numCount = 0;

    int len = s.length();
    for (int i = 0; i < len; i++) {
      char indexChar = s.charAt(i);
      if (indexChar == '+' || indexChar == '-') {

      }
    }

    if (dotCount > 1 || eCount > 1 || (eCount == 1 && eEndNumCount == 0) || eEndUnitCount > 1 || numCount == 0) {
      return false;
    }
    return true;
  }
}
