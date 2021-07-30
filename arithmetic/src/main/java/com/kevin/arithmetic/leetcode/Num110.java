package com.kevin.arithmetic.leetcode;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/7/29
 * Desc:
 */
public class Num110 {
  /**
   * 给定一个二叉树，判断它是否是高度平衡的二叉树。
   * 本题中，一棵高度平衡二叉树定义为：
   * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
   *
   * 示例 1：
   * 输入：root = [3,9,20,null,null,15,7]
   * 输出：true
   *
   * 示例 2：
   * 输入：root = [1,2,2,3,3,null,null,4,4]
   * 输出：false
   *
   * 示例 3：
   * 输入：root = []
   * 输出：true
   * 
   * 提示：
   * 树中的节点数在范围 [0, 5000] 内
   * -10^4 <= Node.val <= 10^4
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isBalanced11(TreeNode root) { // 自顶向下，递归，
    if (root == null) {
      return true;
    } else {
      return Math.abs(height11(root.left) - height11(root.right)) <= 1 && isBalanced11(root.left) && isBalanced11(root.right);
    }
  }

  private int height11(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return Math.max(height11(node.left), height11(node.right)) + 1;
  }


  public boolean isBalanced(TreeNode root) {
    return height(root) >= 0;
  }

  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) { // 先判断每一颗子树是否是平衡二叉树
      return -1;
    } else {
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }
}
