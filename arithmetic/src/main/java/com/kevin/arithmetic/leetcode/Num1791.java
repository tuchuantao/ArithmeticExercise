package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/6
 * Desc: 找出星型图的中心节点
 */
public class Num1791 {
  /**
   * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
   * 给你一个二维整数数组 edges ，其中edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回edges 所表示星型图的中心节点。
   *
   * 示例 1：
   * 输入：edges = [[1,2],[2,3],[4,2]]
   * 输出：2
   * 解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
   *
   * 示例 2：
   * 输入：edges = [[1,2],[5,1],[1,3],[1,4]]
   * 输出：1
   * 
   * 提示：
   *
   * 3 <= n <= 10^5
   * edges.length == n - 1
   * edges[i].length == 2
   * 1 <= ui, vi <= n
   * ui != vi
   * 题目数据给出的 edges 表示一个有效的星型图
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/find-center-of-star-graph
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findCenter11(int[][] edges) { // 入度
    int len = edges.length;
    int[] points = new int[len + 1];
    for (int i = 0; i < len; i++) {
      points[edges[i][0] - 1] += 1;
      points[edges[i][1] - 1] += 1;
    }
    for (int i = 0; i < len + 1; i++) {
      if (points[i] == len) {
        return i + 1;
      }
    }
    return -1;
  }
}
