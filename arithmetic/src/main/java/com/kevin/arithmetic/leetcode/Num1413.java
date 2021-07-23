package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/23
 * Desc:
 */
public class Num1413 {

  /**
   * 给你一个整数数组 nums。你可以选定任意的正数 startValue 作为初始值。
   * 你需要从左到右遍历 nums数组，并将 startValue 依次累加上nums数组中的值。
   * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的正数作为 startValue 。
   *
   * 示例 1：
   * 输入：nums = [-3,2,-3,4,2]
   * 输出：5
   * 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
   *                 累加求和
   *                startValue = 4 | startValue = 5 | nums
   *                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
   *                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
   *                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
   *                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
   *                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
   *
   *  示例 2：
   * 输入：nums = [1,2]
   * 输出：1
   * 解释：最小的 startValue 需要是正数。
   *
   *  示例 3：
   * 输入：nums = [1,-2,-3]
   * 输出：5
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int minStartValue(int[] nums) {
    int minPrefixSum = Integer.MAX_VALUE;
    int prefixSum = 0;
    for (int num : nums) {
      prefixSum += num;
      minPrefixSum = Math.min(minPrefixSum, prefixSum);
    }
    if (minPrefixSum > 0) {
      return 1;
    } else {
      return 1 - minPrefixSum;
    }
  }
}
