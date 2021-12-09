package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/12/8
 * Desc: 验证回文字符串 Ⅱ
 */
public class Num680 {
  /**
   * 给定一个非空字符串s，最多删除一个字符。判断是否能成为回文字符串。
   *
   * 示例 1:
   * 输入: s = "aba"
   * 输出: true
   *
   * 示例 2:
   * 输入: s = "abca"
   * 输出: true
   * 解释: 你可以删除c字符。
   *
   * 示例 3:
   * 输入: s = "abc"
   * 输出: false
   *
   * 提示:
   * 1 <= s.length <= 10^5
   * s 由小写英文字母组成
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean validPalindrome1(String s) {
    int len = s.length();
    int left = 0, right = len - 1;
    while (left < right) {
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
      } else {
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        if (left > 0) {
          builder1.append(s.substring(0, left));
        }
        builder1.append(s.substring(left + 1, len));
        builder2.append(s.substring(0, right));
        if (right < len - 1) {
          builder2.append(s.substring(right + 1, len));
        }
        return builder1.toString().equals(builder1.reverse().toString()) ||
            builder2.toString().equals(builder2.reverse().toString());
      }
    }
    return true;
  }

  public boolean validPalindrome(String s) {
    int len = s.length();
    int left = 0, right = len - 1;
    while (left < right) {
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
      } else { // 优化，左右两边已经判断了，只需要判断 left ~ right
        String str1 = s.substring(left, right);
        String reverseStr1 = new StringBuilder()
            .append(str1).reverse().toString();
        String str2 = s.substring(left + 1, right + 1);
        String reverseStr2 = new StringBuilder()
            .append(str2).reverse().toString();
        return str1.equals(reverseStr1) || str2.equals(reverseStr2);
      }
    }
    return true;
  }
}
