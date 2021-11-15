package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by tuchuantao on 2021/11/15
 * Desc: 跳跃游戏II
 */
public class Num45 {
  /**
   * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
   * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
   * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
   * 假设你总是可以到达数组的最后一个位置。
   *
   * 示例 1:
   * 输入: nums = [2,3,1,1,4]
   * 输出: 2
   * 解释: 跳到最后一个位置的最小跳跃数是 2。
   *     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
   *
   * 示例 2:
   * 输入: nums = [2,3,0,1,4]
   * 输出: 2
   *
   * 提示:
   * 1 <= nums.length <= 10^4
   * 0 <= nums[i] <= 1000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/jump-game-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int jump(int[] nums) {
    int len = nums.length;
    if (len <= 1) {
      return 0;
    }
    Deque<int[]> stack = new LinkedList();
    stack.addLast(new int[]{0, 0});
    int[] stepArr = new int[len];
    stepArr[0] = 0;
    while (!stack.isEmpty()) {
      int[] arr = stack.removeFirst();
      if (arr[0] == len - 1 || arr[0] + nums[arr[0]] >= len - 1) {
        if (stepArr[len - 1] == 0) {
          stepArr[len - 1] = arr[1] + 1;
        } else {
          stepArr[len - 1] = Math.min(stepArr[len - 1], arr[1] + 1);
        }
        continue;
      }
      for (int i = arr[0] + 1; i <= arr[0] + nums[arr[0]]; i++) {
        if (stepArr[i] == 0 || arr[1] + 1 < stepArr[i]) {
          stack.addLast(new int[]{i, arr[1] + 1});
          stepArr[i] = arr[1] + 1;
        }
      }
    }
    return stepArr[len - 1];
  }

  public int jump1(int[] nums) { // 贪心
    int length = nums.length;
    int end = 0;
    int maxPosition = 0;
    int steps = 0;
    for (int i = 0; i < length - 1; i++) {
      maxPosition = Math.max(maxPosition, i + nums[i]);
      if (i == end) {
        end = maxPosition;
        steps++;
      }
    }
    return steps;
  }
}
