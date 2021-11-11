package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/4
 * Desc: 两数相除
 */
public class Num29 {
  /**
   * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
   * 返回被除数dividend除以除数divisor得到的商。
   * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
   *w
   * 示例1:
   * 输入: dividend = 10, divisor = 3
   * 输出: 3
   * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
   *
   * 示例2:
   * 输入: dividend = 7, divisor = -3
   * 输出: -2
   * 解释: 7/-3 = truncate(-2.33333..) = -2
   *
   * 提示：
   * 被除数和除数均为 32 位有符号整数。
   * 除数不为0。
   * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31− 1]。本题中，如果除法结果溢出，则返回 2^31− 1。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/divide-two-integers
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int divide1(int dividend, int divisor) {
    // 考虑被除数为最小值的情况
    if (dividend == Integer.MIN_VALUE) {
      if (divisor == 1) {
        return Integer.MIN_VALUE;
      }
      if (divisor == -1) {
        return Integer.MAX_VALUE;
      }
    }
    // 考虑除数为最小值的情况
    if (divisor == Integer.MIN_VALUE) {
      return dividend == Integer.MIN_VALUE ? 1 : 0;
    }
    // 考虑被除数为 0 的情况
    if (dividend == 0) {
      return 0;
    }
    boolean rev = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
    if (dividend > 0) dividend = -dividend;
    if (divisor > 0) divisor = -divisor;
    int ans = 0;
    while (dividend <= divisor){
      int c = divisor, d = -1;
      while (c >= dividend - c){
        c += c; d += d;
      }
      dividend -= c;
      ans += d;
    }
    return rev ? ans : -ans;
  }



  public int divide(int dividend, int divisor) {
    // 考虑被除数为最小值的情况
    if (dividend == Integer.MIN_VALUE) {
      if (divisor == 1) {
        return Integer.MIN_VALUE;
      }
      if (divisor == -1) {
        return Integer.MAX_VALUE;
      }
    }
    // 考虑除数为最小值的情况
    if (divisor == Integer.MIN_VALUE) {
      return dividend == Integer.MIN_VALUE ? 1 : 0;
    }
    // 考虑被除数为 0 的情况
    if (dividend == 0) {
      return 0;
    }

    // 一般情况，使用二分查找
    // 将所有的正数取相反数，这样就只需要考虑一种情况
    boolean rev = false;
    if (dividend > 0) {
      dividend = -dividend;
      rev = !rev;
    }
    if (divisor > 0) {
      divisor = -divisor;
      rev = !rev;
    }

    int left = 1, right = Integer.MAX_VALUE, ans = 0;
    while (left <= right) {
      // 注意溢出，并且不能使用除法
      int mid = left + ((right - left) >> 1);
      boolean check = quickAdd(divisor, mid, dividend);
      if (check) {
        ans = mid;
        // 注意溢出
        if (mid == Integer.MAX_VALUE) {
          break;
        }
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return rev ? -ans : ans;
  }

  // 快速乘
  public boolean quickAdd(int y, int z, int x) {
    // x 和 y 是负数，z 是正数
    // 需要判断 z * y >= x 是否成立
    int result = 0, add = y;
    while (z != 0) {
      if ((z & 1) != 0) {
        // 需要保证 result + add >= x
        if (result < x - add) {
          return false;
        }
        result += add;
      }
      if (z != 1) {
        // 需要保证 add + add >= x
        if (add < x - add) {
          return false;
        }
        add += add;
      }
      // 不能使用除法
      z >>= 1;
    }
    return true;
  }

}
