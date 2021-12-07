package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tuchuantao on 2021/12/7
 * Desc: 三数之和
 */
public class Num15 {
  /**
   * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
   * 注意：答案中不可以包含重复的三元组。
   *
   * 示例 1：
   * 输入：nums = [-1,0,1,2,-1,-4]
   * 输出：[[-1,-1,2],[-1,0,1]]
   *
   * 示例 2：
   * 输入：nums = []
   * 输出：[]
   *
   * 示例 3：
   * 输入：nums = [0]
   * 输出：[]
   *
   * 提示：
   * 0 <= nums.length <= 3000
   * -10^5 <= nums[i] <= 10^5
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/3sum
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<List<Integer>> threeSum(int[] nums) { // 循环 + 双指针
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList();
    int length = nums.length;
    for(int i = 0; i < length - 2; i++) {
      if(i == 0 || nums[i] != nums[i - 1]) { // 避免重复
        int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];

        while (l < r) {
          if (nums[l] + nums[r] == sum) {
            result.add(Arrays.asList(nums[i], nums[l], nums[r]));
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
    return result;
  }
}
