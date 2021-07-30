package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/7/29
 * Desc:
 */
public class Num104 {
  /**
   * 给定一个二叉树，找出其最大深度。
   * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
   * 说明:叶子节点是指没有子节点的节点。
   *
   * 示例：
   * 给定二叉树 [3,9,20,null,null,15,7]，
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * 返回它的最大深度3 。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int maxDepth11(TreeNode root) { // 递归
    if (root == null) {
      return 0;
    }
    return firstTraversal(1, root);
  }

  private int firstTraversal(int depth, TreeNode root) {
    int maxDep = depth;
    if (root.left != null) {
      maxDep = Math.max(maxDep, firstTraversal(depth + 1, root.left));
    }
    if (root.right != null) {
      maxDep = Math.max(maxDep, firstTraversal(depth + 1, root.right));
    }
    return maxDep;
  }


  public int maxDepth(TreeNode root) { // 迭代
    if (root == null) {
      return 0;
    }
    Deque<TreeNode> deque = new LinkedList();
    Deque<TreeNode> nextDeque = new LinkedList();
    int depth = 1;
    deque.addLast(root);
    while (true) {
      while (!deque.isEmpty()) {
        TreeNode node = deque.pop();
        if (node.left != null) {
          nextDeque.push(node.left);
        }
        if (node.right != null) {
          nextDeque.push(node.right);
        }
      }
      if (nextDeque.isEmpty()) {
        break;
      } else {
        depth++;
        deque = nextDeque;
        nextDeque = new LinkedList();
      }
    }
    return depth;
  }
}
