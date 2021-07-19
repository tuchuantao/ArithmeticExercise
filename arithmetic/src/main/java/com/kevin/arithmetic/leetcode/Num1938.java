package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/19
 * Desc:
 */
public class Num1938 {

  /**
   * 给你一棵 n个节点的有根树，节点编号从0到n - 1。每个节点的编号表示这个节点的 独一无二的基因值（也就是说节点 x的基因值为 x）。两个基因值的 基因差是两者的 
   * 异或和。给你整数数组parents，其中parents[i]是节点 i的父节点。如果节点 x是树的 根，那么parents[x] == -1。
   *
   * 给你查询数组queries，其中queries[i] = [nodei, vali]。对于查询i，请你找到 vali和 pi的 最大基因差，其中pi是节点 
   * nodei到根之间的任意节点（包含 nodei和根节点）。更正式的，你想要最大化vali XOR pi。
   *
   * 请你返回数组ans，其中ans[i]是第 i个查询的答案。
   *
   * 
   *
   * 示例 1：
   *
   *     0
   *     1
   *    2 3
   *
   *
   * 输入：parents = [-1,0,1,1], queries = [[0,2],[3,2],[2,5]]
   * 输出：[2,3,7]
   * 解释：查询数组处理如下：
   * - [0,2]：最大基因差的对应节点为 0 ，基因差为 2 XOR 0 = 2 。
   * - [3,2]：最大基因差的对应节点为 1 ，基因差为 2 XOR 1 = 3 。
   * - [2,5]：最大基因差的对应节点为 2 ，基因差为 5 XOR 2 = 7 。
   * 示例 2：
   *
   *
   * 输入：parents = [3,7,-1,2,0,7,0,2], queries = [[4,6],[1,15],[0,5]]
   * 输出：[6,14,7]
   * 解释：查询数组处理如下：
   * - [4,6]：最大基因差的对应节点为 0 ，基因差为 6 XOR 0 = 6 。
   * - [1,15]：最大基因差的对应节点为 1 ，基因差为 15 XOR 1 = 14 。
   * - [0,5]：最大基因差的对应节点为 2 ，基因差为 5 XOR 2 = 7 。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/maximum-genetic-difference-query
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */

//  public int[] maxGeneticDifference(int[] parents, int[][] queries) {
//
//  }
}
