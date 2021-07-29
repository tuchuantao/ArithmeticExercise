package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tuchuantao on 2021/7/29
 * Desc:
 */
public class Num1104 {
  /**
   * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按“之” 字形进行标记。
   * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
   * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
   * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
   * <p>
   * 示例 1：
   * 输入：label = 14
   * 输出：[1,3,4,14]
   * <p>
   * 示例 2：
   * 输入：label = 26
   * 输出：[1,2,6,10,26]
   * <p>
   * 提示：
   * 1 <= label <= 10^6
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<Integer> pathInZigZagTree(int label) {
    int depth = 1, rowStart = 1;
    while (rowStart * 2 <= label) {
      depth++;
      rowStart *= 2;
    }

    ArrayList<Integer> list = new ArrayList();
    if (depth % 2 == 0) {
      label = getReverse(label, depth);
    }
    while (depth > 0) {
      if (depth % 2 == 0) {
        list.add(getReverse(label, depth));
      } else {
        list.add(label);
      }
      label = label >> 1;
      depth--;
    }
    Collections.reverse(list);

    return list;
  }

  public int getReverse(int label, int row) { // 对于同一个节点，其翻转前后的标号之和为 2^(i-1) + 2^i - 1    当层占满 & 上面所以层 double
    return (1 << row - 1) + (1 << row) - 1 - label;
  }

  public static void main(String[] args) {
    List<Integer> list = new Num1104().pathInZigZagTree(26);
    for (Integer in : list) {
      System.out.print(in + ", ");
    }
  }
}
