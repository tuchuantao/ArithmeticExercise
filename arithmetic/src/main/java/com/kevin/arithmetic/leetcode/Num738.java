package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;

/**
 * Created by tuchuantao on 2021/10/14
 * Desc: 单调递增的数字
 */
public class Num738 {
  /**
   * 给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
   * （当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。）
   * <p>
   * 示例 1:
   * 输入: N = 10
   * 输出: 9
   * <p>
   * 示例 2:
   * 输入: N = 1234
   * 输出: 1234
   * <p>
   * 示例 3:
   * 输入: N = 332
   * 输出: 299
   * 说明: N是在[0, 10^9]范围内的一个整数。
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int monotoneIncreasingDigits(int n) {
    char[] strN = Integer.toString(n).toCharArray();
    int i = 1;
    while (i < strN.length && strN[i - 1] <= strN[i]) { // 找到递减的点
      i++;
    }
    if (i < strN.length) {
      while (i > 0 && strN[i - 1] > strN[i]) { // 从递减的点开始减1，然后判断跟上一个点是否满足递增，找到最高位改变的点
        strN[i - 1] -= 1;
        i--;
      }
      for (i += 1; i < strN.length; ++i) { // 从最高位改变的点之后，全部填充9
        strN[i] = '9';
      }
    }
    return Integer.parseInt(new String(strN));
  }
}
