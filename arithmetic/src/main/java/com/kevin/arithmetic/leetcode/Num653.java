package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/12/7
 * Desc: 两数之和 IV - 输入 BST
 */
public class Num653 {
  /**
   * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
   *
   * 示例 1：
   * 输入: root = [5,3,6,2,4,null,7], k = 9
   * 输出: true
   *
   * 示例 2：
   * 输入: root = [5,3,6,2,4,null,7], k = 28
   * 输出: false
   *
   * 示例 3：
   * 输入: root = [2,1,3], k = 4
   * 输出: true
   *
   * 示例 4：
   * 输入: root = [2,1,3], k = 1
   * 输出: false
   *
   * 示例 5：
   * 输入: root = [2,1,3], k = 3
   * 输出: true
   *
   * 提示:
   * 二叉树的节点个数的范围是[1, 10^4].
   * -10^4<= Node.val <= 10^4
   * root为二叉搜索树
   * -10^5<= k <= 10^5
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  List<Integer> mList = new ArrayList();
  public boolean findTarget(TreeNode root, int k) { // 中序遍历，双指针
    mList.clear();
    centerTraversal(root);
    int left = 0;
    int right = mList.size() - 1;
    int tempSum;
    while (right > left) {
      tempSum = mList.get(left) + mList.get(right);
      if (tempSum == k) {
        return true;
      } else if (tempSum > k) {
        right--;
      } else {
        left++;
      }
    }
    return false;
  }

  private void centerTraversal(TreeNode root) {
    if (root == null) {
      return;
    }
    centerTraversal(root.left);
    mList.add(root.val);
    centerTraversal(root.right);
  }


  public boolean findTarget2(TreeNode root, int k) { // 边遍历边查找，避免遍历整棵树
    Set< Integer > set = new HashSet();
    return find(root, k, set);
  }
  public boolean find(TreeNode root, int k, Set < Integer > set) {
    if (root == null)
      return false;
    if (set.contains(k - root.val))
      return true;
    set.add(root.val);
    return find(root.left, k, set) || find(root.right, k, set);
  }
}
