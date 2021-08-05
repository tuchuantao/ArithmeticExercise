package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/7/30
 * Desc:
 */
public class Num99 {
  /**
   * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
   * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
   *
   * 示例 1：
   * 输入：root = [1,3,null,null,2]
   * 输出：[3,1,null,null,2]
   * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
   *
   * 示例 2：
   * 输入：root = [3,1,4,null,null,2]
   * 输出：[2,1,4,null,null,3]
   * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
   * 
   * 提示：
   *
   * 树上节点的数目在范围 [2, 1000] 内
   * -2^31 <= Node.val <= 2^31 - 1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public void recoverTree(TreeNode root) { // 显示中序遍历
    ArrayList<Integer> list = new ArrayList();
    centerTraversal(root, list);
    int[] swapped = findSwapped(list);
    recover(root, 2, swapped[0], swapped[1]);
  }

  private void centerTraversal(TreeNode node, List<Integer> list) {
    if (node == null) {
      return;
    }
    centerTraversal(node.left, list);
    list.add(node.val);
    centerTraversal(node.right, list);
  }

  private int[] findSwapped(ArrayList<Integer> list) {
    int n = list.size();
    int x = -1, y = -1;
    for (int i = 0; i < n - 1; ++i) {
      if (list.get(i + 1) < list.get(i)) {
        y = list.get(i + 1);
        if (x == -1) {
          x = list.get(i);
        } else {
          break;
        }
      }
    }
    return new int[]{x, y};
  }

  public void recover(TreeNode root, int count, int x, int y) {
    if (root != null) {
      if (root.val == x || root.val == y) {
        root.val = root.val == x ? y : x;
        if (--count == 0) {
          return;
        }
      }
      recover(root.right, count, x, y);
      recover(root.left, count, x, y);
    }
  }
}
