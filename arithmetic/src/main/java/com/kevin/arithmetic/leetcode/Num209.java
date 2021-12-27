package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/23
 * Desc: 长度最小的子数组
 */
public class Num209 {
  /**
   * 给定一个含有n个正整数的数组和一个正整数 target 。
   * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr]
   * ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
   *
   * 示例 1：
   * 输入：target = 7, nums = [2,3,1,2,4,3]
   *
   * 输出：2
   * 解释：子数组[4,3]是该条件下的长度最小的子数组。
   *
   * 示例 2：
   * 输入：target = 4, nums = [1,4,4]
   * 输出：1
   *
   * 示例 3：
   * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
   * 输出：0
   * 
   * 提示：
   * 1 <= target <= 10^9
   * 1 <= nums.length <= 10^5
   * 1 <= nums[i] <= 10^5
   *
   * 进阶：
   * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int minSubArrayLen(int target, int[] nums) {
    int left = 0;
    int right = left;
    int sum = nums[left];
    int subLen = 0;
    int len = nums.length;
    while (right < len) {
      if (sum < target) {
        right++;
        if (right < len) {
          sum += nums[right];
        }
      } else {
        while (left < len && sum - nums[left] >= target) {
          sum -= nums[left];
          left++;
        }
        if (subLen == 0) {
          subLen = right - left + 1;
        } else {
          subLen = Math.min(subLen, right - left + 1);
        }
        sum -= nums[left];
        left++;
      }
    }

    return subLen;
  }

  public int minSubArrayLen22(int target, int[] nums) {
    int left = 0;
    int right = left;
    int sum = 0;
    int subLen = 0;
    int len = nums.length;
    while (right < len) {
      sum += nums[right];
      while (left < right && sum - nums[left] >= target) {
        sum -= nums[left];
        left++;
      }
      if (sum >= target) {
        if (subLen == 0) {
          subLen = right - left + 1;
        } else {
          subLen = Math.min(subLen, right - left + 1);
        }
        sum -= nums[left];
        left++;
      }
      right++;
    }

    return subLen;
  }
}
