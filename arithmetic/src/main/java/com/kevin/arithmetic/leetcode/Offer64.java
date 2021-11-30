package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/30
 * Desc: 求1+2+…+n
 */
public class Offer64 {
  /**
   * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
   *
   * 示例 1：
   * 输入: n = 3
   * 输出:6
   *
   * 示例 2：
   * 输入: n = 9
   * 输出:45
   * 
   * 限制：
   * 1 <= n<= 10000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int sumNums(int n) { // 递归
    boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
    return n;
  }

  // 快速乘
  int quickMulti(int A, int B) {
    int ans = 0;
    for ( ; B > 0; B >>= 1) {
      if ((B & 1) == 1) {
        ans += A;
      }
      A <<= 1;
    }
    return ans;
  }
}
