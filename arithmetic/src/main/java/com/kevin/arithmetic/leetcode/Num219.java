package com.kevin.arithmetic.leetcode;

import java.util.HashMap;

/**
 * Created by tuchuantao on 2022/1/19
 * Desc: 存在重复元素 II
 */
public class Num219 {
  /**
   * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，
   * 满足 nums[i] == nums[j] 且 abs(i - j) <= k。如果存在，返回 true ；否则，返回 false 。
   *
   * 示例1：
   * 输入：nums = [1,2,3,1], k = 3
   * 输出：true
   *
   * 示例 2：
   * 输入：nums = [1,0,1,1], k = 1
   * 输出：true
   *
   * 示例 3：
   * 输入：nums = [1,2,3,1,2,3], k = 2
   * 输出：false
   *
   * 提示：
   *
   * 1 <= nums.length <= 10^5
   * -10^9 <= nums[i] <= 10^9
   * 0 <= k <= 10^5
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap();
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      Integer index = map.get(nums[i]);
      if (index != null && i - index <= k) {
        return true;
      }
      map.put(nums[i], i);
    }
    return false;
  }
}
