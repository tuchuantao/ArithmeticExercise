package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/7/23
 * Desc:
 */
public class Num523 {
  /**
   * 给你一个整数数组 nums 和一个整数k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
   * 子数组大小 至少为 2 ，且子数组元素总和为 k 的倍数。
   * 如果存在，返回 true ；否则，返回 false 。
   * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
   * <p>
   * 示例 1：
   * 输入：nums = [23,2,4,6,7], k = 6
   * 输出：true
   * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
   * <p>
   * 示例 2：
   * 输入：nums = [23,2,6,4,7], k = 6
   * 输出：true
   * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
   * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
   * <p>
   * 示例 3：
   * 输入：nums = [23,2,6,4,7], k = 13
   * 输出：false
   * <p>
   * 提示：
   * <p>
   * 1 <= nums.length <= 10^5
   * 0 <= nums[i] <= 10^9
   * 0 <= sum(nums[i]) <= 2^31 - 1
   * 1 <= k <= 2^31 - 1
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean checkSubarraySum11(int[] nums, int k) { // 暴力解法，超时
    int len = nums.length;
    for (int i = 1; i < len; i++) {
      nums[i] = nums[i] + nums[i - 1];
    }
    int subLen = 2;
    while (subLen <= len) {
      for (int i = 0; i <= len - subLen; i++) {
        int tempSum = nums[i + subLen - 1];
        if (i > 0) {
          tempSum -= nums[i - 1];
        }
        if (tempSum % k == 0) {
          return true;
        }
      }
      subLen++;
    }

    return false;
  }

  public boolean checkSubarraySum(int[] nums, int k) {
    int len = nums.length;
    if (len < 2) {
      return false;
    }
    Map<Integer, Integer> map = new HashMap();
    map.put(0, -1); // 规定空的前缀的结束下标为 -1，由于空的前缀的元素和为 0，因此在哈希表中存入键值对 (0,-1)。
    int remainder = 0;
    for (int i = 0; i < len; i++) {
      remainder = (remainder + nums[i]) % k;
      if (map.containsKey(remainder)) { // 余数相同，表示中间经过了 n个K
        int prevIndex = map.get(remainder);
        if (i - prevIndex >= 2) {
          return true;
        }
      } else {
        map.put(remainder, i);
      }
    }
    return false;
  }
}
