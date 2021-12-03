package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/12/3
 * Desc: K 次取反后最大化的数组和
 */
public class Num1005 {
  /**
   * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
   * 选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
   * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
   * 以这种方式修改数组后，返回数组 可能的最大和 。
   *
   * 示例 1：
   * 输入：nums = [4,2,3], k = 1
   * 输出：5
   * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
   *
   * 示例 2：
   * 输入：nums = [3,-1,0,2], k = 3
   * 输出：6
   * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
   *
   * 示例 3：
   * 输入：nums = [2,-3,-1,5,-4], k = 2
   * 输出：13
   * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
   *
   * 提示：
   * 1 <= nums.length <= 10^4
   * -100 <= nums[i] <= 100
   * 1 <= k <= 10^4
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int largestSumAfterKNegations1(int[] nums, int k) {
    int len = nums.length;
    if (len == 1) {
      return k % 2 == 0 ? nums[0] : -nums[0];
    }
    Arrays.sort(nums);
    while (k > 0) {
      nums[0] = -nums[0];
      Arrays.sort(nums);
      k--;
    }
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    return sum;
  }

  public int largestSumAfterKNegations(int[] nums, int k) {
    int len = nums.length;
    if (len == 1) {
      return k % 2 == 0 ? nums[0] : -nums[0];
    }
    Arrays.sort(nums);
    ArrayList<Integer> list = new ArrayList();
    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += nums[i];
      list.add(nums[i]);
    }
    while (k > 0) {
      int num = list.remove(0);
      insert(list, -num);
      sum = sum - num + (-num);
      k--;
    }
    return sum;
  }

  private void insert(ArrayList<Integer> list, int num) {
    int left = 0;
    int right = list.size() - 1;
    int center;
    while (left < right) {
      center = left + ((right - left) >> 1);
      if (list.get(center) == num) {
        list.add(center, num);
        return;
      } else if (list.get(center) > num) {
        right = center - 1;
      } else {
        left = center + 1;
      }
    }
    if (list.get(left) > num) {
      list.add(left, num);
    } else {
      list.add(left + 1, num);
    }
  }

}
