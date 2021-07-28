package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/7/28
 * Desc:
 */
public class Num145 {
  /**
   *
   * 给定一个二叉树，返回它的 后序 遍历。
   *
   * 示例:
   *
   * 输入: [1,null,2,3]
   * 1
   * \
   * 2
   * /
   * 3
   *
   * 输出: [3,2,1]
   * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
   */
  public List<Integer> postorderTraversal11(TreeNode root) { // 递归
    List<Integer> list = new ArrayList();
    if (root != null) {
      lastTraversal(root, list);
    }
    return list;
  }

  private void lastTraversal(TreeNode node, List<Integer> list) {
    if (node.left != null) {
      lastTraversal(node.left, list);
    }
    if (node.right != null) {
      lastTraversal(node.right, list);
    }
    list.add(node.val);
  }

  public List<Integer> postorderTraversal(TreeNode root) { // 迭代
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) {
      return res;
    }

    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode prev = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      if (root.right == null || root.right == prev) { // root.right == prev 当前右孩子节点是否已经遍历过
        res.add(root.val);
        prev = root;
        root = null;
      } else {
        stack.push(root);
        root = root.right;
      }
    }
    return res;
  }

  private class TreeNode {
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
