package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/4
 * Desc: Pow(x, n)
 */
public class Num50 {
  /**
   * 实现pow(x, n)，即计算 x 的 n 次幂函数（即，x^n）。
   *
   * 示例 1：
   * 输入：x = 2.00000, n = 10
   * 输出：1024.00000
   *
   * 示例 2：
   * 输入：x = 2.10000, n = 3
   * 输出：9.26100
   *
   * 示例 3：
   * 输入：x = 2.00000, n = -2
   * 输出：0.25000
   * 解释：2-2 = 1/22 = 1/4 = 0.25
   *
   * 提示：
   * -100.0 < x < 100.0
   * -2^31<= n <= 2^31-1
   * -10^4 <= x^n <= 10^4
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/powx-n
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public double myPow1(double x, int n) { // 暴力 & 超时
    if (x == 1 || n == 0) {
      return 1;
    }
    double result = 1;
    long len = Math.abs((long)n);
    for (int i = 0; i < len; i++) {
      if (n > 0) {
        result *= x;
      } else {
        result /= x;
      }
    }
    return result;
  }

  public double myPow2(double x, int n) {
    return n > 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
  }

  public double quickMul(double x, long N) {
    if (N == 0) {
      return 1.0;
    }
    double y = quickMul(x, N / 2);
    return N % 2 == 0 ? y * y : y * y * x;
  }

//  public double myPow(double x, int n) {
//    long N = n;
//    return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
//  }
//
//  public double quickMul(double x, long N) {
//    double ans = 1.0;
//    // 贡献的初始值为 x
//    double x_contribute = x;
//    // 在对 N 进行二进制拆分的同时计算答案
//    while (N > 0) {
//      if (N % 2 == 1) {
//        // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
//        ans *= x_contribute;
//      }
//      // 将贡献不断地平方
//      x_contribute *= x_contribute;
//      // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
//      N /= 2;
//    }
//    return ans;
//  }
}
