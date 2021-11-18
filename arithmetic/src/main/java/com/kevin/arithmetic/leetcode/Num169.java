package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/18
 * Desc: 多数元素
 */
public class Num169 {
  /**
   * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
   * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
   *
   * 示例1：
   * 输入：[3,2,3]
   * 输出：3
   *
   * 示例2：
   * 输入：[2,2,1,1,1,2,2]
   * 输出：2
   *
   * 进阶：
   * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/majority-element
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int majorityElement(int[] nums) {
    int lastCount = 0;
    int lastNum = 0;
    int len = nums.length;
    for (int i = 0; i < len;) {
      if (i + 1 < len) {
        if (nums[i] == nums[i + 1]) {
          if (lastCount == 0) {
            lastCount = 2;
            lastNum = nums[i];
          } else if (lastNum == nums[i]) {
            lastCount += 2;
          } else {
            lastCount -= 2;
          }
        }
        i = i + 2;
      } else {
        if (lastCount == 0) {
          return nums[i];
        } else {
          return lastNum;
        }
      }
    }
    return lastNum;
  }
}
