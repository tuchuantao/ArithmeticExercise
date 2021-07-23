package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/2
 * Desc:
 */
public class Num815 {

  /**
   * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
   *
   * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
   * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
   *
   * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
   *
   *  
   *
   * 示例 1：
   *
   * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
   * 输出：2
   * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
   * 示例 2：
   *
   * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
   * 输出：-1
   *  
   *
   * 提示：
   *
   * 1 <= routes.length <= 500.
   * 1 <= routes[i].length <= 105
   * routes[i] 中的所有值 互不相同
   * sum(routes[i].length) <= 105
   * 0 <= routes[i][j] < 106
   * 0 <= source, target < 106
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/bus-routes
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
//  public int numBusesToDestination(int[][] routes, int source, int target) {
//
//  }
}