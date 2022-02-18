package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2022/2/17
 * Desc: 骑士在棋盘上的概率
 */
public class Num688 {
  /**
   * 在一个n x n的国际象棋棋盘上，一个骑士从单元格 (row, column)开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) 
   * ，右下单元格是 (n - 1, n - 1) 。
   * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
   * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
   * 骑士继续移动，直到它走了 k 步或离开了棋盘。
   * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
   *
   * 示例 1：
   * 输入: n = 3, k = 2, row = 0, column = 0
   * 输出: 0.0625
   * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
   * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
   * 骑士留在棋盘上的总概率是0.0625。
   *
   * 示例 2：
   * 输入: n = 1, k = 0, row = 0, column = 0
   * 输出: 1.00000
   *
   * 提示:
   * 1 <= n <= 25
   * 0 <= k <= 100
   * 0 <= row, column <= n
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/knight-probability-in-chessboard
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public double knightProbability1(int n, int k, int row, int column) { // 暴力递归 & 超时
    double count = realKnightProbability(n, k, row, column);
    return count / Math.pow(8, k);
  }

  public double realKnightProbability(int n, int k, int row, int column) {
    if (row < 0 || row >= n || column < 0 || column >= n) {
      return 0;
    }
    if (k == 0) {
      return 1;
    }

    double res = 0;
    res += realKnightProbability(n, k - 1, row - 2, column - 1);
    res += realKnightProbability(n, k - 1, row - 2, column + 1);
    res += realKnightProbability(n, k - 1, row - 1, column - 2);
    res += realKnightProbability(n, k - 1, row - 1, column + 2);
    res += realKnightProbability(n, k - 1, row + 1, column - 2);
    res += realKnightProbability(n, k - 1, row + 1, column + 2);
    res += realKnightProbability(n, k - 1, row + 2, column - 1);
    res += realKnightProbability(n, k - 1, row + 2, column + 1);

    return res;
  }

  static int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

  public double knightProbability(int n, int k, int row, int column) { // 动态规划
    double[][][] dp = new double[k + 1][n][n];
    for (int step = 0; step <= k; step++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (step == 0) {
            dp[step][i][j] = 1;
          } else {
            for (int[] dir : dirs) {
              int ni = i + dir[0], nj = j + dir[1];
              if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                dp[step][i][j] += dp[step - 1][ni][nj] / 8;
              }
            }
          }
        }
      }
    }
    return dp[k][row][column];
  }

  public static void main(String[] args) {
    double res = new Num688().knightProbability(8, 20, 6, 4);
    System.out.println("res=" + res);
  }

}
