package com.kevin.arithmetic.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by tuchuantao on 2021/10/27
 * Desc: 下一个更大元素 II
 */
public class Num503 {
  /**
   * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x
   * 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
   *
   * 示例 1:
   *
   * 输入: [1,2,1]
   * 输出: [2,-1,2]
   * 解释: 第一个 1 的下一个更大的数是 2；
   * 数字 2 找不到下一个更大的数；
   * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
   * 注意: 输入数组的长度不会超过 10000。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] nextGreaterElements(int[] nums) { // 单调栈 & 两次遍历
    int len = nums.length;
    int[] resArr = new int[len];
    Arrays.fill(resArr, -1);
    Deque<Integer> stack = new LinkedList();
    for (int i = 0; i < len * 2; i++) {
      int index = i % len;
      while (true) {
        if (stack.isEmpty()) {
          stack.addLast(index);
          break;
        }
        if (nums[stack.getLast()] >= nums[index]) {
          stack.addLast(index);
          break;
        } else {
          if (resArr[stack.getLast()] == -1) {
            resArr[stack.removeLast()] = nums[index];
          } else {
            stack.removeLast();
          }
        }
      }
//
//      while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
//        resArr[stack.pop()] = nums[index];
//      }
//      stack.push(index);
    }
    return resArr;
  }
}
