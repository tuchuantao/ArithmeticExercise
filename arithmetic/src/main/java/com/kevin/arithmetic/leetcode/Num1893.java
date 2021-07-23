package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/23
 * Desc:
 */
public class Num1893 {

  /**
   * 给你一个二维整数数组ranges和两个整数left和right。每个ranges[i] = [starti, endi]表示一个从starti到endi的闭区间。
   * 如果闭区间[left, right]内每个整数都被ranges中至少一个区间覆盖，那么请你返回true，否则返回false。
   * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi，那么我们称整数x被覆盖了。
   *
   * 示例 1：
   *
   * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
   * 输出：true
   * 解释：2 到 5 的每个整数都被覆盖了：
   * - 2 被第一个区间覆盖。
   * - 3 和 4 被第二个区间覆盖。
   * - 5 被第三个区间覆盖。
   * 示例 2：
   *
   * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
   * 输出：false
   * 解释：21 没有被任何一个区间覆盖。
   * 
   * 提示：
   *
   * 1 <= ranges.length <= 50
   * 1 <= starti <= endi <= 50
   * 1 <= left <= right <= 50
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isCovered11(int[][] ranges, int left, int right) {
    int row = ranges.length;
    int[] arr = new int[51];
    for (int i = 0; i < row; i++) {
      for (int j = ranges[i][0]; j <= ranges[i][1] ; j++) {
        arr[j] = 1;
      }
    }
    for (int i = left; i <= right ; i++) {
      if (arr[i] == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * 差分数组：原始数组的相邻元素之间的差值，我们令 d[i] = a[i+1] - a[i]
   *
   * [[1,10],[10,20]]
   *
   *  1   10 11  20 21
   *  1      -1
   *      1         -1
   */

  public boolean isCovered(int[][] ranges, int left, int right) {
    int[] diff = new int[52];   // 差分数组
    for (int[] range : ranges) {
      ++diff[range[0]];
      --diff[range[1] + 1];
    }
    // 前缀和
    int curr = 0;
    for (int i = 1; i <= 50; ++i) {
      curr += diff[i];
      if (i >= left && i <= right && curr <= 0) {
        return false;
      }
    }
    return true;
  }
}
