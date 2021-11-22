package com.kevin.arithmetic.leetcode;

import java.util.Stack;

/**
 * Created by tuchuantao on 2021/11/22
 * Desc: 二叉搜索树的后序遍历序列
 */
public class Offer33 {
  /**
   * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
   * 参考以下这颗二叉搜索树：
   *      5
   *     / \
   *    2   6
   *   / \
   *  1   3
   *
   * 示例 1：
   * 输入: [1,6,3,2,5]
   * 输出: false
   *
   * 示例 2：
   * 输入: [1,3,2,6,5]
   * 输出: true
   *
   * 提示：
   * 数组长度 <= 1000
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean verifyPostorder(int[] postorder) {
    int len = postorder.length;
    if (len <= 2) {
      return true;
    }
    return realVerifyPostorder(postorder, 0, postorder.length - 1, Integer.MAX_VALUE + 1L);
  }

  public boolean realVerifyPostorder(int[] postorder, int startIndex, int rootIndex, long maxVal) {
    if (startIndex >= rootIndex - 1) {
      return postorder[startIndex] < maxVal && postorder[rootIndex] < maxVal;
    }
    int index = rootIndex - 1;
    while (index >= startIndex && postorder[index] > postorder[rootIndex]) {
      if (postorder[index] >= maxVal) {
        return false;
      }
      index--;
    }
    boolean result = true;
    if (index < startIndex) {
      result = realVerifyPostorder(postorder, startIndex, rootIndex - 1, maxVal);
    } else {
      result = realVerifyPostorder(postorder, index + 1, rootIndex - 1, maxVal);
      result = result && realVerifyPostorder(postorder, startIndex, index, postorder[rootIndex]);
    }

    return result;
  }

  public boolean verifyPostorder2(int[] postorder) {
    Stack<Integer> stack = new Stack<>();
    int root = Integer.MAX_VALUE;
    for(int i = postorder.length - 1; i >= 0; i--) {
      if(postorder[i] > root) return false;
      while(!stack.isEmpty() && stack.peek() > postorder[i])
        root = stack.pop();
      stack.add(postorder[i]);
    }
    return true;
  }

  public static void main(String[] args) {
    boolean result = new Offer33().verifyPostorder(new int[]{7, 4, 6, 5});
    System.out.println("result=" + result);
  }
}
