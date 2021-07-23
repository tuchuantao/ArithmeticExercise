package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/23
 * Desc:
 */
public class Num238 {
  /**
   * 给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
   * <p>
   * 示例:
   * 输入: [1,2,3,4]
   * 输出: [24,12,8,6]
   * <p>
   * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
   * <p>
   * 说明: 请不要使用除法，且在O(n) 时间复杂度内完成此题。
   * <p>
   * 进阶：
   * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    if (len <= 1) {
      return nums;
    }
    int[] prefixArr = new int[len];
    prefixArr[0] = nums[0];
    int[] suffixArr = new int[len];
    suffixArr[len - 1] = nums[len - 1];
    for (int i = 1; i < len; i++) {
      prefixArr[i] = prefixArr[i - 1] * nums[i];
    }
    for (int i = len - 2; i >= 0; i--) {
      suffixArr[i] = suffixArr[i + 1] * nums[i];
    }
    nums[0] = suffixArr[1];
    nums[len - 1] = prefixArr[len - 2];
    for (int i = 1; i < len - 1; i++) {
      nums[i] = prefixArr[i - 1] * suffixArr[i + 1];
    }
    return nums;
  }
}
