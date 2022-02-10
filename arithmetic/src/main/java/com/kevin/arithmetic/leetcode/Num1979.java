package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2022/2/10
 * Desc: 找出数组的最大公约数
 */
public class Num1979 {
  /**
   * 给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
   * 两个数的最大公约数 是能够被两个数整除的最大正整数。
   *
   * 示例 1：
   * 输入：nums = [2,5,6,9,10]
   * 输出：2
   * 解释：
   * nums 中最小的数是 2
   * nums 中最大的数是 10
   * 2 和 10 的最大公约数是 2
   *
   * 示例 2：
   * 输入：nums = [7,5,6,8,3]
   * 输出：1
   * 解释：
   * nums 中最小的数是 3
   * nums 中最大的数是 8
   * 3 和 8 的最大公约数是 1
   *
   * 示例 3：
   * 输入：nums = [3,3]
   * 输出：3
   * 解释：
   * nums 中最小的数是 3
   * nums 中最大的数是 3
   * 3 和 3 的最大公约数是 3
   *
   * 提示：
   * 2 <= nums.length <= 1000
   * 1 <= nums[i] <= 1000
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/find-greatest-common-divisor-of-array
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findGCD(int[] nums) {
    Arrays.sort(nums);
    return gcd(nums[0], nums[nums.length - 1]);
  }

  public int gcd(int a, int b) {
    return b != 0 ? gcd(b, a % b) : a;
  }
}
