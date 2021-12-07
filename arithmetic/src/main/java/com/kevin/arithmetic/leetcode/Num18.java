package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tuchuantao on 2021/12/7
 * Desc: 四数之和
 */
public class Num18 {
  /**
   * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], 
   * nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
   * 0 <= a, b, c, d< n
   * a、b、c 和 d 互不相同
   * nums[a] + nums[b] + nums[c] + nums[d] == target
   * 你可以按 任意顺序 返回答案 。
   *
   * 示例 1：
   * 输入：nums = [1,0,-1,0,-2,2], target = 0
   * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
   *
   * 示例 2：
   * 输入：nums = [2,2,2,2,2], target = 8
   * 输出：[[2,2,2,2]]
   *
   * 提示：
   * 1 <= nums.length <= 200
   * -10^9 <= nums[i] <= 10^9
   * -10^9 <= target <= 10^9
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/4sum
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList();
    int length = nums.length;
    for (int i = 0; i < length - 3; i++) {
      if (i == 0 || nums[i] != nums[i - 1]) { // 避免重复
        for (int j = i + 1; j < length - 2; j++) {
          if (j == i + 1 || nums[j] != nums[j - 1]) {
            int l = j + 1, r = nums.length - 1, sum = target - nums[i] - nums[j];
            while (l < r) {
              if (nums[l] + nums[r] == sum) {
                result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                while (l < r && nums[l] == nums[l + 1]) l++;
                while (l < r && nums[r] == nums[r - 1]) r--;
                l++;
                r--;
              } else if (nums[l] + nums[r] < sum) {
                while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                l++;
              } else {
                while (l < r && nums[r] == nums[r - 1]) r--;
                r--;
              }
            }
          }
        }
      }
    }
    return result;
  }
}
