package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Collections;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/8/4
 * Desc: 二叉搜索树的最近公共祖先
 */
public class Num235 {
  /**
   * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
   * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
   * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
   *
   * 示例 1:
   * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
   * 输出: 6 
   * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
   *
   * 示例 2:
   * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
   * 输出: 2
   * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
   *
   * 说明:
   * 所有节点的值都是唯一的。
   * p、q 为不同节点且均存在于给定的二叉搜索树中。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  ArrayList<TreeNode> path = new ArrayList();
  ArrayList<ArrayList<TreeNode>> targetPath = new ArrayList();
  public TreeNode lowestCommonAncestor11(TreeNode root, TreeNode p, TreeNode q) { // 没有利用二叉搜索树的特性
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


  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode ancestor = root;
    while (true) {
      if (p.val < ancestor.val && q.val < ancestor.val) {
        ancestor = ancestor.left;
      } else if (p.val > ancestor.val && q.val > ancestor.val) {
        ancestor = ancestor.right;
      } else {
        break;
      }
    }
    return ancestor;
  }
}
