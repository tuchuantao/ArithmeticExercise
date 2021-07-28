package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/7/28
 * Desc:
 */
public class Num144 {
  /**
   * 给你二叉树的根节点 root ，返回它节点值的前序遍历。
   * <p>
   * 示例 1：
   * 输入：root = [1,null,2,3]
   * 输出：[1,2,3]
   * <p>
   * 示例 2：
   * 输入：root = []
   * 输出：[]
   * <p>
   * 示例 3：
   * 输入：root = [1]
   * 输出：[1]
   * <p>
   * 示例 4：
   * 输入：root = [1,2]
   * 输出：[1,2]
   * <p>
   * 示例 5：
   * 输入：root = [1,null,2]
   * 输出：[1,2]
   * <p>
   * 提示：
   * 树中节点数目在范围 [0, 100] 内
   * -100 <= Node.val <= 100
   * <p>
   * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<Integer> preorderTraversal11(TreeNode root) { // 递归
    List<Integer> list = new ArrayList();
    if (root != null) {
      firstTraversal(root, list);
    }
    return list;
  }

  private void firstTraversal(TreeNode root, List<Integer> list) {
    list.add(root.val);
    if (root.left != null) {
      firstTraversal(root.left, list);
    }
    if (root.right != null) {
      firstTraversal(root.right, list);
    }
  }

  public List<Integer> preorderTraversal(TreeNode root) { // 迭代
    List<Integer> list = new ArrayList();
    Deque<TreeNode> stack = new LinkedList();
    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        list.add(node.val);
        stack.push(node); // stack.addFirst(node);
        node = node.left;
      }
      node = stack.pop(); // stack.removeFirst();
      node = node.right; // PS: 某一节点只有右孩子节点
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
