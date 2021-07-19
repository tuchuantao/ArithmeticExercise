package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/19
 * Desc:
 */
public class Num1937 {

  /**
   * 给你一个m x n的整数矩阵points（下标从 0开始）。一开始你的得分为 0，你想最大化从矩阵中得到的分数。
   *
   * 你的得分方式为：每一行中选取一个格子，选中坐标为(r, c)的格子会给你的总得分 增加points[r][c]。
   *
   * 然而，相邻行之间被选中的格子如果隔得太远，你会失去一些得分。对于相邻行r 和r + 1（其中0 <= r < m - 1），选中坐标为(r, c1) 和(r + 1,
   * c2)的格子，你的总得分减少abs(c1 - c2)。
   *
   * 请你返回你能得到的 最大得分。
   *
   * abs(x)定义为：
   *
   * 如果x >= 0，那么值为x。
   * 如果x <0，那么值为 -x。
   * 
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
   * 
   */
//  public long maxPoints(int[][] points) {
//    int row = points.length;
//    int col = points[0].length;
//
//    for (int i = 1; i < row; i++) {
//      for (int j = 0; j < col; j++) {
//
//      }
//    }
//  }
}
