package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/23
 * Desc:
 */
public class Num724 {
  /**
   * 给你一个整数数组nums ，请计算数组的 中心下标 。
   * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
   * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
   * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
   *
   * 示例 1：
   * 输入：nums = [1, 7, 3, 6, 5, 6]
   * 输出：3
   * 解释：
   * 中心下标是 3 。
   * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
   * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
   *
   *  示例 2：
   * 输入：nums = [1, 2, 3]
   * 输出：-1
   * 解释：
   * 数组中不存在满足此条件的中心下标。
   *
   * 示例 3：
   * 输入：nums = [2, 1, -1]
   * 输出：0
   * 解释：
   * 中心下标是 0 。
   * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
   * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
   * 
   *
   * 提示：
   *
   * 1 <= nums.length <= 10^4
   * -1000 <= nums[i] <= 1000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/find-pivot-index
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int pivotIndex(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    int len = nums.length;
    int leftSum = 0;
    for (int i = 0; i < len; i++) {
      if (i > 0) {
        leftSum += nums[i - 1];
      }
      if (leftSum == sum - nums[i] - leftSum) {
        return i;
      }
    }
    return -1;
  }
}