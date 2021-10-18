package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/10/18
 * Desc: 螺旋矩阵
 */
public class Num54 {
  /**
   * 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
   *
   * 示例 1：
   * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
   * 输出：[1,2,3,6,9,8,7,4,5]
   *
   * 示例 2：
   * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
   * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
   *
   * 提示：
   * m == matrix.length
   * n == matrix[i].length
   * 1 <= m, n <= 10
   * -100 <= matrix[i][j] <= 100
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/spiral-matrix
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return new ArrayList();
    }
    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    List<Integer> list = new ArrayList();
    while (left <= right && top <= bottom) {
      for (int i = left; i <= right; i++) {
        list.add(matrix[top][i]);
      }
      for (int i = top + 1; i <= bottom; i++) {
        list.add(matrix[i][right]);
      }
      top++;
      right--;
      if (top <= bottom && left <= right) {
        for (int i = right; i >= left ; i--) {
          list.add(matrix[bottom][i]);
        }
        for (int i = bottom + 1; i >= top ; i--) {
          list.add(matrix[i][left]);
        }
        left++;
        bottom--;
      }
    }
    return list;
  }
}
