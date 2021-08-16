package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/8/16
 * Desc:
 */
public class Offer32_3 {
  /**
   * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
   *
   * 例如:
   * 给定二叉树:[3,9,20,null,null,15,7],
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * 返回其层次遍历结果：
   *
   * [
   *   [3],
   *   [20,9],
   *   [15,7]
   * ]
   * 
   *
   * 提示：
   *
   * 节点总数 <= 1000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList();
    }
    Deque<TreeNode> deque = new LinkedList();
    List<List<Integer>> result = new ArrayList();
    deque.addLast(root);
    boolean isNegative = true;
    while (!deque.isEmpty()) {
      int size = deque.size();
      ArrayList<Integer> list = new ArrayList();
      for (int i = 0; i < size; i++) {
        TreeNode node = deque.removeFirst();
        if (isNegative) {
          list.add(node.val);
        } else {
          list.add(0, node.val);
        }
        if (node.left != null) {
          deque.addLast(node.left);
        }
        if (node.right != null) {
          deque.addLast(node.right);
        }
      }
      result.add(list);
      isNegative = !isNegative;
    }
    return result;
  }
}
