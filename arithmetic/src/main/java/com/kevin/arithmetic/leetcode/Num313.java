package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/8/9
 * Desc:
 */
public class Num313 {
  /**
   * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
   * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
   * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
   *
   * 示例 1：
   * 输入：n = 12, primes = [2,7,13,19]
   * 输出：32 
   * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
   *
   * 示例 2：
   * 输入：n = 1, primes = [2,3,5]
   * 输出：1
   * 解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
   * 
   * 提示：
   * 1 <= n <= 10^6
   * 1 <= primes.length <= 100
   * 2 <= primes[i] <= 1000
   * 题目数据 保证 primes[i] 是一个质数
   * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/super-ugly-number
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int nthSuperUglyNumber(int n, int[] primes) { // 动态规划
    int[] dp = new int[n + 1];
    dp[1] = 1;
    int len = primes.length;
    int[] pointers = new int[len];
    Arrays.fill(pointers, 1);
    for (int i = 2; i <= n; i++) {
      int[] nums = new int[len];
      int minNum = Integer.MAX_VALUE;
      for (int j = 0; j < len; j++) {
        nums[j] = dp[pointers[j]] * primes[j];
        minNum = Math.min(minNum, nums[j]);
      }
      dp[i] = minNum;
      for (int j = 0; j < len; j++) {
        if (minNum == nums[j]) {
          pointers[j]++;
        }
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int result = new Num313().nthSuperUglyNumber(12, new int[]{2,7,13,19});
    System.out.println("result=" + result);
  }
}
