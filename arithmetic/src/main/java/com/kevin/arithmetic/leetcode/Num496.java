package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by tuchuantao on 2021/10/26
 * Desc: 下一个更大的数 I
 */
public class Num496 {
  /**
   * 给你两个 没有重复元素 的数组nums1 和nums2，其中nums1是nums2的子集。
   * 请你找出 nums1中每个元素在nums2中的下一个比其大的值。
   * nums1中数字x的下一个更大元素是指x在nums2中对应位置的右边的第一个比x大的元素。如果不存在，对应位置输出 -1 。
   *
   * 示例 1:
   * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
   * 输出: [-1,3,-1]
   * 解释:
   *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
   *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
   *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
   *
   * 示例 2:
   * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
   * 输出: [3,-1]
   * 解释:
   *    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
   *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
   *
   * 提示：
   * 1 <= nums1.length <= nums2.length <= 1000
   * 0 <= nums1[i], nums2[i] <= 10^4
   * nums1和nums2中所有整数 互不相同
   * nums1 中的所有整数同样出现在 nums2 中
   *
   * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/next-greater-element-i
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] nextGreaterElement1(int[] nums1, int[] nums2) { // 暴力
    int len1 = nums1.length;
    int len2 = nums2.length;
    int[] arr = new int[len1];
    for (int i = 0; i < len1; i++) {
      arr[i] = -1;
      boolean find = false;
      for (int j = 0; j < len2; j++) {
        if (find) {
          if (nums1[i] < nums2[j]) {
            arr[i] = nums2[j];
            break;
          }
        } else {
          find = nums1[i] == nums2[j];
        }
      }
    }
    return arr;
  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) { // HashMap + 单调栈
    int len2 = nums2.length;
    HashMap<Integer, Integer> map = new HashMap();
    Deque<Integer> deque = new LinkedList();
    for (int i = 0; i < len2; i++) {
      while (true) {
        if (deque.isEmpty()) {
          deque.addLast(nums2[i]);
          break;
        }
        if (deque.getLast() > nums2[i]) {
          deque.addLast(nums2[i]);
          break;
        } else {
          map.put(deque.removeLast(), nums2[i]);
        }
      }
    }

    int len1 = nums1.length;
    int[] resArr = new int[len1];
    for (int i = 0; i < len1; i++) {
      resArr[i] = map.getOrDefault(nums1[i], -1);
    }
    return resArr;
  }
}
