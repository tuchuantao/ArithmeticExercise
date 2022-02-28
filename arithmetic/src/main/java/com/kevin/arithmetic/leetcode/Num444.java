package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by tuchuantao on 2022/2/28
 * Desc: 重建序列
 */
public class Num444 {
  /**
   * 请判断原始的序列org是否可以从序列集seqs中唯一地 重建。
   * 序列org是 1 到 n 整数的排列，其中 1 ≤ n ≤ 10^4。重建是指在序列集 seqs 中构建最短的公共超序列，即seqs中的任意序列都是该最短序列的子序列。
   *
   * 示例 1：
   * 输入: org = [1,2,3], seqs = [[1,2],[1,3]]
   * 输出: false
   * 解释：[1,2,3] 不是可以被重建的唯一的序列，因为 [1,3,2] 也是一个合法的序列。
   *
   * 示例 2：
   * 输入: org = [1,2,3], seqs = [[1,2]]
   * 输出: false
   * 解释：可以重建的序列只有 [1,2]。
   *
   * 示例 3：
   * 输入: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
   * 输出: true
   * 解释：序列 [1,2], [1,3] 和 [2,3] 可以被唯一地重建为原始的序列 [1,2,3]。
   *
   * 示例 4：
   * 输入: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
   * 输出: true
   *
   * 提示：
   * 1 <= n <= 10^4
   * org 是数字 1 到 n 的一个排列
   * 1 <= segs[i].length <= 10^5
   * seqs[i][j] 是 32 位有符号整数
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/ur2n8P
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
    final int N = org.length;
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) { // org: 由 1 ～ n
      arr[org[i] - 1] = i;
    }
    boolean[] oks = new boolean[N];
    for (List<Integer> list : seqs) {
      int v0 = -1;
      int sz = list.size();
      for(int i = 0; i < sz; i++) {
        int v = list.get(i).intValue() - 1;
        if(v < 0 || v >= N)
          return false;
        v = arr[v];
        // 确定相对位置
        if (v <= v0)
          return false;
        // 确定相邻位置
        if (v == v0 + 1) {
          oks[v] = true;
        }
        v0 = v;
      }
    }
    for (int i = 0; i < N; i++) {
      if (!oks[i])
        return false;
    }
    return true;
  }

  public boolean sequenceReconstruction11(int[] org, List<List<Integer>> seqs) {
    int nodeCnt = org.length;

    // 由于org是全排列，因此可以直接用数组记录节点的入度
    int[] node2incnt = new int[nodeCnt+1];

    // 记录节点是否出现过，如果有一个节点不存在，肯定无法重建序列
    boolean[] exist = new boolean[nodeCnt+1];
    List<Set<Integer>> graph = new ArrayList<>(nodeCnt);

    // 预先准备好资源，避免繁杂的null判断
    for(int i = 0; i <= nodeCnt; i++) {
      graph.add(new HashSet<>());
    }

    for(List<Integer> seq: seqs) {
      int lastNode = seq.get(0);

      for(int i = 0; i < seq.size(); i++) {
        int curNode = seq.get(i);

        // 如果出现非org里的节点，也不可能重建org
        if(curNode <= 0 || curNode > nodeCnt) return false;
        exist[curNode] = true;

        // 除了第一个节点只有出没有入之外，都得增加入度
        if(i>0 && graph.get(lastNode).add(curNode)){
          node2incnt[curNode]++;
        }

        lastNode = curNode;
      }
    }

    Queue<Integer> bfs = new LinkedList<>();
    for(int i = 1; i <= nodeCnt; i++) {
      if(exist[i]==false) return false;
      if(node2incnt[i]==0) bfs.offer(i);
    }

    int sameCnt = 0;
    while(!bfs.isEmpty()) {
      int size = bfs.size();
      // 判断是否唯一序列
      if(size > 1) return false;
      while(size-- > 0) {
        int curNode = bfs.poll();
        // 判断序列是否匹配
        if(curNode != org[sameCnt++]) return false;
        for(int nxtNode: graph.get(curNode)) {
          node2incnt[nxtNode]--;
          if(node2incnt[nxtNode]==0)
            bfs.offer(nxtNode);
        }
      }
    }
    return sameCnt == nodeCnt;
  }
}
