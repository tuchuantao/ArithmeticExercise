package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/7/23
 * Desc: 连续数组
 */
public class Num525 {
  /**
   * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
   *
   * 示例 1:
   * 输入: nums = [0,1]
   * 输出: 2
   * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
   *
   * 示例 2:
   * 输入: nums = [0,1,0]
   * 输出: 2
   * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
   * 
   * 提示：
   * 1 <= nums.length <= 10^5
   * nums[i] 不是 0 就是 1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/contiguous-array
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findMaxLength11(int[] nums) { // 暴力
    int len = nums.length;
    for (int i = 1; i < len; i++) {
      nums[i] += nums[i - 1];
    }
    int subLen = len;
    while (subLen >= 2) {
      for (int i = 0; i < len - subLen + 1; i++) {
        int sum = nums[i + subLen - 1];
        if (i > 0) {
          sum -= nums[i - 1];
        }
        if (sum * 2 == subLen) {
          return subLen;
        }
      }
      subLen--;
    }
    return 0;
  }

  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> map = new HashMap();
    map.put(0, -1);
    int maxLength = 0;
    int len = nums.length;
    int counter = 0;
    for (int i = 0; i < len; i++) {
      if (nums[i] == 1) {
        counter++;
      } else {
        counter--;
      }
      if (map.containsKey(counter)) {
        int preIndex = map.get(counter);
        maxLength = Math.max(maxLength, i - preIndex);
      } else {
        map.put(counter, i);
      }
    }
    return maxLength;
  }
}
