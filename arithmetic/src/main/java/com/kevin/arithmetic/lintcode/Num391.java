package com.kevin.arithmetic.lintcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by tuchuantao on 2021/10/14
 * Desc: 数飞机
 */
public class Num391 {
  /**
   * 描述
   * 给出飞机的起飞和降落时间的列表，用序列 interval 表示. 请计算出天上同时最多有多少架飞机？
   * 如果多架飞机降落和起飞在同一时刻，我们认为降落有优先权。
   *
   * 样例
   * 样例 1:
   * 输入: [(1, 10), (2, 3), (5, 8), (4, 7)]
   * 输出: 3
   *
   * 解释:
   * 第一架飞机在1时刻起飞, 10时刻降落.
   * 第二架飞机在2时刻起飞, 3时刻降落.
   * 第三架飞机在5时刻起飞, 8时刻降落.
   * 第四架飞机在4时刻起飞, 7时刻降落.
   * 在5时刻到6时刻之间, 天空中有三架飞机.
   *
   * 样例 2:
   * 输入: [(1, 2), (2, 3), (3, 4)]
   * 输出: 1
   * 解释: 降落优先于起飞.
   */
//  public int countOfAirplanes1(List<Interval> airplanes) { // 前缀和
//    int size = airplanes.size();
//    if (size < 2) {
//      return size;
//    }
//    int[] count = new int[25]; // 大小有可能不是24小时
//    int mx = 0;
//    for (int i = 0; i < size; i++) {
//      count[(int) airplanes.get(i).getLowEndpoint()] += 1;
//      count[(int) airplanes.get(i).getHighEndpoint()] -= 1;
//      mx = Math.max(mx, (int) airplanes.get(i).getHighEndpoint());
//    }
//    int result = count[0];
//    for (int i = 1; i <= mx; i++) {
//      count[i] += count[i - 1];
//      result = Math.max(result, count[i]);
//    }
//    return result;
//  }

  public int countOfAirplanes(List<Interval> airplanes) { // 扫描线
    int size = airplanes.size();
    if (size < 2) {
      return size;
    }
    PriorityQueue<int[]> queue = new PriorityQueue(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1];
      }
    });
    for (int i = 0; i < size; i++) {
      queue.add(new int[] {airplanes.get(i).start, 1});
      queue.add(new int[] {airplanes.get(i).end, -1});
    }
    int ans = 0;
    int tmp = 0;
    size = queue.size();
    for(int i = 0; i < size; i++) {
      tmp += queue.poll()[1];
      ans = Math.max(ans, tmp);
    }
    return ans;
  }

  static class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static void main(String[] args) {
    List<Interval> list = new ArrayList();
    Interval interval1 = new Interval(1, 10);
    Interval interval2 = new Interval(2, 3);
    Interval interval3 = new Interval(5, 8);
    Interval interval4 = new Interval(4, 7);
    list.add(interval1);
    list.add(interval2);
    list.add(interval3);
    list.add(interval4);

    int result = new Num391().countOfAirplanes(list);
    System.out.println("result=" + result);
  }
}
