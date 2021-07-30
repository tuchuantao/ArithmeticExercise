package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/7/28
 * Desc:
 */
public class Num100 {
  /**
   * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
   * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
   * <p>
   * 示例 1：
   * 输入：p = [1,2,3], q = [1,2,3]
   * 输出：true
   * <p>
   * 示例 2：
   * 输入：p = [1,2], q = [1,null,2]
   * 输出：false
   * <p>
   * 示例 3：
   * 输入：p = [1,2,1], q = [1,1,2]
   * 输出：false
   * <p>
   * 提示：
   * <p>
   * 两棵树上的节点数目都在范围 [0, 100] 内
   * -104 <= Node.val <= 104
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/same-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    Deque<TreeNode> dequeOne = new LinkedList();
    Deque<TreeNode> dequeTwo = new LinkedList();
    dequeOne.addLast(p);
    dequeTwo.addLast(q);
    while (!dequeOne.isEmpty()) {
      TreeNode nodeOne = dequeOne.removeFirst();
      TreeNode nodeTwo = dequeTwo.removeFirst();
      if (nodeOne.val != nodeTwo.val || (nodeOne.left == null && nodeTwo.left != null) || (nodeOne.left != null && nodeTwo.left == null)) {
        return false;
      } else if (nodeOne.left != null) {
        if (nodeOne.left.val != nodeTwo.left.val) {
          return false;
        }
        dequeOne.addLast(nodeOne.left);
        dequeTwo.addLast(nodeTwo.left);
      }

      if ((nodeOne.right == null && nodeTwo.right != null) || (nodeOne.right != null && nodeTwo.right == null)) {
        return false;
      } else if (nodeOne.right != null) {
        if (nodeOne.right.val != nodeTwo.right.val) {
          return false;
        }
        dequeOne.addLast(nodeOne.right);
        dequeTwo.addLast(nodeTwo.right);
      }
    }
    return true;
  }
}
