package com.kevin.arithmetic.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/12/2
 * Desc: 相对名次
 */
public class Num506 {
  /**
   * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
   * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
   * 名次第 1 的运动员获金牌 "Gold Medal" 。
   * 名次第 2 的运动员获银牌 "Silver Medal" 。
   * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
   * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
   * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
   *
   * 示例 1：
   * 输入：score = [5,4,3,2,1]
   * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
   * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
   *
   * 示例 2：
   * 输入：score = [10,3,8,9,4]
   * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
   * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
   *
   * 提示：
   * n == score.length
   * 1 <= n <= 10^4
   * 0 <= score[i] <= 10^6
   * score 中的所有值 互不相同
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/relative-ranks
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String[] findRelativeRanks1(int[] score) { // 插入排序，超时
    List<Integer> list = new LinkedList();
    list.add(0);
    int len = score.length;
    int listSize;
    for (int i = 1; i < len; i++) {
      listSize = list.size();
      for (int j = 0; j < listSize; j++) {
        if (score[i] > score[list.get(j)]) {
          list.add(j, i);
          break;
        }
      }
      if (listSize == list.size()) {
        list.add(i);
      }
    }

    String[] ans = new String[len];
    for (int i = 0; i < len; i++) {
      if (i == 0) {
        ans[list.get(i)] = "Gold Medal";
      } else if (i == 1) {
        ans[list.get(i)] = "Silver Medal";
      } else if (i == 2) {
        ans[list.get(i)] = "Bronze Medal";
      } else {
        ans[list.get(i)] = String.valueOf(i + 1);
      }
    }
    return ans;
  }

  public String[] findRelativeRanks(int[] score) { // 快排
    int n = score.length;
    String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
    int[][] arr = new int[n][2];

    for (int i = 0; i < n; ++i) {
      arr[i][0] = score[i];
      arr[i][1] = i;
    }
    Arrays.sort(arr, (a, b) -> b[0] - a[0]);
    String[] ans = new String[n];
    for (int i = 0; i < n; ++i) {
      if (i >= 3) {
        ans[arr[i][1]] = Integer.toString(i + 1);
      } else {
        ans[arr[i][1]] = desc[i];
      }
    }
    return ans;
  }

}
