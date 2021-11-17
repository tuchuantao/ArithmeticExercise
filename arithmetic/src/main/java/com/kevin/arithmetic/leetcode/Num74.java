package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/17
 * Desc: 搜索二维矩阵
 */
public class Num74 {
  /**
   * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
   * 每行中的整数从左到右按升序排列。
   * 每行的第一个整数大于前一行的最后一个整数。
   *
   * 示例 1：
   * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
   * 输出：true
   *
   * 示例 2：
   * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
   * 输出：false
   *
   * 提示：
   * m == matrix.length
   * n == matrix[i].length
   * 1 <= m, n <= 100
   * -10^4 <= matrix[i][j], target <= 10^4
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;
    int col = matrix[0].length;
    int left = 0, right = row * col - 1, center;
    while (left <= right) {
      center = left + ((right - left) >> 1);
      if (matrix[center / col][center % col] == target) {
        return true;
      } else if (matrix[center / col][center % col] > target) {
        right = center - 1;
      } else {
        left = center + 1;
      }
    }
    return false;
  }
}
