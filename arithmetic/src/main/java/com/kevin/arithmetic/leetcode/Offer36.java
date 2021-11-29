package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;

import com.kevin.arithmetic.linkedlist.Node;

/**
 * Created by tuchuantao on 2021/11/29
 * Desc: 二叉搜索树与双向链表
 */
public class Offer36 {
  /**
   * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
   * 为了让您更好地理解问题，以下面的二叉搜索树为例：
   *
   * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
   * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
   *
   * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
   *
   * 注意：本题与主站 426 题相同：https://leetcode-cn
   * .com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
   *
   * 注意：此题对比原题有改动。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   * 
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  ArrayList<Node> list = new ArrayList();
  public Node treeToDoublyList(Node root) { // 中序遍历
    if (root == null) {
      return null;
    }
    centerTraversal(root);
    int size = list.size();
    for (int i = 0; i < size; i++) {
      int left = (i - 1 + size) % size;
      int right = (i + 1 + size) % size;
      list.get(i).left = list.get(left);
      list.get(i).right = list.get(right);
    }
    return list.get(0);
  }

  private void centerTraversal(Node root) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      centerTraversal(root.left);
    }
    list.add(root);
    if (root.right != null) {
      centerTraversal(root.right);
    }
  }
}
