package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/18
 * Desc:
 */
public class Offer47 {
  /**
   * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
   * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
   * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
   *
   * 示例 1:
   * 输入:
   * [
   *  [1,3,1],
   *  [1,5,1],
   *  [4,2,1]
   * ]
   * 输出: 12
   * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
   * 
   * 提示：
   * 0 < grid.length <= 200
   * 0 < grid[0].length <= 200
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int maxValue11(int[][] grid) {
    return findMax(grid, 0, 0, grid[0][0]);
  }

  public int findMax(int[][] grid, int raw, int col, int preCount) { // 暴力递归，超时
    int count = preCount;
    if (col < grid[0].length - 1) {
      count = findMax(grid, raw, col + 1, preCount + grid[raw][col + 1]);
    }
    if (raw < grid.length - 1) {
      count = Math.max(count, findMax(grid, raw + 1, col, preCount + grid[raw + 1][col]));
    }
    return count;
  }

  public int maxValue(int[][] grid) { // 动态规划
    int raw = grid.length;
    int col = grid[0].length;
    for (int i = 1; i < col; i++) {
      grid[0][i] += grid[0][i - 1];
    }
    for (int i = 1; i < raw; i++) {
      grid[i][0] += grid[i - 1][0];
    }
    for (int i = 1; i < raw; i++) {
      for (int j = 1; j < col; j++) {
        grid[i][j] = grid[i][j] + Math.max(grid[i - 1][j], grid[i][j - 1]);
      }
    }
    return grid[raw - 1][col - 1];
  }
}
