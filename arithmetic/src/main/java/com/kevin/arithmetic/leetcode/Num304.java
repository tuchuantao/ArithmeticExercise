package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/12/3
 * Desc: 二维区域和检索 - 矩阵不可变
 */
public class Num304 {
  /**
   * 给定一个二维矩阵 matrix，以下类型的多个请求：
   *
   * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1,col1) ，右下角 为 (row2,col2) 。
   * 实现 NumMatrix 类：
   * NumMatrix(int[][] matrix)给定整数矩阵 matrix 进行初始化
   * int sumRegion(int row1, int col1, int row2, int col2)返回 左上角 (row1,col1)、右下角(row2,col2) 
   * 所描述的子矩阵的元素 总和 。
   *
   * 示例 1：
   * 输入:
   * ["NumMatrix","sumRegion","sumRegion","sumRegion"]
   * [[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,1,2,2],[1,2,2,4]]
   * 输出: 
   * [null, 8, 11, 12]
   *
   * 解释:
   * NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,
   * 0,5]]]);
   * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
   * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
   * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
   *
   * 提示：
   * m == matrix.length
   * n == matrix[i].length
   * 1 <= m,n <= 200
   * -10^5 <= matrix[i][j] <= 10^5
   * 0 <= row1 <= row2 < m
   * 0 <= col1 <= col2 < n
   * 最多调用 10^4 次sumRegion 方法
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  class NumMatrix {
    int[][] sumArr;

    public NumMatrix(int[][] matrix) { // 一维前缀和
      int row = matrix.length;
      int col = matrix[0].length;
      sumArr = new int[row][col];
      int tempSum;
      for (int i = 0; i < row; i++) {
        tempSum = 0;
        for (int j = 0; j < col; j++) {
          tempSum += matrix[i][j];
          sumArr[i][j] = tempSum;
        }
      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) { // O(n)
      int sum = 0;
      while (row1 <= row2) {
        sum = sum + sumArr[row1][col2] - (col1 - 1 >= 0 ? sumArr[row1][col1 - 1] : 0);
        row1++;
      }
      return sum;
    }
  }

  int[][] sums;
//  public NumMatrix(int[][] matrix) { // 二维矩阵
//    int m = matrix.length;
//    if (m > 0) {
//      int n = matrix[0].length;
//      sums = new int[m + 1][n + 1];
//      for (int i = 0; i < m; i++) {
//        for (int j = 0; j < n; j++) {
//          sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
//          // f(i,j) = f(i−1,j) + f(i,j−1) − f(i−1,j−1) + matrix[i][j];
//        }
//      }
//    }
//  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
  }
}
