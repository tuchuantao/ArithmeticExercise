package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/9/13
 * Desc:
 */
public class Num447 {
  /**
   * 给定平面上n 对 互不相同 的点points ，其中 points[i] = [xi, yi] 。回旋镖 是由点(i, j, k) 表示的元组，
   * 其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
   * 返回平面上所有回旋镖的数量。
   *
   * 示例 1：
   * 输入：points = [[0,0],[1,0],[2,0]]
   * 输出：2
   * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
   *
   * 示例 2：
   * 输入：points = [[1,1],[2,2],[3,3]]
   * 输出：2
   *
   * 示例 3：
   * 输入：points = [[1,1]]
   * 输出：0
   * 
   * 提示：
   * n == points.length
   * 1 <= n <= 500
   * points[i].length == 2
   * -10^4 <= xi, yi <= 10^4
   * 所有点都 互不相同
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/number-of-boomerangs
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int numberOfBoomerangs(int[][] points) {
    int len = points.length;
    if (len < 3) {
      return 0;
    }
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap();
    for (int i = 0; i < len; i++) {
      map.clear();
      for (int j = 0; j < len; j++) {
        int key = (points[j][0] - points[i][0]) * (points[j][0] - points[i][0]) + (points[j][1] - points[i][1]) * (points[j][1] - points[i][1]);
        int value = map.getOrDefault(key, 0);
        map.put(key, ++value);
      }
      Iterator<Integer> iterator = map.values().iterator();
      while (iterator.hasNext()) {
        int value = iterator.next();
        sum += value * (value - 1);
      }
    }
    return sum;
  }

  public int numberOfBoomerangs11(int[][] points) {
    int ans = 0;
    for (int[] p : points) {
      Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
      for (int[] q : points) {
        int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
        cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
      }
      for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
        int m = entry.getValue();
        ans += m * (m - 1);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int result = new Num447().numberOfBoomerangs(new int[][]{{0,0}, {1, 0},{2,0}});
    System.out.println("result="+ result);
  }
}
