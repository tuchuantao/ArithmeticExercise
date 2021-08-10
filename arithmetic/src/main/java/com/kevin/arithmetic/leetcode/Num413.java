package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;

/**
 * Created by tuchuantao on 2021/8/10
 * Desc:
 */
public class Num413 {
  /**
   * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
   * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
   * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
   * 子数组 是数组中的一个连续序列。
   *
   * 示例 1：
   * 输入：nums = [1,2,3,4]
   * 输出：3
   * 解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
   *
   * 示例 2：
   * 输入：nums = [1]
   * 输出：0
   *
   * 提示：
   * 1 <= nums.length <= 5000
   * -1000 <= nums[i] <= 1000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/arithmetic-slices
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int numberOfArithmeticSlices(int[] nums) {
    ArrayList<Integer> slices = new ArrayList();
    int beginIndex = 0;
    int len = nums.length;
    int maxLen = 0;
    for (int i = 1; i <= len - 2; i++) {
      if (nums[i - 1] - nums[i] != nums[i] - nums[i + 1]) {
        if (i - beginIndex >= 2) {
          slices.add(i - beginIndex + 1);
          maxLen = Math.max(maxLen, i - beginIndex + 1);
        }
        beginIndex = i;
      }
    }
    if (len - 1 - beginIndex >= 2) {
      slices.add(len - beginIndex);
      maxLen = Math.max(maxLen, len - beginIndex);
    }

    if (slices.isEmpty()) {
      return 0;
    }
    int[] counts = new int[maxLen + 1];
    counts[3] = 1;
    for (int i = 4; i < maxLen + 1; i++) {
      counts[i] = counts[i - 1] + (i - 2);
    }
    int sum = 0;
    for (Integer num : slices) {
      sum += counts[num];
    }
    return sum;
  }

  public int numberOfArithmeticSlices22(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return 0;
    }

    int d = nums[0] - nums[1], t = 0;
    int ans = 0;
    // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
    for (int i = 2; i < n; ++i) {
      if (nums[i - 1] - nums[i] == d) {
        ++t;
      } else {
        d = nums[i - 1] - nums[i];
        t = 0;
      }
      ans += t;
    }
    return ans;
  }
}
