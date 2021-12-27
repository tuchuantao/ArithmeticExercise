package com.kevin.arithmetic.leetcode;

import java.util.HashMap;

/**
 * Created by tuchuantao on 2021/7/23
 * Desc: 和为 K 的子数组
 */
public class Num560 {
  /**
   * 给定一个整数数组和一个整数k，你需要找到该数组中和为k的连续的子数组的个数。
   * <p>
   * 示例 1 :
   * 输入:nums = [1,1,1], k = 2
   * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
   * <p>
   * 说明 :
   * 数组的长度为 [1, 20,000]。
   * 数组中元素的范围是 [-1000, 1000] ，且整数k的范围是[-1e7, 1e7]。
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int subarraySum11(int[] nums, int k) { // 暴力
    int len = nums.length;
    for (int i = 1; i < len; i++) {
      nums[i] = nums[i] + nums[i - 1];
    }
    int subLen = 1;
    int result = 0;
    while (subLen <= len) {
      for (int i = 0; i <= len - subLen; i++) {
        int tempSum = nums[i + subLen - 1];
        if (i > 0) {
          tempSum -= nums[i - 1];
        }
        if (tempSum == k) {
          result++;
        }
      }
      subLen++;
    }
    return result;
  }

  public int subarraySum(int[] nums, int k) {
    int count = 0, pre = 0;
    HashMap<Integer, Integer> mp = new HashMap<>();
    mp.put(0, 1); // 和正好为K
    for (int i = 0; i < nums.length; i++) {
      pre += nums[i];
      if (mp.containsKey(pre - k)) { // pre 为累加和， pre - k  ~ pre 的和为K
        count += mp.get(pre - k);
      }
      mp.put(pre, mp.getOrDefault(pre, 0) + 1);
    }
    return count;
  }

}
