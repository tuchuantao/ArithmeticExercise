package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/16
 * Desc:
 */
public class Num73 {
  /**
   * 给定一个m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
   *
   * 进阶：
   * 一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
   * 一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
   * 你能想出一个仅使用常量空间的解决方案吗？
   * 
   * 示例 1：
   * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
   * 输出：[[1,0,1],[0,0,0],[1,0,1]]
   *
   * 示例 2：
   * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
   * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
   * 
   * 提示：
   * m == matrix.length
   * n == matrix[0].length
   * 1 <= m, n <= 200
   * -2^31 <= matrix[i][j] <= 2^31 - 1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public void setZeroes1(int[][] matrix) { // 辅助空间 m+n
    int row = matrix.length;
    int col = matrix[0].length;
    int[] rowArr = new int[row];
    int[] colArr = new int[col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] == 0) {
          rowArr[i] = 1;
          colArr[i] = 1;
        }
      }
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (rowArr[i] == 1 || colArr[j] == 1) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  public void setZeroes(int[][] matrix) { // 使用第一行&第一列
    int row = matrix.length;
    int col = matrix[0].length;

  }

  // 使用第一列，倒查

}
