package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/8/5
 * Desc: 从前序与中序遍历序列构造二叉树
 */
public class Num105 {
  /**
   * 给定一棵树的前序遍历preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
   *
   * 示例 1:
   * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
   * Output: [3,9,20,null,null,15,7]
   *
   * 示例 2:
   * Input: preorder = [-1], inorder = [-1]
   * Output: [-1]
   *
   * 提示:
   *
   * 1 <= preorder.length <= 3000
   * inorder.length == preorder.length
   * -3000 <= preorder[i], inorder[i] <= 3000
   * preorder和inorder均无重复元素
   * inorder均出现在preorder
   * preorder保证为二叉树的前序遍历序列
   * inorder保证为二叉树的中序遍历序列
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int preLen = preorder.length;
    int inLen = inorder.length;
    if (preLen != inLen) {
      return null;
    }
    return buildTree(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
  }

  private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }
    TreeNode node = new TreeNode(preorder[preStart]);
    int inIndex = -1;
    for (int i = inStart; i <= inEnd ; i++) {
      if (inorder[i] == preorder[preStart]) {
        inIndex = i;
        break;
      }
    }
    node.left = buildTree(preorder, preStart + 1, preEnd, inorder, inStart, inIndex - 1);
    node.right = buildTree(preorder, preStart + inIndex - inStart + 1, preEnd, inorder, inIndex + 1, inEnd); // preStart + inIndex - inStart + 1 移动左子树节点个数
    return node;
  }

  public TreeNode buildTree2(int[] preorder, int[] inorder) { // 迭代
    if (preorder == null || preorder.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.push(root);
    int inorderIndex = 0;
    for (int i = 1; i < preorder.length; i++) {
      int preorderVal = preorder[i];
      TreeNode node = stack.peek();
      if (node.val != inorder[inorderIndex]) {
        node.left = new TreeNode(preorderVal);
        stack.push(node.left);
      } else {
        while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
          node = stack.pop();
          inorderIndex++;
        }
        node.right = new TreeNode(preorderVal);
        stack.push(node.right);
      }
    }
    return root;
  }

}
