package com.kevin.arithmetic.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/6/30
 * Desc:
 */
public class Offer37 {

  /**
   * 请实现两个函数，分别用来序列化和反序列化二叉树。
   * <p>
   * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
   * <p>
   * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
   * <p>
   *
   *      1
   *   2     3
   *       4   5
   * 输入：root = [1,2,3,null,null,4,5]
   * 输出：[1,2,3,null,null,4,5]
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    return realSerialize(root, "");
  }

  /**
   * 先序遍历
   *
   * @param root
   * @param str
   * @return
   */
  private String realSerialize(TreeNode root, String str) {
    if (root == null) {
      str += "null,";
      return str;
    }

    str += root.val + ",";
    str = realSerialize(root.left, str);
    str = realSerialize(root.right, str);
    return str;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] dataArray = data.split(",");
    List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
    return realDeserialize(dataList);
  }

  private TreeNode realDeserialize(List<String> dataList) {
    if (dataList.get(0).equals("null")) {
      dataList.remove(0);
      return null;
    }
    TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
    dataList.remove(0);
    root.left = realDeserialize(dataList);
    root.right = realDeserialize(dataList);
    return root;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
  }
}
