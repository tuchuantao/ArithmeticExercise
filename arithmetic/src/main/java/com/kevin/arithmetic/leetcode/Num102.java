package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/7/29
 * Desc:
 */
public class Num102 {
  /**
   * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
   *
   * 示例：
   * 二叉树：[3,9,20,null,null,15,7],
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * 返回其层序遍历结果：
   * [
   *   [3],
   *   [9,20],
   *   [15,7]
   * ]
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */

  public List<List<Integer>> levelOrder(TreeNode root) {
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
      result.add(list);
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
