package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by tuchuantao on 2022/1/19
 * Desc: 存在重复元素 III
 */
public class Num220 {
  /**
   * 给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
   * 使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
   * 如果存在则返回 true，不存在返回 false。
   *
   * 示例1：
   * 输入：nums = [1,2,3,1], k = 3, t = 0
   * 输出：true
   *
   * 示例 2：
   * 输入：nums = [1,0,1,1], k = 1, t = 2
   * 输出：true
   *
   * 示例 3：
   * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
   * 输出：false
   * 
   * 提示：
   * 0 <= nums.length <= 2 * 10^4
   * -2^31 <= nums[i] <= 2^31 - 1
   * 0 <= k <= 10^4
   * 0 <= t <= 2^31 - 1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) { // 暴力 O(n^2)  超时
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      int j = i + 1;
      while (j <= i + k && j < len) {
        if (Math.abs((long)nums[i] - nums[j]) <= t) { // (long)nums[i] - nums[j] 有可能会溢出
          return true;
        }
        j++;
      }
    }
    return false;
  }

  public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) { // 滑动窗口 + TreeSet
    int n = nums.length;
    TreeSet<Long> set = new TreeSet<Long>();
    for (int i = 0; i < n; i++) {
      Long ceiling = set.ceiling((long) nums[i] - (long) t); // ceiling()  >=
      if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
        return true;
      }
      set.add((long) nums[i]);
      if (i >= k) {
        set.remove((long) nums[i - k]);
      }
    }
    return false;
  }

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    int n = nums.length;
    Map<Long, Long> map = new HashMap<Long, Long>();
    long w = (long) t + 1;
    for (int i = 0; i < n; i++) {
      long id = getID(nums[i], w);
      if (map.containsKey(id)) {
        return true;
      }
      if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
        return true;
      }
      if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
        return true;
      }
      map.put(id, (long) nums[i]);
      if (i >= k) {
        map.remove(getID(nums[i - k], w));
      }
    }
    return false;
  }

  public long getID(long x, long w) {
    if (x >= 0) {
      return x / w;
    }
    return (x + 1) / w - 1;
  }
}
