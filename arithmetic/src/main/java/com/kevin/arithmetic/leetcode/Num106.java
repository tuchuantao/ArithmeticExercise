package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/8/5
 * Desc:
 */
public class Num106 {
  /**
   * 根据一棵树的中序遍历与后序遍历构造二叉树。
   *
   * 注意:
   * 你可以假设树中没有重复的元素。
   *
   * 例如，给出
   *
   * 中序遍历 inorder = [9,3,15,20,7]
   * 后序遍历 postorder = [9,15,7,20,3]
   * 返回如下的二叉树：
   *
   *     3
   *    / \
   *   9  20
   *     /  \
   *    15   7
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    int postLen = postorder.length;
    int inLen = inorder.length;
    if (postLen != inLen) {
      return null;
    }
    return buildTree(postorder, 0, postLen - 1, inorder, 0, inLen - 1);
  }

  private TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
    if (postStart > postEnd || inStart > inEnd) {
      return null;
    }
    TreeNode node = new TreeNode(postorder[postEnd]);
    int inIndex = -1;
    for (int i = inStart; i <= inEnd; i++) {
      if (inorder[i] == postorder[postEnd]) {
        inIndex = i;
        break;
      }
    }
    node.left = buildTree(postorder, postStart, postStart + inIndex - inStart - 1 , inorder, inStart, inIndex - 1);
    node.right = buildTree(postorder, postStart + inIndex - inStart, postEnd - 1, inorder, inIndex + 1, inEnd);

    return node;
  }

  public static void main(String[] args) {
    TreeNode treeNode = new Num106().buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    Deque<TreeNode> deque = new LinkedList();
    deque.addLast(treeNode);
    while (!deque.isEmpty()) {
      TreeNode node = deque.removeFirst();
      System.out.print(node.val + ", ");
      if (node.left != null) {
        deque.addLast(node.left);
      }
      if (node.right != null) {
        deque.addLast(node.right);
      }
    }
  }
}
