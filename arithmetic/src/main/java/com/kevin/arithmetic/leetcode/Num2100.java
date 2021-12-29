package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/12/28
 * Desc: 适合打劫银行的日子
 */
public class Num2100 {
  /**
   * 你和一群强盗准备打劫银行。给你一个下标从 0开始的整数数组security，其中security[i]是第 i天执勤警卫的数量。日子从 
   * 0开始编号。同时给你一个整数time。
   * 如果第 i天满足以下所有条件，我们称它为一个适合打劫银行的日子：
   * 第 i天前和后都分别至少有 time天。
   * 第 i天前连续 time天警卫数目都是非递增的。
   * 第 i天后连续 time天警卫数目都是非递减的。
   * 更正式的，第 i 天是一个合适打劫银行的日子当且仅当：security[i - time] >= security[i - time + 1] >= ... >= 
   * security[i] <= ... <= security[i + time - 1] <= security[i + time].
   * 请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0开始）。返回的日子可以 任意顺序排列。
   *
   * 示例 1：
   * 输入：security = [5,3,3,3,5,6,2], time = 2
   * 输出：[2,3]
   * 解释：
   * 第 2 天，我们有 security[0] >= security[1] >= security[2] <= security[3] <= security[4] 。
   * 第 3 天，我们有 security[1] >= security[2] >= security[3] <= security[4] <= security[5] 。
   * 没有其他日子符合这个条件，所以日子 2 和 3 是适合打劫银行的日子。
   *
   * 示例 2：
   * 输入：security = [1,1,1,1,1], time = 0
   * 输出：[0,1,2,3,4]
   * 解释：
   * 因为 time 等于 0 ，所以每一天都是适合打劫银行的日子，所以返回每一天。
   *
   * 示例 3：
   * 输入：security = [1,2,3,4,5,6], time = 2
   * 输出：[]
   * 解释：
   * 没有任何一天的前 2 天警卫数目是非递增的。
   * 所以没有适合打劫银行的日子，返回空数组。
   *
   * 示例 4：
   * 输入：security = [1], time = 5
   * 输出：[]
   * 解释：
   * 没有日子前面和后面有 5 天时间。
   * 所以没有适合打劫银行的日子，返回空数组。
   *
   * 提示：
   * 1 <= security.length <= 10^5
   * 0 <= security[i], time <= 10^5
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<Integer> goodDaysToRobBank1(int[] security, int time) { // 暴力枚举 (超时)
    int len = security.length;
    List<Integer> list = new ArrayList();
    for (int i = time; i < len - time; i++) {
      boolean isValid = true;
      for (int j = i - time + 1; j <= i; j++) {
        if (security[j - 1] < security[j]) {
          isValid = false;
          break;
        }
      }
      if (!isValid) {
        continue;
      }
      for (int j = i; j < i + time; j++) {
        if (security[j] > security[j + 1]) {
          isValid = false;
          break;
        }
      }
      if (isValid) {
        list.add(i);
      }
    }
    return list;
  }

  /**
   * 分别用两个数组记录在当前日子之前有连续多少天警卫数目是非递增和当前日子之后有连续多少天警卫数目非递减，最后遍历两个数组找到满足条件的日子加进结果集合中。
   */
  public List<Integer> goodDaysToRobBank(int[] security, int time) {
    int len = security.length;
    List<Integer> list = new ArrayList();
    if (len < 2 * time + 1) {
      return list;
    }
    int[] leftArr = new int[len];
    int[] rightArr = new int[len];
    leftArr[0] = 0;
    rightArr[len - 1] = 0;
    int cnt = 0;
    for (int i = 1; i < len; ++i) {
      if (security[i - 1] >= security[i]) {
        cnt++;
      } else {
        cnt = 0;
      }
      leftArr[i] = cnt;
    }
    cnt = 0;
    for (int i = len - 2; i >= 0; --i) {
      if (security[i + 1] >= security[i]) {
        cnt++;
      } else {
        cnt = 0;
      }
      rightArr[i] = cnt;
    }
    for (int i = 0; i < len; ++i) {
      if (leftArr[i] >= time && rightArr[i] >= time) {
        list.add(i);
      }
    }
    return list;
  }
}
