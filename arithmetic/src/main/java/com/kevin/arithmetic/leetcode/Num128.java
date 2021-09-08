package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/9/8
 * Desc:
 */
public class Num128 {
  /**
   * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
   * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
   *
   * 示例 1：
   * 输入：nums = [100,4,200,1,3,2]
   * 输出：4
   * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
   *
   * 示例 2：
   * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
   * 输出：9
   *
   * 提示：
   * 0 <= nums.length <= 10^5
   * -10^9 <= nums[i] <= 10^9
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int longestConsecutive(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap();
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      map.put(nums[i], 0);
    }
    Iterator<Integer> iterator = map.keySet().iterator();
    int maxLen = 0;
    while (iterator.hasNext()) {
      int key = iterator.next();
      if (map.getOrDefault(key, -1) == 1) {
        continue;
      }
      int subLen = 1;
      int left = key - 1;
      while (map.getOrDefault(left, -1) == 0) {
        map.put(left, 1);
        left--;
        subLen++;
      }
      int right = key + 1;
      while (map.getOrDefault(right, -1) == 0) {
        map.put(right, 1);
        right++;
        subLen++;
      }
      maxLen = Math.max(maxLen, subLen);
    }
    return maxLen;
  }
}
