package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/11/25
 * Desc: 二叉树的所有路径
 */
public class Num257 {
  /**
   * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
   * 叶子节点 是指没有子节点的节点。
   *
   * 示例 1：
   * 输入：root = [1,2,3,null,5]
   * 输出：["1->2->5","1->3"]
   *
   * 示例 2：
   * 输入：root = [1]
   * 输出：["1"]
   *
   * 提示：
   * 树中节点的数目在范围 [1, 100] 内
   * -100 <= Node.val <= 100
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/binary-tree-paths
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<String> binaryTreePaths(TreeNode root) {
    Deque<Object[]> deque = new LinkedList();
    Object[] arr = new Object[2];
    arr[0] = String.valueOf(root.val);
    arr[1] = root;
    deque.addLast(arr);
    List<String> ansList = new ArrayList();
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        Object[] nodeArr = deque.removeFirst();
        TreeNode node = (TreeNode) nodeArr[1];
        String path = ((String) nodeArr[0]);
        if (node.left == null && node.right == null) {
          ansList.add(path);
          continue;
        }
        if (node.left != null) {
          arr = new Object[2];
          arr[0] = path + "->" + node.left.val;
          arr[1] = node.left;
          deque.addLast(arr);
        }
        if (node.right != null) {
          arr = new Object[2];
          arr[0] = path + "->" + node.right.val;
          arr[1] = node.right;
          deque.addLast(arr);
        }
      }
    }
    return ansList;
  }
}
