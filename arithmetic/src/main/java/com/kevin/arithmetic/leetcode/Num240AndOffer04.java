package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/16
 * Desc:
 */
public class Num240AndOffer04 {
  /**
   * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
   *
   * 示例:
   * 现有矩阵 matrix 如下：
   * [
   *   [1,   4,  7, 11, 15],
   *   [2,   5,  8, 12, 19],
   *   [3,   6,  9, 16, 22],
   *   [10, 13, 14, 17, 24],
   *   [18, 21, 23, 26, 30]
   * ]
   * 给定 target=5，返回true。
   * 给定target=20，返回false。
   *
   *
   * 限制：
   * 0 <= n <= 1000
   * 0 <= m <= 1000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean findNumberIn2DArray(int[][] matrix, int target) {
    int raw = matrix.length;
    if (raw == 0) {
      return false;
    }
    int col = matrix[0].length;
    if (col == 0) {
      return false;
    }
    for (int i = 0; i < raw; i++) {
      int left = 0;
      int right = col - 1;
      while (left <= right) {
        int center = left + (right - left) / 2;
        if (matrix[i][center] == target) {
          return true;
        } else if (matrix[i][center] < target) {
          left = center + 1;
        } else {
          right = center - 1;
        }
      }
      col = right + 1;
    }
    return false;
  }
}
