package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/12
 * Desc: 验证回文串
 */
public class Num125AndOffer018 {
  /**
   * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
   * 说明：本题中，我们将空字符串定义为有效的回文串。
   *
   * 示例 1:
   * 输入: "A man, a plan, a canal: Panama"
   * 输出: true
   * 解释："amanaplanacanalpanama" 是回文串
   *
   * 示例 2:
   * 输入: "race a car"
   * 输出: false
   * 解释："raceacar" 不是回文串
   * 
   * 提示：
   * 1 <= s.length <= 2 * 10^5
   * 字符串 s 由 ASCII 字符组成
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/valid-palindrome
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isPalindrome(String s) {
    StringBuffer sgood = new StringBuffer();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      char ch = s.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        sgood.append(Character.toLowerCase(ch));
      }
    }
    StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
    return sgood.toString().equals(sgood_rev.toString());
  }

  public boolean isPalindrome22(String s) { // 双指针
    StringBuffer sgood = new StringBuffer();
    int length = s.length();
    for (int i = 0; i < length; i++) {
      char ch = s.charAt(i);
      if (Character.isLetterOrDigit(ch)) {
        sgood.append(Character.toLowerCase(ch));
      }
    }
    int n = sgood.length();
    int left = 0, right = n - 1;
    while (left < right) {
      if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
        return false;
      }
      ++left;
      --right;
    }
    return true;
  }
}
