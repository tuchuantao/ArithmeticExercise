package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/8/4
 * Desc: 将二叉搜索树变平衡
 */
public class Num1382 {
  /**
   * 给你一棵二叉搜索树，请你返回一棵平衡后的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
   * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是平衡的 。
   * 如果有多种构造方法，请你返回任意一种。
   *
   * 示例：
   * 输入：root = [1,null,2,null,3,null,4,null,null]
   * 输出：[2,1,3,null,null,null,4]
   * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
   *
   * 提示：
   *
   * 树节点的数目在1到10^4之间。
   * 树节点的值互不相同，且在1到10^5 之间。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/balance-a-binary-search-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  ArrayList<TreeNode> list = new ArrayList();
  public TreeNode balanceBST(TreeNode root) {
    centerTraversal(root);
    return realToBSt(0, list.size() - 1);
  }

  private void centerTraversal(TreeNode node) { // 中序遍历
    if (node.left != null) {
      centerTraversal(node.left);
    }
    list.add(node);
    if (node.right != null) {
      centerTraversal(node.right);
    }
    node.left = null;
    node.right = null;
  }

  private TreeNode realToBSt(int start, int end) { // 构造平衡二叉树
    if (start > end) {
      return null;
    }
    int center = (start + end) >> 1;
    TreeNode node = list.get(center);
    node.left = realToBSt(start, center - 1);
    node.right = realToBSt(center + 1, end);
    return node;
  }
}
