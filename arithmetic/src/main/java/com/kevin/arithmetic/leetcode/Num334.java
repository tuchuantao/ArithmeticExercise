package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by tuchuantao on 2022/1/12
 * Desc: 递增的三元子序列
 */
public class Num334 {
  /**
   * 给你一个整数数组nums ，判断这个数组中是否存在长度为 3 的递增子序列。
   * 如果存在这样的三元组下标 (i, j, k)且满足 i < j < k ，使得nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
   *
   * 示例 1：
   * 输入：nums = [1,2,3,4,5]
   * 输出：true
   * 解释：任何 i < j < k 的三元组都满足题意
   *
   * 示例 2：
   * 输入：nums = [5,4,3,2,1]
   * 输出：false
   * 解释：不存在满足题意的三元组
   *
   * 示例 3：
   * 输入：nums = [2,1,5,0,4,6]
   * 输出：true
   * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
   * 
   * 提示：
   * 1 <= nums.length <= 5 * 10^5
   * -2^31 <= nums[i] <= 2^31 - 1
   * 
   * 进阶：你能实现时间复杂度为 O(n) ，空间复杂度为 O(1) 的解决方案吗？
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/increasing-triplet-subsequence
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean increasingTriplet1(int[] nums) { // O(n^2) 暴力 (超时)
    List<int[]> list = new ArrayList();
    int len = nums.length;
    list.add(new int[]{nums[0], 1});
    for (int i = 1; i < len; i++) {
      int size = list.size();
      int index = -1;
      int maxCount = 0;
      for (int j = 0; j < size; j++) {
        if (nums[i] > list.get(j)[0]) {
          maxCount = Math.max(maxCount, list.get(j)[0]);
        } else {
          index = j;
          break;
        }
      }
      maxCount++;
      if (maxCount >= 3) {
        return true;
      }
      if (index == -1) {
        list.add(new int[]{nums[i], maxCount});
      } else {
        list.add(index, new int[]{nums[i], maxCount});
      }
    }
    return false;
  }

  /**
   * 如果数组 nums 中存在一个下标 i 满足 1 <= i < n - 1，使得在 nums[i]
   * 的左边存在一个元素小于 nums[i] 且在 nums[i] 的右边存在一个元素大于 nums[i]，则数组 nums 中存在递增的三元子序列。
   *
   * 在 nums[i] 的左边存在一个元素小于 nums[i] 等价于在 nums[i]的左边的最小元素小于 nums[i]，在 nums[i] 的右边存在一个元素大于
   * nums[i] 等价于在 nums[i] 的右边的最大元素大于 nums[i]，因此可以维护数组nums 中的每个元素左边的最小值和右边的最大值。
   * @param nums
   * @return
   */
  public boolean increasingTriplet2(int[] nums) { // O(n)  双向遍历
    int n = nums.length;
    if (n < 3) {
      return false;
    }
    int[] leftMin = new int[n];
    leftMin[0] = nums[0];
    for (int i = 1; i < n; i++) {
      leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
    }
    int[] rightMax = new int[n];
    rightMax[n - 1] = nums[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
    }
    for (int i = 1; i < n - 1; i++) {
      if (nums[i] > leftMin[i - 1] && nums[i] < rightMax[i + 1]) {
        return true;
      }
    }
    return false;
  }

  public boolean increasingTriplet(int[] nums) { // 贪心：尽量找出最小的 first 和 second
    int n = nums.length;
    if (n < 3) {
      return false;
    }
    int first = nums[0], second = Integer.MAX_VALUE;
    for (int i = 1; i < n; i++) {
      int num = nums[i];
      if (num > second) {
        return true;
      } else if (num > first) {
        second = num;
      } else {
        first = num;
      }
    }
    return false;
  }
}
