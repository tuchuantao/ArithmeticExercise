package com.kevin.arithmetic.leetcode;

import java.util.Collections;
import java.util.List;

/**
 * Created by tuchuantao on 2022/1/18
 * Desc: 最小时间差
 */
public class Num539 {
  /**
   * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
   *
   * 示例 1：
   * 输入：timePoints = ["23:59","00:00"]
   * 输出：1
   *
   * 示例 2：
   * 输入：timePoints = ["00:00","23:59","00:00"]
   * 输出：0
   *
   * 提示：
   * 2 <= timePoints <= 2 * 10^4
   * timePoints[i] 格式为 "HH:MM"
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/minimum-time-difference
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findMinDifference(List<String> timePoints) {
    timePoints.sort((a, b) -> a.compareTo(b)); // 排序
    // Collections.sort(timePoints);

    int size = timePoints.size();
    int minDiff = Integer.MAX_VALUE;
    for (int i = 1; i < size; i++) {
      minDiff = Math.min(minDiff, stringDiff(timePoints.get(i), timePoints.get(i - 1))); // 相邻时间差
    }

    minDiff = Math.min(minDiff, stringDiff(timePoints.get(0), timePoints.get(size - 1)) + 24 * 60); // 首尾时间差
    return minDiff;
  }

  public int stringDiff(String oneStr, String twoStr) {
    int hour = Integer.valueOf(oneStr.substring(0, 2)) - Integer.valueOf(twoStr.substring(0, 2));
    int minute = Integer.valueOf(oneStr.substring(3, 5)) - Integer.valueOf(twoStr.substring(3, 5));
    return minute + hour * 60;
  }


  public int findMinDifference1(List<String> timePoints) {
    int n = timePoints.size();
    if (n > 1440) {
      return 0;
    }
    Collections.sort(timePoints);
    int ans = Integer.MAX_VALUE;
    int t0Minutes = getMinutes(timePoints.get(0));
    int preMinutes = t0Minutes;
    for (int i = 1; i < n; ++i) {
      int minutes = getMinutes(timePoints.get(i));
      ans = Math.min(ans, minutes - preMinutes); // 相邻时间的时间差
      preMinutes = minutes;
    }
    ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // 首尾时间的时间差
    return ans;
  }

  public int getMinutes(String t) {
    return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
  }

}
