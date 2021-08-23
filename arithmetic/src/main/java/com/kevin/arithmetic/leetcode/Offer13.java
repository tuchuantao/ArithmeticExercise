package com.kevin.arithmetic.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tuchuantao on 2021/8/23
 * Desc:
 */
public class Offer13 {
  /**
   * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0]
   * 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37]，
   * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
   *
   * 示例 1：
   * 输入：m = 2, n = 3, k = 1
   * 输出：3
   *
   * 示例 2：
   * 输入：m = 3, n = 1, k = 0
   * 输出：1
   *
   * 提示：
   * 1 <= n,m <= 100
   * 0 <= k<= 20
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int movingCount(int m, int n, int k) {
    if (k == 0) {
      return 1;
    }
    Queue<int[]> queue = new LinkedList<int[]>();
    // 向右和向下的方向数组
    int[] dx = {0, 1};
    int[] dy = {1, 0};
    boolean[][] vis = new boolean[m][n];
    queue.offer(new int[]{0, 0});
    vis[0][0] = true;
    int ans = 1;
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int x = cell[0], y = cell[1];
      for (int i = 0; i < 2; ++i) {
        int tx = dx[i] + x;
        int ty = dy[i] + y;
        if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
          continue;
        }
        queue.offer(new int[]{tx, ty});
        vis[tx][ty] = true;
        ans++;
      }
    }
    return ans;
  }

  private int get(int x) {
    int res = 0;
    while (x != 0) {
      res += x % 10;
      x /= 10;
    }
    return res;
  }
}
