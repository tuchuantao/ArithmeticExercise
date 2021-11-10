package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/11/10
 * Desc: 下一个排列
 */
public class Num31 {
  /**
   * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
   * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
   * 必须 原地 修改，只允许使用额外常数空间。
   *
   * 示例 1：
   * 输入：nums = [1,2,3]
   * 输出：[1,3,2]
   *
   * 示例 2：
   * 输入：nums = [3,2,1]
   * 输出：[1,2,3]
   *
   * 示例 3：
   * 输入：nums = [1,1,5]
   * 输出：[1,5,1]
   *
   * 示例 4：
   * 输入：nums = [1]
   * 输出：[1]
   *
   * 提示：
   * 1 <= nums.length <= 100
   * 0 <= nums[i] <= 100
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/next-permutation
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public void nextPermutation(int[] nums) {
    int len = nums.length;
    if (len <= 1) {
      return;
    }
    int changeIndex = -1;
    for (int i = len - 1; i > 0; i--) {
      if (nums[i] > nums[i - 1]) {
        changeIndex = i;
        break;
      }
    }
    if (changeIndex == -1) {
      reverse(nums);
    } else {
      Arrays.sort(nums, changeIndex, len);  // 没有必要，因为肯定是降序
      for (int i = changeIndex; i < len; i++) {
        if (nums[i] > nums[changeIndex - 1]) {
          int temp = nums[changeIndex - 1];
          nums[changeIndex - 1] = nums[i];
          nums[i] = temp;
          break;
        }
      }
    }
  }

  public void reverse(int[] nums) {
    int left = 0, right = nums.length - 1;
    int temp;
    while (left < right) {
      temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      left++;
      right--;
    }
  }


//  public void nextPermutation(int[] nums) {
//    int i = nums.length - 2;
//    while (i >= 0 && nums[i] >= nums[i + 1]) {
//      i--;
//    }
//    if (i >= 0) {
//      int j = nums.length - 1;
//      while (j >= 0 && nums[i] >= nums[j]) {
//        j--;
//      }
//      swap(nums, i, j);
//    }
//    reverse(nums, i + 1);
//  }
//
//  public void swap(int[] nums, int i, int j) {
//    int temp = nums[i];
//    nums[i] = nums[j];
//    nums[j] = temp;
//  }
//
//  public void reverse(int[] nums, int start) {
//    int left = start, right = nums.length - 1;
//    while (left < right) {
//      swap(nums, left, right);
//      left++;
//      right--;
//    }
//  }

}
