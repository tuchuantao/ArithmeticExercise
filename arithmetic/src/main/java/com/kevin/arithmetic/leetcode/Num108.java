package com.kevin.arithmetic.leetcode;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/8/3
 * Desc:
 */
public class Num108 {
  /**
   * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
   * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
   * <p>
   * 示例 1：
   * 输入：nums = [-10,-3,0,5,9]
   * 输出：[0,-3,9,-10,null,5]
   * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
   * <p>
   * 示例 2：
   * 输入：nums = [1,3]
   * 输出：[3,1]
   * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
   * <p>
   * 提示：
   * <p>
   * 1 <= nums.length <= 10^4
   * -10^4 <= nums[i] <= 10^4
   * nums 按 严格递增 顺序排列
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public TreeNode sortedArrayToBST(int[] nums) {
    return realToBST(nums, 0 , nums.length - 1);
  }

  private TreeNode realToBST(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }
    int center = (start + end) >> 1;
    TreeNode node = new TreeNode(nums[center]);
    node.left = realToBST(nums, start, center - 1);
    node.right = realToBST(nums, center + 1, end);
    return node;
  }


}
