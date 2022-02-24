package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by tuchuantao on 2022/2/24
 * Desc: 把二叉搜索树转换为累加树
 */
public class Num538 {
  /**
   * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node的新值等于原树中大于或等于node.val的值之和。
   * 提醒一下，二叉搜索树满足下列约束条件：
   * 节点的左子树仅包含键 小于 节点键的节点。
   * 节点的右子树仅包含键 大于 节点键的节点。
   * 左右子树也必须是二叉搜索树。
   *
   * 示例 1：
   *
   * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
   * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
   *
   * 示例 2：
   * 输入：root = [0,null,1]
   * 输出：[1,null,1]
   *
   * 示例 3：
   * 输入：root = [1,0,2]
   * 输出：[3,3,2]
   *
   * 示例 4：
   * 输入：root = [3,2,4,1]
   * 输出：[7,9,4,10]
   *
   * 提示：
   * 树中的节点数介于 0和 10^4之间。
   * 每个节点的值介于 -10^4和10^4之间。
   * 树中的所有值 互不相同 。
   * 给定的树为二叉搜索树。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  private static class TreeNode {
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

  public TreeNode convertBST1(TreeNode root) { // 中序遍历
    if (root == null) {
      return root;
    }
    TreeNode tempRoot = root;
    int sum = traversal(tempRoot, 0);

    Deque<TreeNode> deque = new LinkedList();
    deque.addFirst(root);
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = deque.removeLast();
        node.val = sum - node.val;
        if (node.left != null) {
          deque.addFirst(node.left);
        }
        if (node.right != null) {
          deque.addFirst(node.right);
        }
      }
    }

    return root;
  }

  public int traversal(TreeNode root, int sum) {
    if (root.left != null) {
      sum = traversal(root.left, sum);
    }
    int temp = root.val;
    root.val = sum;
    sum += temp;
    if (root.right != null) {
      sum = traversal(root.right, sum);
    }
    return sum;
  }

  int sum = 0;
  public TreeNode convertBST2(TreeNode root) { // 反序中序遍历
    if (root != null) {
      convertBST2(root.right);
      sum += root.val;
      root.val = sum;
      convertBST2(root.left);
    }
    return root;
  }

//  其反序中序遍历规则总结如下：
//  1、如果当前节点的右子节点为空，处理当前节点，并遍历当前节点的左子节点；
//  2、如果当前节点的右子节点不为空，找到当前节点右子树的最左节点（该节点为当前节点中序遍历的前驱节点）；
//      如果最左节点的左指针为空，将最左节点的左指针指向当前节点，遍历当前节点的右子节点；
//      如果最左节点的左指针不为空，将最左节点的左指针重新置为空（恢复树的原状），处理当前节点，并将当前节点置为其左节点；
//
//  重复步骤 1 和步骤 2，直到遍历结束。
  public TreeNode convertBST(TreeNode root) {
    int sum = 0;
    TreeNode node = root;

    while (node != null) {
      if (node.right == null) {
        sum += node.val;
        node.val = sum;
        node = node.left;
      } else {
        TreeNode succ = getSuccessor(node);
        if (succ.left == null) {
          succ.left = node;
          node = node.right;
        } else {
          succ.left = null;
          sum += node.val;
          node.val = sum;
          node = node.left;
        }
      }
    }

    return root;
  }

  public TreeNode getSuccessor(TreeNode node) {
    TreeNode succ = node.right;
    while (succ.left != null && succ.left != node) {
      succ = succ.left;
    }
    return succ;
  }
}
