package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/11/2
 * Desc: 最接近的三数之和
 */
public class Num16 {
  /**
   * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
   *
   * 示例：
   * 输入：nums = [-1,2,1,-4], target = 1
   * 输出：2
   * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
   *
   * 提示：
   * 3 <= nums.length <= 10^3
   * -10^3<= nums[i]<= 10^3
   * -10^4<= target<= 10^4
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/3sum-closest
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int threeSumClosest(int[] nums, int target) {
    int minNum = 100000;
    Arrays.sort(nums);
    int len = nums.length;
    for (int i = 0; i < len - 2; i++) {
      int left = i + 1;
      int right = len - 1;
      while (left <= right) {
        if (Math.abs(nums[left] + nums[right] + nums[i] - target) < Math.abs(minNum - target)) {
          minNum = nums[left] + nums[right] + nums[i];
        }
        if (nums[left] + nums[right] + nums[i] == target) {
          return target;
        } else if (nums[left] + nums[right] + nums[i] < target) {
          left++;
        } else {
          right--;
        }
      }
    }
    return minNum;
  }

}
