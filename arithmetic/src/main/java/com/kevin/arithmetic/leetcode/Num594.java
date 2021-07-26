package com.kevin.arithmetic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/7/26
 * Desc:
 */
public class Num594 {
  /**
   * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
   * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
   * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
   *
   * 示例 1：
   * 输入：nums = [1,3,2,2,5,2,3,7]
   * 输出：5
   * 解释：最长的和谐子序列是 [3,2,2,2,3]
   *
   * 示例 2：
   * 输入：nums = [1,2,3,4]
   * 输出：2
   *
   * 示例 3：
   * 输入：nums = [1,1,1,1]
   * 输出：0
   *
   * 提示：
   * 1 <= nums.length <= 2 * 10^4
   * -10^9 <= nums[i] <= 10^9
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findLHS(int[] nums) {
    Arrays.sort(nums);
    int maxLen = 0;
    int len = nums.length;
    Map<Integer, Integer> map = new HashMap(len);
    for (int i = 0; i < len; i++) {
      int target = nums[i];
      int count = 1;
      while (i < len - 1 && target == nums[i + 1]) {
        i++;
        count++;
      }
      map.put(nums[i], count);
      int lastCount = map.getOrDefault(target - 1, 0);
      if (lastCount != 0) {
        maxLen = Math.max(maxLen, count + lastCount);
      }
    }
    return maxLen;
  }
}
