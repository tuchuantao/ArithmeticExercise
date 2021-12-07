package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/3
 * Desc: 二进制求和
 */
public class Num67 {
  /**
   * 给你两个二进制字符串，返回它们的和（用二进制表示）。
   * 输入为 非空 字符串且只包含数字1和0。
   *
   * 示例1:
   * 输入: a = "11", b = "1"
   * 输出: "100"
   *
   * 示例2:
   * 输入: a = "1010", b = "1011"
   * 输出: "10101"
   * 
   * 提示：
   *
   * 每个字符串仅由字符 '0' 或 '1' 组成。
   * 1 <= a.length, b.length <= 10^4
   * 字符串如果不是 "0" ，就都不含前导零。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/add-binary
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String addBinary(String a, String b) {
    int aLen = a.length();
    int bLen = b.length();
    int len = Math.max(aLen, bLen);
    int last = 0;
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < len; i++) {
      int tempA = 0;
      int tempB = 0;
      if (i < aLen) {
        tempA = a.charAt(aLen - 1 - i) - '0';
      }
      if (i < bLen) {
        tempB = b.charAt(bLen - 1 - i) - '0';
      }
      int sum = tempA + tempB + last;
      last = 0;
      if (sum >= 2) {
        last = 1;
        sum -= 2;
        if (i == len - 1) {
          sum += 10;
        }
      }
      builder.insert(0, sum);
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    String result = new Num67().addBinary("1111", "1111");
    System.out.println("result=" + result);
  }
}
