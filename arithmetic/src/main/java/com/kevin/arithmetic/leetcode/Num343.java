package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/18
 * Desc:
 */
public class Num343 {
  /**
   * 给定一个正整数n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
   *
   * 示例 1:
   * 输入: 2
   * 输出: 1
   * 解释: 2 = 1 + 1, 1 × 1 = 1。
   *
   * 示例2:
   * 输入: 10
   * 输出: 36
   * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36。
   * 说明: 你可以假设n不小于 2 且不大于 58。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/integer-break
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int integerBreak1(int n) {
    if (n == 2) {
      return 1;
    } else if (n == 3) {
      return 2;
    }
    int result = 1;
    int len = n;
    for (int i = 0; i < n; i++) {
      if (len <= 4) {
        result *= len;
        break;
      } else {
        len -= 3;
        result *= 3;
      }
    }
    return result;
  }

  public int integerBreak(int n) { // 动态规划
    int[] dp = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      int curMax = 0;
      for (int j = 1; j < i; j++) {
        curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
      }
      dp[i] = curMax;
    }
    return dp[n];
  }

  public int integerBreak2(int n) { // 动态规划优化
    if (n < 4) {
      return n - 1;
    }
    int[] dp = new int[n + 1];
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
      dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
    }
    return dp[n];
  }


  public int cuttingRope(int n) {
    if(n <= 3) return n - 1;
    int b = n % 3, p = 1000000007;
    long rem = 1, x = 3;
    for(int a = n / 3 - 1; a > 0; a /= 2) {
      if(a % 2 == 1) rem = (rem * x) % p;
      x = (x * x) % p;
    }
    if(b == 0) return (int)(rem * 3 % p);
    if(b == 1) return (int)(rem * 4 % p);
    return (int)(rem * 6 % p);
  }
}
