package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/30
 * Desc: 有序数组中的单一元素
 */
public class Num540 {
  /**
   * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
   *
   * 示例 1:
   * 输入: nums = [1,1,2,3,3,4,4,8,8]
   * 输出: 2
   *
   * 示例 2:
   * 输入: nums =  [3,3,7,7,10,11,11]
   * 输出: 10
   *
   * 提示:
   * 1 <= nums.length <= 10^5
   * 0 <= nums[i]<= 10^5
   * 
   *
   * 进阶:采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int singleNonDuplicate1(int[] nums) { // O(n) 没有利用有序
    int ans = 0;
    for (int num : nums) {
      ans ^= num;
    }
    return ans;
  }

  public int singleNonDuplicate(int[] nums) {
    int len = nums.length;
    if (len == 1) {
      return nums[0];
    }
    int left = 0;
    int right = len - 1;
    int center;
    while (right != left) {
      center = left + (right - left >> 1);
      if (nums[center] == nums[center + 1]) {
        if ((right - center - 1) % 2 == 0) {
          right = center - 1;
        } else {
          left = center + 2;
        }
      } else if (nums[center] == nums[center - 1]) {
        if ((right - center) % 2 == 0) {
          right = center - 2;
        } else {
          left = center + 1;
        }
      } else {
        return nums[center];
      }
    }
    return nums[left];
  }
}
