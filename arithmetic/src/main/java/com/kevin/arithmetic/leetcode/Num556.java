package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/11/2
 * Desc: 下一个更大元素 III
 */
public class Num556 {
  /**
   * 给你一个正整数n ，请你找出符合条件的最小整数，其由重新排列 n中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
   * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
   *
   * 示例 1：
   * 输入：n = 12
   * 输出：21
   *
   * 示例 2：
   * 输入：n = 21
   * 输出：-1
   *
   * 提示：
   * 1 <= n <= 231 - 1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/next-greater-element-iii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int nextGreaterElement(int n) {
    if (n <= 10) {
      return -1;
    }
    char[] arr = String.valueOf(n).toCharArray();
    int len = arr.length;
    int index = -1;
    for (int i = len - 1; i > 0; i--) {
      if (arr[i] > arr[i - 1]) {
        index = i;
        break;
      }
    }
    if (index == -1) {
      return -1;
    }
    Arrays.sort(arr, index, len);
    for (int i = index; i < len; i++) {
      if (arr[i] > arr[index - 1]) {
        char temp = arr[i];
        arr[i] = arr[index - 1];
        arr[index - 1] = temp;
        break;
      }
    }
    long result = Long.valueOf(String.valueOf(arr));
    return result > Integer.MAX_VALUE ? -1 : (int) result;
  }
}
