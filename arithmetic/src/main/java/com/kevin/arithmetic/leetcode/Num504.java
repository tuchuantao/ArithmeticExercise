package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2022/3/7
 * Desc: 七进制数
 */
public class Num504 {
  /**
   * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
   *
   * 示例 1:
   * 输入: num = 100
   * 输出: "202"
   *
   * 示例 2:
   * 输入: num = -7
   * 输出: "-10"
   * 
   * 提示：
   * -10^7<= num <= 10^7
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/base-7
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String convertToBase7(int num) {
    if (num == 0) {
      return "0";
    }
    boolean negative = num < 0;
    num = Math.abs(num);
    StringBuilder builder = new StringBuilder();
    int temp = 0;
    while (num >= 7) {
      temp = num % 7;
      num = num / 7;
      builder.append(temp);
    }
    if (num > 0) {
      builder.append(num);
    }
    if (negative) {
      builder.append("-");
    }
    return builder.reverse().toString();
  }

// 官方
//  public String convertToBase7(int num) {
//    if (num == 0) {
//      return "0";
//    }
//    boolean negative = num < 0;
//    num = Math.abs(num);
//    StringBuffer digits = new StringBuffer();
//    while (num > 0) {
//      digits.append(num % 7);
//      num /= 7;
//    }
//    if (negative) {
//      digits.append('-');
//    }
//    return digits.reverse().toString();
//  }

  public static void main(String[] args) {
    String res = new Num504().convertToBase7(0);
    System.out.println("res=" + res);
  }
}
