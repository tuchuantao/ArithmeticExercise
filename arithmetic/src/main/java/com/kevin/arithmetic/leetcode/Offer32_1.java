package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/8/16
 * Desc:
 */
public class Offer32_1 {
  /**
   * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
   *
   * 例如:
   * 给定二叉树:[3,9,20,null,null,15,7],
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   * 返回：
   *
   * [3,9,20,15,7]
   *
   * 提示：
   * 节点总数 <= 1000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] levelOrder(TreeNode root) {
    if (root == null) {
      return new int[0];
    }
    Deque<TreeNode> deque = new LinkedList();
    ArrayList<Integer> list = new ArrayList();
    deque.addLast(root);
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = deque.removeFirst();
        list.add(node.val);
        if (node.left != null) {
          deque.addLast(node.left);
        }
        if (node.right != null) {
          deque.addLast(node.right);
        }
      }
    }
    int size = list.size();
    int[] result = new int[size];
    for (int i = 0; i < size; i++) {
      result[i] = list.get(i);
    }
    return result;
  }
}
