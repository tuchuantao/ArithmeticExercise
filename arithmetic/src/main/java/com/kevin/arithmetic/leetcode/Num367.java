package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/4
 * Desc: 完全平方数
 */
public class Num367 {
  /**
   * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
   * 进阶：不要 使用任何内置的库函数，如 sqrt 。
   *
   * 示例 1：
   * 输入：num = 16
   * 输出：true
   *
   * 示例 2：
   * 输入：num = 14
   * 输出：false
   * 
   * 提示：
   * 1 <= num <= 2^31 - 1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/valid-perfect-square
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isPerfectSquare(int num) {
    if (num == 1) {
      return true;
    }
    int left = 1;
    int right = num / 2;
    int center;
    while (left <= right) {
      center = left + (right - left) / 2;
      if (center == num / center && num % center == 0) { // 相乘会有溢出
        return true;
      } else if (center > num / center) {
        right = center - 1;
      } else {
        left = center + 1;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    boolean result = new Num367().isPerfectSquare(808201);
    System.out.print("result=" + result);
  }
}
