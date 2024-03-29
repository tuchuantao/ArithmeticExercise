package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/19
 * Desc:
 */
public class Num345 {
  /**
   * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
   *
   * 示例 1：
   * 输入："hello"
   * 输出："holle"
   * 示例 2：
   *
   * 输入："leetcode"
   * 输出："leotcede"
   *
   * 提示：
   * 元音字母不包含字母 "y" 。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  // a、e、i、o、u
  public String reverseVowels(String s) {
    int len = s.length();
    if (len <= 1) {
      return s;
    }
    char[] arr = s.toCharArray();
    int left = 0;
    int right = len - 1;
    while (left < right) {
      while (left < right && !isVowel(s.charAt(left))) {
        left++;
      }
      while (right > left && !isVowel(s.charAt(right))) {
        right--;
      }
      if (left < right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
      }
    }
    return String.valueOf(arr);
  }

  public boolean isVowel(char ch) {
    return "aeiouAEIOU".indexOf(ch) >= 0;
  }
}
