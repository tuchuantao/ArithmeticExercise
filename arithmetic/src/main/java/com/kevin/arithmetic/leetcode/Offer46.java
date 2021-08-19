package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/19
 * Desc:
 */
public class Offer46 {
  /**
   * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 
   * “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
   *
   * 示例 1:
   * 输入: 12258
   * 输出: 5
   * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
   * 
   * 提示：
   * 0 <= num < 2^31
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int translateNum(int num) { // 动态规划
    String numStr = String.valueOf(num);
    int len = numStr.length();
    if (len <= 1) {
      return len;
    }
    int[] dp = new int[len];
    dp[0] = 1;
    for (int i = 1; i < len; i++) {
      if (numStr.charAt(i - 1) == '1' || (numStr.charAt(i - 1) == '2' &&  numStr.charAt(i) < '6')) {
        dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1);
      } else {
        dp[i] = dp[i - 1];
      }
    }
    return dp[len - 1];
  }
}
