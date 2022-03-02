package com.kevin.arithmetic.leetcode;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2022/3/2
 * Desc: 二叉搜索树中的中序后继
 */
public class Num285 {
  /**
   * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
   * 节点p的后继是值比p.val大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
   *
   * 示例 1：
   * 输入：root = [2,1,3], p = 1
   * 输出：2
   * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
   *
   * 示例2：
   * 输入：root = [5,3,6,2,4,null,null,1], p = 6
   * 输出：null
   * 解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
   *
   * 提示：
   * 树中节点的数目在范围 [1, 10^4] 内。
   * -10^5 <= Node.val <= 10^5
   * 树中各节点的值均保证唯一。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/P5rCT8
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode res = null;
    while (root != null) {
      if (root.val > p.val) {
        res = root;
        root = res.left;
      } else {
        root = root.right;
      }
    }

    return res;
  }

  // [6,2,8,0,4,7,9,null,null,3,5]
  //2
  //输出：
  //6
  //预期结果：
  //3
}
