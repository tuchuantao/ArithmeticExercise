package com.kevin.arithmetic.leetcode;

import java.util.HashMap;

/**
 * Created by tuchuantao on 2022/1/19
 * Desc: 存在重复元素
 */
public class Num217 {
  /**
   * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
   *
   * 示例 1：
   * 输入：nums = [1,2,3,1]
   * 输出：true
   *
   * 示例 2：
   * 输入：nums = [1,2,3,4]
   * 输出：false
   *
   * 示例3：
   * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
   * 输出：true
   * 
   *
   * 提示：
   * 1 <= nums.length <= 10^5
   * -10^9 <= nums[i] <= 10^9
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/contains-duplicate
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean containsDuplicate(int[] nums) {
    HashMap<Integer, Byte> map = new HashMap();
    for (int num : nums) {
      if (map.get(num) != null) {
        return true;
      }
      map.put(num, (byte)1);
    }
    return false;
  }
}
