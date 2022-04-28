package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2022/4/28
 * Desc: 按奇偶排序数组
 */
public class Num905 {

  public int[] sortArrayByParity(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return nums;
    }

    int start = 0;
    int end = nums.length - 1;
    int temp;
    while (start < end) {
      while (start < end && nums[start] % 2 == 0) {
        start++;
      }
      while (start < end && nums[end] % 2 == 1) {
        end--;
      }
      if (start < end) {
        temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
      }
    }
    return nums;
  }
}
