package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/11/25
 * Desc: 路径总和 III
 */
public class Num437 {
  /**
   * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
   * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
   *
   * 示例 1：
   * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
   * 输出：3
   * 解释：和等于 8 的路径有 3 条，如图所示。
   *
   * 示例 2：
   * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
   * 输出：3
   *
   * 提示:
   * 二叉树的节点个数的范围是 [0,1000]
   * -10^9<= Node.val <= 10^9
   * -1000<= targetSum<= 1000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/path-sum-iii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int pathSum1(TreeNode root, int targetSum) { // 深度优先搜索
    if (root == null) {
      return 0;
    }

    int ret = rootSum(root, targetSum);
    ret += pathSum(root.left, targetSum);
    ret += pathSum(root.right, targetSum);
    return ret;
  }

  public int rootSum(TreeNode root, int targetSum) {
    int ret = 0;

    if (root == null) {
      return 0;
    }
    int val = root.val;
    if (val == targetSum) {
      ret++;
    }

    ret += rootSum(root.left, targetSum - val);
    ret += rootSum(root.right, targetSum - val);
    return ret;
  }

  public int pathSum(TreeNode root, int targetSum) { // 前缀和
    HashMap<Long, Integer> prefix = new HashMap<>();
    prefix.put(0L, 1);
    return dfs(root, prefix, 0, targetSum);
  }

  public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
    if (root == null) {
      return 0;
    }

    curr += root.val;

    int ret = prefix.getOrDefault(curr - targetSum, 0);
    prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
    ret += dfs(root.left, prefix, curr, targetSum);
    ret += dfs(root.right, prefix, curr, targetSum);
    prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

    return ret;
  }
}
