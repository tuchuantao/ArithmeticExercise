package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/7/28
 * Desc:
 */
public class Num94 {
  /**
   * 给定一个二叉树的根节点 root ，返回它的 中序遍历。
   *
   * 示例 1：
   * 输入：root = [1,null,2,3]
   * 输出：[1,3,2]
   *
   * 示例 2：
   * 输入：root = []
   * 输出：[]
   *
   * 示例 3：
   * 输入：root = [1]
   * 输出：[1]
   *
   * 示例 4：
   * 输入：root = [1,2]
   * 输出：[2,1]
   *
   * 示例 5：
   * 输入：root = [1,null,2]
   * 输出：[1,2]
   * 
   *
   * 提示：
   * 树中节点数目在范围 [0, 100] 内
   * -100 <= Node.val <= 100
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<Integer> inorderTraversal11(TreeNode root) { // 递归
    List<Integer> list = new ArrayList();
    if (root != null) {
      centerTraversal(root, list);
    }
    return list;
  }

  public void centerTraversal(TreeNode node, List<Integer> list) {
    if (node.left != null) {
      centerTraversal(node.left, list);
    }
    list.add(node.val);
    if (node.right != null) {
      centerTraversal(node.right, list);
    }
  }

  public List<Integer> inorderTraversal(TreeNode root) { // 迭代
    List<Integer> list = new ArrayList();
    Deque<TreeNode> stack = new LinkedList();
    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      list.add(node.val);
      node = node.right;
    }
    return list;
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
