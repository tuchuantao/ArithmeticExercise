package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tuchuantao on 2021/11/16
 * Desc: 插入区间
 */
public class Num57 {
  /**
   * 给你一个无重叠的，按照区间起始端点排序的区间列表。
   * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
   *
   * 示例1：
   * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
   * 输出：[[1,5],[6,9]]
   *
   * 示例 2：
   * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
   * 输出：[[1,2],[3,10],[12,16]]
   * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
   *
   * 示例 3：
   * 输入：intervals = [], newInterval = [5,7]
   * 输出：[[5,7]]
   *
   * 示例 4：
   * 输入：intervals = [[1,5]], newInterval = [2,3]
   * 输出：[[1,5]]
   *
   * 示例 5：
   * 输入：intervals = [[1,5]], newInterval = [2,7]
   * 输出：[[1,7]]
   *
   * 提示：
   * 0 <= intervals.length <= 10^4
   * intervals[i].length == 2
   * 0 <=intervals[i][0] <=intervals[i][1] <= 10^5
   * intervals 根据 intervals[i][0] 按 升序 排列
   * newInterval.length == 2
   * 0 <=newInterval[0] <=newInterval[1] <= 10^5
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/insert-interval
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int len = intervals.length;
    if (len == 0) {
      return new int[][]{newInterval};
    }
    List<int[]> list = new ArrayList();
    int start = newInterval[0], end = newInterval[1];
    for (int i = 0; i < len; i++) {
      if (intervals[i][1] < start || intervals[i][0] > end) {
        list.add(intervals[i]);
      } else {
        start = Math.min(start, intervals[i][0]);
        end = Math.max(end, intervals[i][1]);
      }
    }
    int size = list.size();
    int index = 0;
    while (index < size && list.get(index)[0] < end) {
      index++;
    }
    list.add(index, new int[]{start, end});

    return list.toArray(new int[size + 1][]);
  }
}
