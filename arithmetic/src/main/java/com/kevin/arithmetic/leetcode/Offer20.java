package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/18
 * Desc: 表示数值的字符串
 */
public class Offer20 {
  /**
   * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
   * 数值（按顺序）可以分成以下几个部分：
   * 1、若干空格
   * 2、一个小数或者整数
   * 3、（可选）一个'e'或'E'，后面跟着一个整数
   * 4、若干空格
   *
   * 小数（按顺序）可以分成以下几个部分：
   * 1、（可选）一个符号字符（'+' 或 '-'）
   * 2、下述格式之一：
   *    1、至少一位数字，后面跟着一个点 '.'
   *    2、至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
   *    3、一个点 '.' ，后面跟着至少一位数字
   *
   * 整数（按顺序）可以分成以下几个部分：
   * 1、（可选）一个符号字符（'+' 或 '-'）
   * 2、至少一位数字
   *
   * 部分数值列举如下：
   *    ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
   * 部分非数值列举如下：
   *    ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
   * 
   * 示例 1：
   * 输入：s = "0"
   * 输出：true
   *
   * 示例 2：
   * 输入：s = "e"
   * 输出：false
   *
   * 示例 3：
   * 输入：s = "."
   * 输出：false
   *
   * 示例 4：
   * 输入：s = ".1"
   * 输出：true
   *
   * 提示：
   * 1 <= s.length <= 20
   * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isNumber(String s) {
    s = s.trim(); // String.trim()是返回一个新的字符串，并不是直接更改本来的String
    int len = s.length();
    if (len == 0) {
      return false;
    } if (len == 1) {
      return s.charAt(0) >= '0' && s.charAt(0) <= '9';
    }
    boolean hasDot = false, hasE = false, hasEEndNum = false, hasEBeforeNum = false;
    int index = 0;
    if (s.charAt(0) == '+' || s.charAt(0) == '-') {
      index++;
    }
    char tempChar;
    for (; index < len; index++) {
      tempChar = s.charAt(index);
      if (tempChar == '+' || tempChar == '-') {
        if (!hasE || !(s.charAt(index - 1) == 'e' || s.charAt(index - 1) == 'E')) {
          return false;
        }
      } else if (tempChar == 'e' || tempChar == 'E') {
        if (hasE) {
          return false;
        }
        hasE = true;
      } else if (tempChar == '.') {
        if (hasDot || hasE) {
          return false;
        }
        hasDot = true;
      } else if (tempChar < '0' || tempChar > '9') {
        return false;
      } else if (hasE) {
        hasEEndNum = true;
      } else {
        hasEBeforeNum = true;
      }
    }
    if (hasE) {
      return hasEBeforeNum && hasEEndNum;
    }
    return hasEBeforeNum;
  }

  public static void main(String[] args) {
    boolean result = new Offer20().isNumber("+1");
    System.out.println("result=" + result);
  }
}
