package com.kevin.arithmetic.leetcode;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/8/4
 * Desc: 路径总和
 */
public class Num112 {
  /**
   * 给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
   * 叶子节点 是指没有子节点的节点。
   *
   * 示例 1：
   * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
   * 输出：true
   *
   * 示例 2：
   * 输入：root = [1,2,3], targetSum = 5
   * 输出：false
   *
   * 示例 3：
   * 输入：root = [1,2], targetSum = 0
   * 输出：false
   *
   * 提示：
   *
   * 树中节点的数目在范围 [0, 5000] 内
   * -1000 <= Node.val <= 1000
   * -1000 <= targetSum <= 1000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/path-sum
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean hasPathSum(TreeNode root, int targetSum) { // case: [] 0   期望值为false
    if (root == null) {
      return false;
    }
    boolean result = false;
    if (root.left == null && root.right == null) {
      result = targetSum - root.val == 0;
    }
    if (root.left != null) {
      result = result || hasPathSum(root.left, targetSum - root.val);
    }
    if (root.right != null) {
      result = result || hasPathSum(root.right, targetSum - root.val);
    }
    return result;
  }


  public boolean hasPathSum11(TreeNode root, int targetSum) { // case: [] 0   期望值为false
    if (root == null) {
      return true;
    }
    return hasPathSum11(root.left, targetSum - root.val) || hasPathSum11(root.right, targetSum - root.val);
  }
}
