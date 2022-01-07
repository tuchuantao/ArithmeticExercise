package com.kevin.arithmetic.leetcode;

import java.util.Random;

/**
 * Created by tuchuantao on 2022/1/7
 * Desc: 数组中的第K个最大元素
 */
public class Num215 {
  /**
   * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
   * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
   *
   * 示例 1:
   * 输入: [3,2,1,5,6,4] 和 k = 2
   * 输出: 5
   *
   * 示例2:
   * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
   * 输出: 4
   *
   * 提示：
   * 1 <= k <= nums.length <= 10^4
   * -10^4<= nums[i] <= 10^4
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findKthLargest1(int[] nums, int k) { // 冒泡排序
    int len = nums.length;
    int temp;
    for (int i = 0; i < len - 1 && i < k; i++) {
      for (int j = 0; j < len - i - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }

    return nums[len - k];
  }

  Random random = new Random();

  public int findKthLargest(int[] nums, int k) { // 快速排序
    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
  }

  public int quickSelect(int[] a, int l, int r, int index) {
    int q = randomPartition(a, l, r);
    if (q == index) {
      return a[q];
    } else {
      return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
    }
  }

  public int randomPartition(int[] a, int l, int r) {
    int i = random.nextInt(r - l + 1) + l;
    swap(a, i, r);
    return partition(a, l, r);
  }

  public int partition(int[] a, int l, int r) {
    int x = a[r], i = l - 1;
    for (int j = l; j < r; ++j) {
      if (a[j] <= x) {
        swap(a, ++i, j);
      }
    }
    swap(a, i + 1, r);
    return i + 1;
  }

  public void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
