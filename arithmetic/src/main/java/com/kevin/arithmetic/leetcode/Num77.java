package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuchuantao on 2022/1/6
 * Desc: 组合
 */
public class Num77 {
  /**
   * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
   * 你可以按 任何顺序 返回答案。
   *
   * 示例 1：
   * 输入：n = 4, k = 2
   * 输出：
   * [
   *   [2,4],
   *   [3,4],
   *   [2,3],
   *   [1,2],
   *   [1,3],
   *   [1,4],
   * ]
   *
   * 示例 2：
   * 输入：n = 1, k = 1
   * 输出：[[1]]
   *
   * 提示：
   * 1 <= n <= 20
   * 1 <= k <= n
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/combinations
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList();
    backTrack(n, k, res, new LinkedList());
    return res;
  }
  private static void backTrack(int n, int k, List<List<Integer>> res, LinkedList<Integer> track) {
    if (k == track.size()) {
      res.add(new LinkedList<>(track));
      return;
    }
    int i = 1;
    if(track.size() > 0) {
      i = track.get(track.size() - 1) + 1;
    }
    for (; i <= n; i++) {
      if (track.contains(i)) {
        continue;
      }
      //选择
      track.addLast(i);
      //递归
      backTrack(n, k, res, track);
      //撤销选择
      track.removeLast();
    }
  }
}
