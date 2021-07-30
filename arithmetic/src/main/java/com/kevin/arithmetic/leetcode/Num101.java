package com.kevin.arithmetic.leetcode;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/7/28
 * Desc:
 */
public class Num101 {
  /**
   * 给定一个二叉树，检查它是否是镜像对称的。
   *
   * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
   *     1
   *    / \
   *   2   2
   *  / \ / \
   * 3  4 4  3
   * 
   *
   * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
   *
   *     1
   *    / \
   *   2   2
   *    \   \
   *    3    3
   * 
   *
   * 进阶：
   * 你可以运用递归和迭代两种方法解决这个问题吗？
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/symmetric-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isSymmetric(TreeNode root) { // 递归
    if (root == null) {
      return true;
    }
    return isSymmetric(root.left, root.right);
  }

  public boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null || left.val != right.val) {
      return false;
    }
    return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
  }
}
