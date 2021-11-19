package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/19
 * Desc: 整数替换
 */
public class Num397 {
  /**
   * 给定一个正整数n ，你可以做如下操作：
   * 如果n是偶数，则用n / 2替换n 。
   * 如果n是奇数，则可以用n + 1或n - 1替换n 。
   * n变为 1 所需的最小替换次数是多少？
   *
   * 示例 1：
   * 输入：n = 8
   * 输出：3
   * 解释：8 -> 4 -> 2 -> 1
   *
   * 示例 2：
   * 输入：n = 7
   * 输出：4
   * 解释：7 -> 8 -> 4 -> 2 -> 1
   * 或 7 -> 6 -> 3 -> 2 -> 1
   *
   * 示例 3：
   * 输入：n = 4
   * 输出：2
   *
   * 提示：
   * 1 <= n <= 2^31 - 1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/integer-replacement
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int integerReplacement1(int n) { // 动态规划 & 超出内存限制
    int[] dp = new int[n + 1];
    dp[1] = 0;
    for (int i = 2; i <= n; i++) {
      if (i % 2 == 0) {
        dp[i] = dp[i / 2] + 1;
      } else {
        dp[i] = Math.min(dp[(i + 1) / 2] + 2, dp[i - 1] + 1);
      }
    }
    return dp[n];
  }

  public int integerReplacement(int n) { // 递归
    if (n == 1) {
      return 0;
    }
    int step = 0;
    while (n % 2 == 0) { // 优化，避免调用栈溢出
      step++;
      n = n >> 1;
    }
    if (n == 1) {
      return step;
    }
    return Math.min(integerReplacement((n >> 1) + 1) + step + 2, integerReplacement(n - 1) + step + 1);
  }
}
