package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/12
 * Desc:
 */
public class Offer58 {
  /**
   * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
   * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
   *
   * 示例 1：
   * 输入: s = "abcdefg", k = 2
   * 输出:"cdefgab"
   *
   * 示例 2：
   * 输入: s = "lrloseumgh", k = 6
   * 输出:"umghlrlose"
   *
   * 限制：
   * 1 <= k < s.length <= 10000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String reverseLeftWords(String s, int n) {
    int len = s.length();
    if (len <= n) {
      return s;
    }
    StringBuilder builder = new StringBuilder(s.substring(n, len));
    builder.append(s.substring(0, n));
    return builder.toString();
  }
}
