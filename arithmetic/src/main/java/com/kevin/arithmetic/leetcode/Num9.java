package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/12
 * Desc:
 */
public class Num9 {
  /**
   * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
   * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
   *
   * 示例 1：
   * 输入：x = 121
   * 输出：true
   *
   * 示例2：
   * 输入：x = -121
   * 输出：false
   * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
   *
   * 示例 3：
   * 输入：x = 10
   * 输出：false
   * 解释：从右向左读, 为 01 。因此它不是一个回文数。
   *
   * 示例 4：
   * 输入：x = -101
   * 输出：false
   *
   * 提示：
   * -2^31<= x <= 2^31- 1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/palindrome-number
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isPalindrome(int x) {
    String str = String.valueOf(x);
    int len = str.length();
    int left = 0, right = len - 1;
    while (left < right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
