package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/8/5
 * Desc:
 */
public class Num103 {
  /**
   * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
   *
   * 例如：
   * 给定二叉树[3,9,20,null,null,15,7],
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * 返回锯齿形层序遍历如下：
   *
   * [
   *   [3],
   *   [20,9],
   *   [15,7]
   * ]
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) { // 层序遍历
    List<List<Integer>> result = new ArrayList();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> deque = new LinkedList();
    deque.addLast(root);
    boolean isPositive = true;
    while (!deque.isEmpty()) {
      List<Integer> list = new ArrayList();
      int len = deque.size();
      for (int i = 0; i < len; i++) {
        TreeNode node = deque.removeFirst();
        if (node.left != null) {
          deque.addLast(node.left);
        }
        if (node.right != null) {
          deque.addLast(node.right);
        }
        list.add(node.val);
      }

      if (!isPositive) {
        Collections.reverse(list);
      }
      result.add(list);
      isPositive = !isPositive;
    }

    return result;
  }
}
