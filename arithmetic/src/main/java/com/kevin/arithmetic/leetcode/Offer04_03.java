package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import com.kevin.arithmetic.linkedlist.ListNode;
import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/9/7
 * Desc:
 */
public class Offer04_03 {
  /**
   * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
   *
   * 示例：
   * 输入：[1,2,3,4,5,null,7,8]
   *         1
   *        /  \
   *       2    3
   *      / \    \
   *     4   5    7
   *    /
   *   8
   *
   * 输出：[[1],[2,3],[4,5,7],[8]]
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public ListNode[] listOfDepth(TreeNode tree) {
    Deque<TreeNode> deque = new LinkedList();
    deque.addLast(tree);
    ArrayList<ListNode> list = new ArrayList();
    while (!deque.isEmpty()) {
      int len = deque.size();
      ListNode head = null;
      ListNode listNode = null;
      for (int i = 0; i < len; i++) {
        TreeNode treeNode = deque.removeFirst();
        if (head == null) {
          listNode = new ListNode(treeNode.val);
          head = listNode;
        } else {
          listNode.next = new ListNode(treeNode.val);
          listNode = listNode.next;
        }
        if (treeNode.left != null) {
          deque.addLast(treeNode.left);
        }
        if (treeNode.right != null) {
          deque.addLast(treeNode.right);
        }
      }
      list.add(head);
    }
    ListNode[] arr = new ListNode[list.size()];
    for (int i = 0; i < list.size(); i++) {
      arr[i] = list.get(i);
    }
    return arr;
  }
}
