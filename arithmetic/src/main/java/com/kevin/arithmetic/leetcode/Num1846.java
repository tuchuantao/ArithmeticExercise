package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/7/15
 * Desc:
 */
public class Num1846 {

  /**
   * 给你一个正整数数组arr。请你对 arr执行一些操作（也可以不进行任何操作），使得数组满足以下条件：
   *
   * arr中 第一个元素必须为1。
   * 任意相邻两个元素的差的绝对值 小于等于1，也就是说，对于任意的 1 <= i < arr.length（数组下标从 0 开始），都满足abs(arr[i] - arr[i - 
   * 1]) <= 1。abs(x)为x的绝对值。
   * 你可以执行以下 2 种操作任意次：
   *
   * 减小 arr中任意元素的值，使其变为一个 更小的正整数。
   * 重新排列arr中的元素，你可以以任意顺序重新排列。
   * 请你返回执行以上操作后，在满足前文所述的条件下，arr中可能的 最大值。
   *
   * 
   *
   * 示例 1：
   *
   * 输入：arr = [2,2,1,2,1]
   * 输出：2
   * 解释：
   * 我们可以重新排列 arr 得到 [1,2,2,2,1] ，该数组满足所有条件。
   * arr 中最大元素为 2 。
   * 示例 2：
   *
   * 输入：arr = [100,1,1000]
   * 输出：3
   * 解释：
   * 一个可行的方案如下：
   * 1. 重新排列 arr 得到 [1,100,1000] 。
   * 2. 将第二个元素减小为 2 。
   * 3. 将第三个元素减小为 3 。
   * 现在 arr = [1,2,3] ，满足所有条件。
   * arr 中最大元素为 3 。
   * 示例 3：
   *
   * 输入：arr = [1,2,3,4,5]
   * 输出：5
   * 解释：数组已经满足所有条件，最大元素为 5 。
   * 
   *
   * 提示：
   *
   * 1 <= arr.length <= 10^5
   * 1 <= arr[i] <= 10^9
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
    Arrays.sort(arr);
    arr[0] = 1;
    int len = arr.length;
    for (int i = 1; i < len; i++) {
      if (Math.abs(arr[i] - arr[i - 1]) > 1) {
        arr[i] = arr[i - 1] + 1;
      }
    }
    return arr[len - 1];
  }
}
