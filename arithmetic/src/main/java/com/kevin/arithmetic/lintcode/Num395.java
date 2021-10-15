package com.kevin.arithmetic.lintcode;

/**
 * Created by tuchuantao on 2021/10/15
 * Desc: 硬币排列成线
 */
public class Num395 {
  /**
   * 描述
   * 有 n 个不同价值的硬币排成一条线。两个参赛者轮流从 左边 依次拿走 1 或 2 个硬币，直到没有硬币为止。计算两个人分别拿到的硬币总价值，价值高的人获胜。
   * 请判定 先手玩家 必胜还是必败?
   * 若必胜, 返回 true, 否则返回 false.
   *
   * 样例
   * 样例 1:
   * 输入: [1, 2, 2]
   * 输出: true
   * 解释: 先手玩家直接拿走两颗硬币即可.
   *
   * 样例 2:
   * 输入: [1, 2, 4]
   * 输出: false
   * 解释: 无论先手拿一个还是两个, 后手可以拿完, 然后总价值更高.
   */
  public boolean firstWillWin(int[] values) {
    int len = values.length;
    if (len <= 2) {
      return true;
    }
    int[] dp = new int[len];
    dp[len - 1] = values[len - 1];
    dp[len - 2] = values[len - 1] + values[len - 2];
    dp[len - 3] = values[len - 2] + values[len - 3];
    int sum = values[len - 1] + values[len - 2] + values[len - 3];
    for (int i = len - 4; i >= 0; i--) {
      sum += values[i];
      dp[i] = Math.max(values[i] + Math.min(dp[i + 2], dp[i + 3]), // 拿一个，对手会拿一个或者两个中最大的
          values[i] + values[i + 1] + Math.min(dp[i + 3], i + 4 < len ? dp[i + 4] : 0)); // 拿两个
    }

    return sum - dp[0] < dp[0];
  }
}
