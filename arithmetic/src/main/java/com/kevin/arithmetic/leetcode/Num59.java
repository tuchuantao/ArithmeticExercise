package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/10/18
 * Desc: 螺旋矩阵 II
 */
public class Num59 {
  /**
   * 给你一个正整数n ，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。
   *
   * 示例 1：
   * 输入：n = 3
   * 输出：[[1,2,3],[8,9,4],[7,6,5]]
   *
   * 示例 2：
   * 输入：n = 1
   * 输出：[[1]]
   *
   * 提示：
   * 1 <= n <= 20
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[][] generateMatrix(int n) {
    int top = 0;
    int bottom = n - 1;
    int left = 0;
    int right = n - 1;

    int[][] arr = new int[n][n];
    int num = 1;
    while (left <= right && top <= bottom) {
      for (int i = left; i <= right; i++) {
        arr[top][i] = num;
        num++;
      }
      for (int i = top + 1; i <= bottom; i++) {
        arr[i][right] = num;
        num++;
      }
      top++;
      right--;
      if (top <= bottom && left <= right) {
        for (int i = right; i >= left ; i--) {
          arr[bottom][i] = num;
          num++;
        }
        for (int i = bottom - 1; i >= top ; i--) {
          arr[i][left] = num;
          num++;
        }
        left++;
        bottom--;
      }
    }
    return arr;
  }
}
