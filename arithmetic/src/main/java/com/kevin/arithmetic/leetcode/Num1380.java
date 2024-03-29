package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuchuantao on 2022/2/15
 * Desc: 矩阵中的幸运数
 */
public class Num1380 {
  /**
   * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
   * 幸运数是指矩阵中满足同时下列两个条件的元素：
   * 在同一行的所有元素中最小
   * 在同一列的所有元素中最大
   *
   * 示例 1：
   * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
   * 输出：[15]
   * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
   *
   * 示例 2：
   * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
   * 输出：[12]
   * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
   *
   * 示例 3：
   * 输入：matrix = [[7,8],[1,2]]
   * 输出：[7]
   *
   * 提示：
   * m == mat.length
   * n == mat[i].length
   * 1 <= n, m <= 50
   * 1 <=matrix[i][j]<= 10^5
   * 矩阵中的所有元素都是不同的
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<Integer> luckyNumbers(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int[] rowArr = new int[row];
    int[] colArr = new int[col];
    for (int i = 0; i < row; i++) {
      int minIndex = 0;
      for (int j = 1; j < col; j++) {
        minIndex = matrix[i][minIndex] > matrix[i][j] ? j : minIndex;
      }
      rowArr[i] = minIndex;
    }
    for (int i = 0; i < col; i++) {
      int maxIndex = 0;
      for (int j = 1; j < row; j++) {
        maxIndex = matrix[maxIndex][i] < matrix[j][i] ? j : maxIndex;
      }
      colArr[i] = maxIndex;
    }

    List<Integer> list = new ArrayList();
    for (int i = 0; i < row; i++) {
      int colIndex = rowArr[i];
      if (colArr[colIndex] == i) {
        list.add(matrix[i][colIndex]);
      }
    }
    return list;
  }
}
