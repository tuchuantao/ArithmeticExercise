package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/8/4
 * Desc:
 */
public class Num226 {
  /**
   * 翻转一棵二叉树。
   *
   * 示例：
   * 输入：
   *      4
   *    /   \
   *   2     7
   *  / \   / \
   * 1   3 6   9
   *
   * 输出：
   *      4
   *    /   \
   *   7     2
   *  / \   / \
   * 9   6 3   1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/invert-binary-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    Deque<TreeNode> stack = new LinkedList();
    stack.addLast(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.removeFirst();
      if (node.left != null) {
        stack.addLast(node.left);
      }
      if (node.right != null) {
        stack.addLast(node.right);
      }
      TreeNode temp = node.left;
      node.left = node.right;
      node.right = temp;
    }
    return root;
  }
}
