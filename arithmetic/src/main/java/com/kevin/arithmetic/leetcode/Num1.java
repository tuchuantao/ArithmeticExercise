package com.kevin.arithmetic.leetcode;

import java.util.HashMap;

import com.kevin.arithmetic.util.Utils;

/**
 * Created by tuchuantao on 2021/12/7
 * Desc: 两数之和
 */
public class Num1 {
  /**
   * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
   * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
   * 你可以按任意顺序返回答案。
   *
   * 示例 1：
   * 输入：nums = [2,7,11,15], target = 9
   * 输出：[0,1]
   * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
   *
   * 示例 2：
   * 输入：nums = [3,2,4], target = 6
   * 输出：[1,2]
   *
   * 示例 3：
   * 输入：nums = [3,3], target = 6
   * 输出：[0,1]
   *
   * 提示：
   * 2 <= nums.length <= 10^4
   * -10^9 <= nums[i] <= 10^9
   * -10^9 <= target <= 10^9
   * 只会存在一个有效答案
   * 进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/two-sum
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] twoSum1(int[] nums, int target) { // 哈希
    HashMap<Integer, Integer> map = new HashMap();
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      Integer index = map.get(target - nums[i]);
      if (index != null) {
        return new int[] {i, index};
      }
      map.put(nums[i], i);
    }
    return null;
  }

}
