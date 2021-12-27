package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/7/19
 * Desc: 最高频元素的频数
 */
public class Num1838 {

  /**
   * 元素的 频数 是该元素在一个数组中出现的次数。
   * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
   * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
   *
   * 示例 1：
   * 输入：nums = [1,2,4], k = 5
   * 输出：3
   * 解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
   * 4 是数组中最高频元素，频数是 3 。
   *
   * 示例 2：
   * 输入：nums = [1,4,8,13], k = 5
   * 输出：2
   * 解释：存在多种最优解决方案：
   * - 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
   * - 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
   * - 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
   *
   * 示例 3：
   * 输入：nums = [3,9,6], k = 2
   * 输出：1
   *
   * 提示：
   * 1 <= nums.length <= 10^5
   * 1 <= nums[i] <= 10^5
   * 1 <= k <= 10^5
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int maxFrequency11(int[] nums, int k) {
    Arrays.sort(nums);
    int n = nums.length;
    long total = 0;
    int l = 0, res = 1;
    for (int r = 1; r < n; ++r) {
      total += (long) (nums[r] - nums[r - 1]) * (r - l);
      while (total > k) {
        total -= nums[r] - nums[l];
        ++l;
      }
      res = Math.max(res, r - l + 1);
    }
    return res;
  }

  public int maxFrequency(int[] nums, int k) {
    Arrays.sort(nums);
    int maxCount = 0;
    int leftIndex = 0;
    int rightIndex = 0;
    int optionNum = k;
    while (rightIndex < nums.length) {
      while (optionNum < 0) {
        optionNum += nums[rightIndex] - nums[leftIndex];
        leftIndex++;
      }
      while (rightIndex < nums.length - 1) {
        optionNum -= (nums[rightIndex + 1] - nums[rightIndex]) * (rightIndex - leftIndex + 1);
        if(optionNum < 0) {
          break;
        }
        rightIndex++;
      }
      if (rightIndex - leftIndex + 1 > maxCount) {
        maxCount = rightIndex - leftIndex + 1;
      }
      rightIndex++;
    }
    return maxCount;
  }
}
