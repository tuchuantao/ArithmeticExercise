package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/12
 * Desc: 字符串相乘
 */
public class Num43 {
  /**
   * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
   *
   * 示例 1:
   * 输入: num1 = "2", num2 = "3"
   * 输出: "6"
   *
   * 示例2:
   * 输入: num1 = "123", num2 = "456"
   * 输出: "56088"
   *
   * 说明：
   * num1和num2的长度小于110。
   * num1 和num2 只包含数字0-9。
   * num1 和num2均不以零开头，除非是数字 0 本身。
   * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/multiply-strings
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String multiply(String num1, String num2) {
    int len1 = num1.length();
    int len2 = num2.length();
    int[] arr = new int[len1 + len2 - 1];
    for (int i = len1 - 1; i >= 0; i--) {
      for (int j = len2 - 1; j >= 0; j--) {
        int index = len1 - 1 + len2 - 1 - i - j;
        arr[index] += charNum(num1.charAt(i)) * charNum(num2.charAt(j));
      }
    }
    int lastCount = 0;
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < len1 + len2 - 1; i++) {
      arr[i] += lastCount;
      lastCount = arr[i] / 10;
      builder.append(arr[i] % 10);
    }
    if (lastCount > 0) {
      builder.append(lastCount);
    }
    builder.reverse();
    return removeStarZero(builder);
  }

  private int charNum(char cr) {
    return cr - '0';
  }

  private String removeStarZero(StringBuilder builder) {
    int len = builder.length();
    int realStartIndex = len - 1;
    for (int i = 0; i < len; i++) {
      if (builder.charAt(i) != '0') {
        realStartIndex = i;
        break;
      }
    }
    return builder.substring(realStartIndex);
  }

  // 123   456
  // 9123  0

  public static void main(String[] args) {
    String result = new Num43().multiply("9123", "0");
    System.out.println("result=" + result);
  }
}
