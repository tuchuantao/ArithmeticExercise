package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/12/2
 * Desc: 乘积小于K的子数组
 */
public class Num713 {
  /**
   * 给定一个正整数数组nums和整数 k 。
   * 请找出该数组内乘积小于k的连续的子数组的个数。
   *
   * 示例 1:
   * 输入: nums = [10,5,2,6], k = 100
   * 输出: 8
   * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
   * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
   *
   * 示例 2:
   * 输入: nums = [1,2,3], k = 0
   * 输出: 0
   * 
   * 提示:
   * 1 <= nums.length <= 3 * 10^4
   * 1 <= nums[i] <= 1000
   * 0 <= k <= 10^6
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int numSubarrayProductLessThanK1(int[] nums, int k) { // 超时
    int len = nums.length;
    double[] dp = new double[len]; // 有可能发生溢出
    Arrays.fill(dp, 1);
    int count = 0;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (j + i < len) {
          dp[j] *= nums[j + i];
          if (dp[j] < k) {
            count++;
          }
        }
      }
    }
    return count;
  }

  public int numSubarrayProductLessThanK2(int[] nums, int k) { // 超时
    int len = nums.length;
    int[] dp = new int[len]; // 有可能发生溢出
    Arrays.fill(dp, 1);
    int count = 0;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        if (j + i < len && dp[j] < k) { // nums是正整数
          dp[j] *= nums[j + i];
          if (dp[j] < k) {
            count++;
          }
        }
      }
    }
    return count;
  }

  /**
   * 知道是滑动窗口，但是没写出来。看了大佬们的思路写了一遍，关键是要理解
   * r-l+1，以及为什么不会重复
   * 每一次循环找的是以r为右边界的子数组，r一直在变，所以一定不重复
   * 比如5，2，6此时满足条件，此时右边界为6，要找的数组就是[6],[6,2],[6,2,5]
   * 每个长度的数组只有一个，相当于求这个l...r的闭区间长度
   * 边界处理：当k为0或者1直接返回0
   * 这样也保证了在收缩左边界时候不会越界，因为l收缩到r之后base就为1了，一定小于k，会退出内层循环
   * 此时表示没有合适的区间满足乘积小于k，此时l++之后l=r+1的，r-l+1也正好是0
   */
  public int numSubarrayProductLessThanK(int[] nums, int k) { // 滑动窗口
    if (k <= 1) return 0;
    int prod = 1, ans = 0, left = 0;
    for (int right = 0; right < nums.length; right++) {
      prod *= nums[right];
      while (prod >= k) prod /= nums[left++];
      ans += right - left + 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int result = new Num713().numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100);
    System.out.println("result=" + result);
  }

}
