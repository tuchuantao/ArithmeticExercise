package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Collections;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/7/27
 * Desc:
 */
public class Num671 {
  /**
   * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
   * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
   * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
   * <p>
   * 示例 1：
   * 输入：root = [2,2,5,null,null,5,7]
   * 输出：5
   * 解释：最小的值是 2 ，第二小的值是 5 。
   * <p>
   * 示例 2：
   * 输入：root = [2,2,2]
   * 输出：-1
   * 解释：最小的值是 2, 但是不存在第二小的值。
   * <p>
   * 提示：
   * <p>
   * 树中节点数目在范围 [1, 25] 内
   * 1 <= Node.val <= 2^31 - 1
   * 对于树中每个节点 root.val == min(root.left.val, root.right.val)
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */

  // 审题：1、根节点一定是最小的节点

  public int findSecondMinimumValue(TreeNode root) {
    ArrayList<Integer> list = new ArrayList();
    firstTraversal(root, list);
    int len = list.size();
    if (len <= 1) {
      return -1;
    }
    Collections.sort(list);
    for (int i = 1; i < len; i++) {
      if (list.get(i).intValue() != list.get(0).intValue()) { // 注意对象 与 基本数据类型
        return list.get(i);
      }
    }
    return -1;
  }

  private void firstTraversal(TreeNode node, ArrayList<Integer> list) {
    if (node == null) {
      return;
    }
    list.add(node.val);
    firstTraversal(node.left, list);
    firstTraversal(node.right, list);
  }
}
