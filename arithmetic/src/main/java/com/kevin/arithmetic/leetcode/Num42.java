package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/10/14
 * Desc: 接雨水
 */
public class Num42 {
  /**
   * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
   *
   * 示例 1：
   * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
   * 输出：6
   * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
   *
   * 示例 2：
   * 输入：height = [4,2,0,3,2,5]
   * 输出：9
   *
   * 提示：
   *
   * n == height.length
   * 1 <= n <= 2 * 10^4
   * 0 <= height[i] <= 10^5
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/trapping-rain-water
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int trap1(int[] height) {
    int len = height.length;
    if (len < 3) {
      return 0;
    }
    int[] leftMax = new int[len];
    int[] rightMax = new int[len];
    leftMax[0] = height[0];
    for (int i = 1; i < len; i++) {
        leftMax[i] = Math.max(height[i], leftMax[i - 1]);
    }
    rightMax[len - 1] = height[len - 1];
    for (int i = len - 2; i >= 0; i--) {
      rightMax[i] = Math.max(height[i], rightMax[i + 1]);
    }
    int count = 0;
    for (int i = 1; i < len - 1; i++) {
      count += Math.min(leftMax[i], rightMax[i]) - height[i];
    }
    return count;
  }

  public int trap(int[] height) { // 双指针
    int left = 0, right = height.length - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= left_max) {
          left_max = height[left];
        } else {
          ans += (left_max - height[left]);
        }
        ++left;
      } else {
        if (height[right] >= right_max) {
          right_max = height[right];
        } else {
          ans += (right_max - height[right]);
        }
        --right;
      }
    }
    return ans;
  }
}
