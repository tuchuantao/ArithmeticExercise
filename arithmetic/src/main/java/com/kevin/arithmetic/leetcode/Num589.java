package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuchuantao on 2022/3/10
 * Desc: N 叉树的前序遍历
 */
public class Num589 {
  /**
   * 给定一个 n叉树的根节点 root，返回 其节点值的 前序遍历 。
   * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
   *
   * 示例 1：
   *     1
   *  3  2  4
   * 5 6
   * 输入：root = [1,null,3,2,4,null,5,6]
   * 输出：[1,3,5,6,2,4]
   *
   * 示例 2：
   *          1
   *  2     3     4      5
   *      6  7    8    9   10
   *         11  12    13
   *         14
   * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,
   * null,14]
   * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
   *
   * 提示：
   * 节点总数在范围[0, 10^4]内
   * 0 <= Node.val <= 10^4
   * n 叉树的高度小于或等于 1000
   *
   * 进阶：递归法很简单，你可以使用迭代法完成此题吗?
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<Integer> preorder(Node root) {
    List<Integer> list = new ArrayList();
    if (root == null) {
      return list;
    }
    Deque<Node> deque = new LinkedList();
    deque.addFirst(root);
    Node tempNode;
    while (!deque.isEmpty()) {
      tempNode = deque.removeFirst();
      list.add(tempNode.val);
      if (!tempNode.children.isEmpty()) {
        int size = tempNode.children.size();
        for (int i = size - 1; i >= 0; i--) {
          deque.addFirst(tempNode.children.get(i));
        }
      }
    }
    return list;
  }

  private class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }
}
