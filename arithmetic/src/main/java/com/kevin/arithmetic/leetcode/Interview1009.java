package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/10/18
 * Desc: 排序矩阵查找
 */
public class Interview1009 {
  /**
   * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
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
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/sorted-matrix-search-lcci
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    int raw = 0;
    int col = matrix[0].length;
    while (col >= 0 && raw <= matrix.length) {
      if (matrix[raw][col] == target) {
        return true;
      } else if (matrix[raw][col] < target) {
        raw++;
      } else {
        col--;
      }
    }
    return false;
  }
}
