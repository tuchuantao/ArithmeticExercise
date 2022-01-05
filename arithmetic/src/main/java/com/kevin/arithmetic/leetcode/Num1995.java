package com.kevin.arithmetic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/12/29
 * Desc: 统计特殊四元组
 */
public class Num1995 {
  /**
   * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
   * nums[a] + nums[b] + nums[c] == nums[d] ，且
   * a < b < c < d
   *
   * 示例 1：
   * 输入：nums = [1,2,3,6]
   * 输出：1
   * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
   *
   * 示例 2：
   * 输入：nums = [3,3,6,4,5]
   * 输出：0
   * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
   *
   * 示例 3：
   * 输入：nums = [1,1,1,3,5]
   * 输出：4
   * 解释：满足要求的 4 个四元组如下：
   * - (0, 1, 2, 3): 1 + 1 + 1 == 3
   * - (0, 1, 3, 4): 1 + 1 + 3 == 5
   * - (0, 2, 3, 4): 1 + 1 + 3 == 5
   * - (1, 2, 3, 4): 1 + 1 + 3 == 5
   *
   * 提示：
   * 4 <= nums.length <= 50
   * 1 <= nums[i] <= 100
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/count-special-quadruplets
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int countQuadruplets(int[] nums) { // 暴力枚举
    int len = nums.length;
    int count = 0;
    for (int i = 3; i < len; i++) {
      for (int j = 0; j < i - 2; j++) {
        for (int k = j + 1; k < i - 1; k++) {
          for (int l = k + 1; l < i; l++) {
            if (nums[i] == nums[j] + nums[k] + nums[l]) {
              count++;
            }
          }
        }
      }
    }
    return count;
  }

  // nums[a]+nums[b]=nums[d]−nums[c]
  public int countQuadruplets2(int[] nums) {
    int n = nums.length;
    int ans = 0;
    Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
    for (int b = n - 3; b >= 1; --b) {
      for (int d = b + 2; d < n; ++d) {
        cnt.put(nums[d] - nums[b + 1], cnt.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
      }
      for (int a = 0; a < b; ++a) {
        ans += cnt.getOrDefault(nums[a] + nums[b], 0);
      }
    }
    return ans;
  }

  // nums[a]+nums[b]+nums[c]=nums[d]
  public int countQuadruplets3(int[] nums) {
    int n = nums.length;
    int ans = 0;
    Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
    for (int c = n - 2; c >= 2; --c) {
      cnt.put(nums[c + 1], cnt.getOrDefault(nums[c + 1], 0) + 1);
      for (int a = 0; a < c; ++a) {
        for (int b = a + 1; b < c; ++b) {
          ans += cnt.getOrDefault(nums[a] + nums[b] + nums[c], 0);
        }
      }
    }
    return ans;
  }

//  public int countQuadruplets(int[] nums) {
//    Arrays.sort(nums);
//    int len = nums.length;
//    int count = 0;
//    for (int i = 3; i < len; i++) {
//      count += findTargetSum(nums, i - 1, nums[i]);
//    }
//    return count;
//  }
//
//  public int findTargetSum(int[] nums, int end, int target) {
//    int count = 0;
//    for (int i = 0; i < end - 1; i++) {
//      int left = i + 1;
//      int right = end;
//      while (left < right) {
//        if (nums[left] + nums[right] == target - nums[i]) {
//          count++;
//          System.out.println(nums[i] + " + " + nums[left] + " + " + nums[right] + "  = " + target);
//          if (nums[left + 1] == nums[left]) {
//            left++;
//          } else {
//            right--;
//          }
//        } else if (nums[left] + nums[right] < target - nums[i]) {
//          left++;
//        } else {
//          right--;
//        }
//      }
//    }
//    return count;
//  }
}
