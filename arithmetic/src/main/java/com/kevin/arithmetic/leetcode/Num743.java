package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/8/2
 * Desc:
 */
public class Num743 {
  /**
   * 有 n 个网络节点，标记为1到 n。
   * 给你一个列表times，表示信号经过 有向 边的传递时间。times[i] = (ui, vi, wi)，其中ui是源节点，vi是目标节点，
   * wi是一个信号从源节点传递到目标节点的时间。
   * 现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。
   *
   * 示例 1：
   *        2
   *     /     \
   *    1       3
   *          /
   *         4
   *
   * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
   * 输出：2
   *
   * 示例 2：
   *
   * 输入：times = [[1,2,1]], n = 2, k = 1
   * 输出：1
   *
   * 示例 3：
   *
   * 输入：times = [[1,2,1]], n = 2, k = 2
   * 输出：-1
   * 
   *
   * 提示：
   *
   * 1 <= k <= n <= 100
   * 1 <= times.length <= 6000
   * times[i].length == 3
   * 1 <= ui, vi <= n
   * ui != vi
   * 0 <= wi <= 100
   * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/network-delay-time
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int networkDelayTime(int[][] times, int n, int k) {
    int len = times.length;
    if (len < n - 1) {
      return -1;
    }
    Map<Integer, ArrayList<TargetPoint>> map = new HashMap();
    for (int i = 0; i < len; i++) {
      ArrayList<TargetPoint> list = map.getOrDefault(times[i][0], new ArrayList());
      list.add(new TargetPoint(times[i][1], times[i][2]));
      map.put(times[i][0], list);
    }

    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE); // 全部填充 MAX_VALUE
    dist[k] = 0;

    Deque<Integer> stack = new LinkedList();
    stack.addLast(k);
    while (!stack.isEmpty()) {
      len = stack.size();
      for (int i = 0; i < len; i++) {
        int source = stack.removeFirst();
        ArrayList<TargetPoint> list = map.getOrDefault(source, new ArrayList());
        for (TargetPoint point : list) {
          if (dist[point.vi] > dist[source] + point.wi) {
            stack.addLast(point.vi);
            dist[point.vi] = dist[source] + point.wi;
          }
        }
      }
    }
    int result = Integer.MIN_VALUE;
    for (int i = 0; i <= n; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        return -1;
      }
      result = Math.max(result, dist[i]);
    }
//    Arrays.stream(dist).max().getAsInt();
    return result;
  }

  public class TargetPoint { // 如果不能使用辅助类，可以考虑使用二维数组（临接矩阵）保存距离
    int vi;
    int wi;

    public TargetPoint(int vi, int wi) {
      this.vi = vi;
      this.wi = wi;
    }
  }
}
