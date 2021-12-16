package com.kevin.arithmetic.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.kevin.arithmetic.util.Utils;

/**
 * Created by tuchuantao on 2021/12/15
 * Desc: 喧闹和富有
 */
public class Num851 {
  /**
   * 有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为x的人简称为 
   * "personx"。
   * 给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 personai比 personbi更有钱。另给你一个整数数组 quiet
   * ，其中quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自恰（也就是说，在 person x 比 person y 更有钱的同时，不会出现 
   * person y 比 person x 更有钱的情况 ）。
   * 现在，返回一个整数数组 answer 作为答案，其中answer[x] =
   * y的前提是，在所有拥有的钱肯定不少于personx的人中，persony是最安静的人（也就是安静值quiet[y]最小的人）。
   *
   * 示例 1：
   * 输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
   * 输出：[5,5,2,5,4,5,6,7]
   * 解释： 
   * answer[0] = 5，
   * person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
   * 唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
   * 但是目前还不清楚他是否比 person 0 更有钱。
   * answer[7] = 7，
   * 在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
   * 最安静（有较低安静值 quiet[x]）的人是 person 7。
   * 其他的答案也可以用类似的推理来解释。
   *
   * 示例 2：
   * 输入：richer = [], quiet = [0]
   * 输出：[0]
   * 
   * 提示：
   * n == quiet.length
   * 1 <= n <= 500
   * 0 <= quiet[i] < n
   * quiet 的所有值 互不相同
   * 0 <= richer.length <= n * (n - 1) / 2
   * 0 <= ai, bi < n
   * ai != bi
   * richer 中的所有数对 互不相同
   * 对 richer 的观察在逻辑上是一致的
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/loud-and-rich
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] loudAndRich(int[][] richer, int[] quiet) { // 递归
    int n = quiet.length;
    List<Integer>[] g = new List[n];
    for (int i = 0; i < n; ++i) {
      g[i] = new ArrayList<Integer>();
    }
    for (int[] r : richer) {
      g[r[1]].add(r[0]);
    }

    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    for (int i = 0; i < n; ++i) {
      dfs(i, quiet, g, ans);
    }
    return ans;
  }

  public void dfs(int x, int[] quiet, List<Integer>[] g, int[] ans) {
    if (ans[x] != -1) {
      return;
    }
    ans[x] = x;
    for (int y : g[x]) {
      dfs(y, quiet, g, ans);
      if (quiet[ans[y]] < quiet[ans[x]]) {
        ans[x] = ans[y];
      }
    }
  }

  public int[] loudAndRich1(int[][] richer, int[] quiet) { // 拓扑排序
    int n = quiet.length;
    List<Integer>[] g = new List[n];
    for (int i = 0; i < n; ++i) {
      g[i] = new ArrayList<Integer>();
    }
    int[] inDeg = new int[n];
    for (int[] r : richer) {
      g[r[0]].add(r[1]);
      ++inDeg[r[1]]; // 由大的指向小，小的保存入度
    }

    int[] ans = new int[n];
    for (int i = 0; i < n; ++i) {
      ans[i] = i;
    }
    Queue<Integer> q = new ArrayDeque<Integer>();
    for (int i = 0; i < n; ++i) {
      if (inDeg[i] == 0) { // 没有入度，表示它比其他大，所以得从比他小的点中寻找更小的 安静值
        q.offer(i);
      }
    }
    while (!q.isEmpty()) {
      int x = q.poll();
      for (int y : g[x]) {
        if (quiet[ans[x]] < quiet[ans[y]]) {
          ans[y] = ans[x]; // 更新 x 的邻居的答案
        }
        if (--inDeg[y] == 0) {
          q.offer(y);
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] ans = new Num851().loudAndRich(new int[][]{{1,0}, {2,1}, {3,1}, {3,7}, {4,3}, {5,3}, {6,3}}, new int[] {3,2,5,4,6,1,7,0});
    Utils.printArr(ans);
  }

  //输入
  //[[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]]
  //[3,2,5,4,6,1,7,0]
  //输出
  //[3,3,3,3,3,3,3,3]
  //预期结果
  //[5,5,2,5,4,5,6,7]
}
