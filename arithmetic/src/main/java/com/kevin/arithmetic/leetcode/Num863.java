package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.kevin.arithmetic.tree.TreeNode;

/**
 * Created by tuchuantao on 2021/7/28
 * Desc:
 */
public class Num863 {
  /**
   * 给定一个二叉树（具有根结点root），一个目标结点target，和一个整数值 K 。
   * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
   *
   * 示例 1：
   *          3
   *      5       1
   *    6   2   0   8
   *       7 4
   *
   * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
   * 输出：[7,4,1]
   * 解释：
   * 所求结点为与目标结点（值为 5）距离为 2 的结点，
   * 值分别为 7，4，以及 1
   *
   * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
   * 上面的输入仅仅是对这些对象进行了序列化描述。
   *
   * 提示：
   * 给定的树是非空的。
   * 树上的每个结点都具有唯一的值0 <= node.val <= 500。
   * 目标结点target是树上的结点。
   * 0 <= K <= 1000.
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  Map<TreeNode, TreeNode> parents = new HashMap();
  List<Integer> result = new ArrayList();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    findParents(root);
    realFindDistanceK(target, null, 0, k);
    return result;
  }

//  private void findParents(TreeNode root) {
//    if (root.left != null) {
//      parents.put(root.left, root);
//      findParents(root.left);
//    }
//    if (root.right != null) {
//      parents.put(root.right, root);
//      findParents(root.right);
//    }
//  }
  private void findParents(TreeNode root) {
    Deque<TreeNode> deque = new LinkedList();
    deque.addLast(root);
    while (!deque.isEmpty()) {
      TreeNode node = deque.removeFirst();
      if (node.left != null) {
        parents.put(node.left, root);
        deque.addLast(node.left);
      }
      if (node.right != null) {
        parents.put(node.right, root);
        deque.addLast(node.right);
      }
    }
  }

  private void realFindDistanceK(TreeNode node, TreeNode from, int distance, int targetDistance) {
    if (distance == targetDistance) {
      result.add(node.val);
      return;
    }
    if (node.left != null && node.left != from) {
      realFindDistanceK(node.left, node, distance + 1, targetDistance);
    }
    if (node.right != null && node.right != from) {
      realFindDistanceK(node.right, node, distance + 1, targetDistance);
    }
    TreeNode parent = parents.get(node);
    if (parent != null && parent != from) {
      realFindDistanceK(parent, node, distance + 1, targetDistance);
    }
  }


  /**
   * 解法2:
   *    遍历target子节点找出距离为K的节点
   *    清空target节点的子节点
   *    将剩下的二叉树转为以target节点为根节点的二叉树
   *    再次遍历target子节点找出距离为K的节点
   */

}
