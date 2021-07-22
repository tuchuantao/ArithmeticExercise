package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/7/19
 * Desc:
 */
public class Num1937 {

  /**
   * 给你一个m x n的整数矩阵points（下标从 0开始）。一开始你的得分为 0，你想最大化从矩阵中得到的分数。
   * 你的得分方式为：每一行中选取一个格子，选中坐标为(r, c)的格子会给你的总得分 增加points[r][c]。
   * 然而，相邻行之间被选中的格子如果隔得太远，你会失去一些得分。对于相邻行r 和r + 1（其中0 <= r < m - 1），选中坐标为(r, c1) 和(r + 1,
   * c2)的格子，你的总得分减少abs(c1 - c2)。
   *
   * 请你返回你能得到的 最大得分。
   *
   * abs(x)定义为：
   * 如果x >= 0，那么值为x。
   * 如果x <0，那么值为 -x。
   * 
   * 示例 1：
   * 1 2 3
   * 1 5 1
   * 3 1 1
   *
   * 输入：points = [[1,2,3],[1,5,1],[3,1,1]]
   * 输出：9
   * 解释：
   * 蓝色格子是最优方案选中的格子，坐标分别为 (0, 2)，(1, 1) 和 (2, 0) 。
   * 你的总得分增加 3 + 5 + 3 = 11 。
   * 但是你的总得分需要扣除 abs(2 - 1) + abs(1 - 0) = 2 。
   * 你的最终得分为 11 - 2 = 9 。
   *
   * 示例 2：
   * 1 5
   * 2 3
   * 4 2
   *
   * 输入：points = [[1,5],[2,3],[4,2]]
   * 输出：11
   * 解释：
   * 蓝色格子是最优方案选中的格子，坐标分别为 (0, 1)，(1, 1) 和 (2, 0) 。
   * 你的总得分增加 5 + 3 + 4 = 12 。
   * 但是你的总得分需要扣除 abs(1 - 1) + abs(1 - 0) = 1 。
   * 你的最终得分为 12 - 1 = 11 。
   *
   * 提示：
   *
   * m == points.length
   * n == points[r].length
   * 1 <= m, n <= 10^5
   * 1 <= m * n <= 10^5
   * 0 <= points[r][c] <= 10^5
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/maximum-number-of-points-with-cost
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public long maxPoints11(int[][] points) { // 超时 O(m * n^2)
    int raw = points.length;
    int col = points[0].length;

    long[] dp = new long[col];
    long[] tempDp;
    for (int i = 0; i < raw; i++) {
      tempDp = Arrays.copyOf(dp, col);
      for (int j = 0; j < col; j++) {
        if (i == 0) {
          dp[j] = points[i][j];
          continue;
        }
        long max = Integer.MIN_VALUE;
        for (int k = 0; k < col; k++) {
          max = Math.max(max, points[i][j] + tempDp[k] - Math.abs(j - k));
        }
        dp[j] = max;
      }
    }
    long result = Integer.MIN_VALUE;
    for (long num : dp) {
      result = Math.max(result, num);
    }
    return result;
  }

  public long maxPoints(int[][] points) { // O(mn)
    int raw = points.length;
    int col = points[0].length;

    long[] dp = new long[col];
    for (int i = 0; i < raw; i++) {
      long[] tempDp = new long[col];
      long max = Integer.MIN_VALUE;
      // 正序遍历
      for (int j = 0; j < col; j++) {
        max = Math.max(max, dp[j] + j);
        tempDp[j] = Math.max(tempDp[j], max + points[i][j] - j);
      }
      max = Integer.MIN_VALUE;
      // 倒序遍历
      for (int j = col - 1; j >= 0 ; j--) {
        max = Math.max(max, dp[j] - j);
        tempDp[j] = Math.max(tempDp[j], max + points[i][j] + j);
      }
      dp = Arrays.copyOf(tempDp, col);
    }
    long result = Integer.MIN_VALUE;
    for (long num : dp) {
      result = Math.max(result, num);
    }
    return result;
  }

  public static void main(String[] args) {
    long result = new Num1937().maxPoints(new int[][]{{0,3,0,4,2}, {5,4,2,4,1}, {5,0,0,5,1}, {2,0,1,0,3}});
    System.out.println("result=" + result);
  }
}
