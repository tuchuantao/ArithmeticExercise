package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/8/16
 * Desc:
 */
public class Offer26 {
  /**
   * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
   * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
   *
   * 例如:
   * 给定的树 A:
   *    3
   *   / \
   *  4  5
   *  / \
   * 1  2
   * 给定的树 B：
   *
   *  4
   *  /
   * 1
   * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
   *
   * 示例 1：
   * 输入：A = [1,2,3], B = [3,1]
   * 输出：false
   *
   * 示例 2：
   * 输入：A = [3,4,5,1,2], B = [4,1]
   * 输出：true
   *
   * 限制：
   * 0 <= 节点个数 <= 10000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isSubStructure(TreeNode A, TreeNode B) {
    if (B == null || A == null) {
      return false;
    }

    Deque<TreeNode> deque = new LinkedList();
    ArrayList<TreeNode> list = new ArrayList();
    deque.addLast(A);
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = deque.removeFirst();
        if (node.val == B.val) {
          list.add(node); // 可能会有多个节点与根节点相同
        }
        if (node.left != null) {
          deque.addLast(node.left);
        }
        if (node.right != null) {
          deque.addLast(node.right);
        }
      }
    }
    if (list.isEmpty()) {
      return false;
    }
    for (TreeNode node : list) {
      if (compareNode(node, B)) {
        return true;
      }
    }

    return false;
  }

  private boolean compareNode(TreeNode node, TreeNode target) {
    if (target.left == null && target.right == null) {
      return true;
    }
    boolean result = true;
    if (target.left != null) {
      if (node.left != null && node.left.val == target.left.val) {
        result = compareNode(node.left, target.left);
      } else {
        return false;
      }
    }
    if (target.right != null) {
      if (node.right != null && node.right.val == target.right.val) {
        result = result && compareNode(node.right, target.right);
      } else {
        return false;
      }
    }
    return result;
  }



  public boolean isSubStructure11(TreeNode A, TreeNode B) {
    return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
  }
  boolean recur(TreeNode A, TreeNode B) {
    if(B == null) return true;
    if(A == null || A.val != B.val) return false;
    return recur(A.left, B.left) && recur(A.right, B.right);
  }

}
