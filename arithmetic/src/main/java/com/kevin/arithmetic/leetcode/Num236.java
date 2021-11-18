package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/11/18
 * Desc: 二叉树的最近公共祖先
 */
public class Num236 {
  /**
   * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
   * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
   *
   * 示例 1：
   * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
   * 输出：3
   * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
   *
   * 示例 2：
   * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
   * 输出：5
   * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
   *
   * 示例 3：
   * 输入：root = [1,2], p = 1, q = 2
   * 输出：1
   *
   * 提示：
   * 树中节点数目在范围 [2, 105] 内。
   * -10^9 <= Node.val <= 10^9
   * 所有 Node.val 互不相同 。
   * p != q
   * p 和 q 均存在于给定的二叉树中。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  ArrayList<TreeNode> path = new ArrayList();
  ArrayList<ArrayList<TreeNode>> targetPath = new ArrayList();
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) { // 没有利用二叉搜索树的特性
    deepTraversal(root, p, q);
    int len = Math.min(targetPath.get(0).size(), targetPath.get(1).size());
    TreeNode node = null;
    for (int i = 0; i < len; i++) {
      if (targetPath.get(0).get(i) == targetPath.get(1).get(i)) {
        node = targetPath.get(0).get(i);
      } else {
        break;
      }
    }
    return node;
  }

  public void deepTraversal(TreeNode node, TreeNode p, TreeNode q) {
    if (node == p || node == q) {
      ArrayList<TreeNode> target = new ArrayList(path);
      target.add(node);
      targetPath.add(target);
      if (targetPath.size() == 2) {
        return;
      }
    }
    path.add(node);
    if (node.left != null) {
      deepTraversal(node.left, p, q);
    }
    if (node.right != null) {
      deepTraversal(node.right, p, q);
    }
    path.remove(node);
  }

  // 递归
  private TreeNode ans;
  private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return false;
    boolean lson = dfs(root.left, p, q);
    boolean rson = dfs(root.right, p, q);
    if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
      ans = root;
    }
    return lson || rson || (root.val == p.val || root.val == q.val);
  }

  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    this.dfs(root, p, q);
    return this.ans;
  }
}
