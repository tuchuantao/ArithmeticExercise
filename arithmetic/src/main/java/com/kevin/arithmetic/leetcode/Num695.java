package com.kevin.arithmetic.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tuchuantao on 2021/9/18
 * Desc:
 */
public class Num695 {
  /**
   * 给定一个由0 和 1 组成的非空二维数组grid，用来表示海洋岛屿地图。
   * 一个岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
   * 找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
   *
   * 示例 1:
   * 输入: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,
   * 0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,
   * 0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
   * 输出: 6
   * 解释: 对于上面这个给定矩阵应返回6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
   *
   * 示例 2:
   * 输入: grid = [[0,0,0,0,0,0,0,0]]
   * 输出: 0
   *
   * 提示：
   * m == grid.length
   * n == grid[i].length
   * 1 <= m, n <= 50
   * grid[i][j] is either 0 or 1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/ZL6zAn
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int maxAreaOfIsland(int[][] grid) {
    int row = grid.length;
    int col = grid[0].length;
    int maxArea = 0;
    int tempArea = 0;
    Queue<int[]> points = new LinkedList();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        points.clear();
        tempArea = 0;
        if (grid[i][j] == 1) {
          points.add(new int[]{i, j});
          while (!points.isEmpty()) {
            int[] poi = points.remove();
            if (grid[poi[0]][poi[1]] == 1) {
              tempArea++;
              grid[poi[0]][poi[1]] = 0;
              if (poi[0] - 1 >= 0) {
                points.add(new int[]{poi[0] - 1, poi[1]});
              }
              if (poi[0] + 1 < row) {
                points.add(new int[]{poi[0] + 1, poi[1]});
              }
              if (poi[1] - 1 >= 0) {
                points.add(new int[]{poi[0], poi[1] - 1});
              }
              if (poi[1] + 1 < col) {
                points.add(new int[]{poi[0], poi[1] + 1});
              }
            }
          }
        }
        maxArea = Math.max(maxArea, tempArea);
      }
    }
    return maxArea;
  }
}
