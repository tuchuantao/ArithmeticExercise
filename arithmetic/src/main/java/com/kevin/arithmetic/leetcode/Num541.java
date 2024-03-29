package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/20
 * Desc:
 */
public class Num541 {
  /**
   * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
   * 如果剩余字符少于 k 个，则将剩余字符全部反转。
   * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
   *
   * 示例 1：
   * 输入：s = "abcdefg", k = 2
   * 输出："bacdfeg"
   *
   * 示例 2：
   * 输入：s = "abcd", k = 2
   * 输出："bacd"
   *
   * 提示：
   * 1 <= s.length <= 10^4
   * s 仅由小写英文组成
   * 1 <= k <= 10^4
   */
  public String reverseStr(String s, int k) {
    int n = s.length();
    char[] arr = s.toCharArray();
    for (int i = 0; i < n; i += 2 * k) {
      reverse(arr, i, Math.min(i + k, n) - 1);
    }
    return new String(arr);
  }

  public void reverse(char[] arr, int left, int right) {
    while (left < right) {
      char temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }
}
