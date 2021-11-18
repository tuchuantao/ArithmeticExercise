package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/18
 * Desc: 不用加减乘除做加法
 */
public class Offer65 {
  /**
   * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
   *
   * 示例:
   * 输入: a = 1, b = 1
   * 输出: 2
   *
   * 提示：
   * a,b均可能是负数或 0
   * 结果不会溢出 32 位整数
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int add(int a, int b) {
    int numOne = a & b;
    int numTwo = a | b;
    int numThree = numOne ^ numTwo;
    numOne = numOne << 1;
    while (numOne != 0) {
      a = numThree;
      b = numOne;
      numOne = a & b;
      numTwo = a | b;
      numThree = numOne ^ numTwo;
      numOne = numOne << 1;
    }
    return numThree;
  }

  public int add1(int a, int b) {
    while(b != 0) { // 当进位为 0 时跳出
      int c = (a & b) << 1;  // c = 进位
      a ^= b; // a = 非进位和
      b = c; // b = 进位
    }
    return a;
  }
}
