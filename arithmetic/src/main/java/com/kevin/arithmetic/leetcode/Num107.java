package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/7/29
 * Desc:
 */
public class Num107 {
  /**
   * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
   *
   * 例如：
   * 给定二叉树 [3,9,20,null,null,15,7],
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * 返回其自底向上的层序遍历为：
   *
   * [
   *   [15,7],
   *   [9,20],
   *   [3]
   * ]
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> currDeque = new LinkedList();
    currDeque.addLast(root);
    while (!currDeque.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      int dequeSize = currDeque.size();
      for (int i = 0; i < dequeSize; i++) {
        TreeNode node = currDeque.removeFirst();
        list.add(node.val);
        if (node.left != null) {
          currDeque.addLast(node.left);
        }
        if (node.right != null) {
          currDeque.addLast(node.right);
        }
      }
      result.add(0, list); // 每次添加在最前面
    }
    return result;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
