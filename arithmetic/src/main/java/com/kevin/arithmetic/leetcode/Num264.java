package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/8/9
 * Desc: 丑数 II
 */
public class Num264 {
  /**
   * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
   * 丑数 就是只包含质因数2、3 和/或5的正整数。
   *
   * 示例 1：
   * 输入：n = 10
   * 输出：12
   * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
   *
   * 示例 2：
   * 输入：n = 1
   * 输出：1
   * 解释：1 通常被视为丑数。
   *
   * 提示：
   * 1 <= n <= 1690
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/ugly-number-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int nthUglyNumber(int n) {
    int[] factors = {2, 3, 5};
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int[] points = new int[3];
    Arrays.fill(points, 1);
    for (int i = 2; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      int[] nums = new int[3];
      for (int j = 0; j < 3; j++) {
        nums[j] = dp[points[j]] * factors[j];
        min = Math.min(min, nums[j]);
      }
      dp[i] = min;
      for (int j = 0; j < 3; j++) {
        if (nums[j] == min) {
          points[j]++;
        }
      }
    }
    return dp[n];
  }

  public int nthUglyNumber22(int n) { // 官方题解，用于对比
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int p2 = 1, p3 = 1, p5 = 1;
    for (int i = 2; i <= n; i++) {
      int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
      dp[i] = Math.min(Math.min(num2, num3), num5);
      if (dp[i] == num2) {
        p2++;
      }
      if (dp[i] == num3) {
        p3++;
      }
      if (dp[i] == num5) {
        p5++;
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int result = new Num264().nthUglyNumber(10);
    System.out.println("result=" + result);
  }
}
