package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/18
 * Desc: 第 N 位数字 / 数字序列中某一位的数字
 */
public class Num400 {
  /**
   * 给你一个整数 n ，请你在无限的整数序列[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第n 位数字。
   *
   * 示例 1：
   * 输入：n = 3
   * 输出：3
   *
   * 示例 2：
   * 输入：n = 11
   * 输出：0
   * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
   * 
   * 提示：
   * 1 <= n <= 2^31 - 1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/nth-digit
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findNthDigit(int n) {
    int digit = 1; // 数位
    long start = 1; // 起始
    long count = 9; // 索引个数
    while (n > count) { // 1. 确定 n 所在 数字 的 位数 ，记为 digit
      n -= count;
      digit += 1;
      start *= 10;
      count = digit * start * 9;
    }
    long num = start + (n - 1) / digit; // 2. 确定 n 所在的 数字 ，记为 num
    return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3. 确定 n 是 num 中的哪一数位，并返回结果
  }
}
