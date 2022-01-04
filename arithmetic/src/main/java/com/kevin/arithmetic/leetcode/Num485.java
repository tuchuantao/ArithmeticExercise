package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2022/1/4
 * Desc: 最大连续 1 的个数
 */
public class Num485 {
  /**
   * 给定一个二进制数组， 计算其中最大连续 1 的个数。
   *
   * 示例：
   * 输入：[1,1,0,1,1,1]
   * 输出：3
   * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
   *
   * 提示：
   * 输入的数组只包含0 和 1 。
   * 输入数组的长度是正整数，且不超过 10,000。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findMaxConsecutiveOnes(int[] nums) {
    int maxCount = 0;
    int tempCount = 0;
    for (int num : nums) {
      if (num == 1) {
        tempCount++;
      } else {
        maxCount = Math.max(maxCount, tempCount);
        tempCount = 0;
      }
    }
    return maxCount;
  }
}
