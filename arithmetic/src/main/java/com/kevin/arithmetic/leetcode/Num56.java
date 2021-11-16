package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/11/16
 * Desc: 合并区间
 */
public class Num56 {
  /**
   * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]。
   * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
   *
   * 示例 1：
   * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
   * 输出：[[1,6],[8,10],[15,18]]
   * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
   *
   * 示例2：
   * 输入：intervals = [[1,4],[4,5]]
   * 输出：[[1,5]]
   * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
   *
   * 提示：
   * 1 <= intervals.length <= 10^4
   * intervals[i].length == 2
   * 0 <= starti <= endi <= 10^4
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/merge-intervals
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
    int len = intervals.length;
    if (len <= 1) {
      return intervals;
    }
    int start = intervals[0][0];
    int end = intervals[0][1];
    List<int[]> list = new ArrayList();
    for (int i = 1; i < len; i++) {
      if (intervals[i][0] > end) {
        list.add(new int[]{start, end});
        start = intervals[i][0];
        end = intervals[i][1];
      } else {
        end = Math.max(end, intervals[i][1]);
      }
    }
    list.add(new int[]{start, end});
    return list.toArray(new int[list.size()][]);
  }
}
