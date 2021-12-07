
package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/12
 * Desc:
 */
public class Num647 {
  /**
   * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
   * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
   *
   * 示例 1：
   * 输入："abc"
   * 输出：3
   * 解释：三个回文子串: "a", "b", "c"
   *
   * 示例 2：
   * 输入："aaa"
   * 输出：6
   * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
   *
   * 提示：
   * 输入的字符串长度不会超过 1000 。
   */
  public int countSubstrings11(String s) { // 暴力解法
    int len = s.length();
    int count = len;
    for (int i = 2; i <= len; i++) {
      for (int j = 0; j <= len - i; j++) {
        int left = j;
        int right = j + i - 1;
        while (left < right) {
          if (s.charAt(left) != s.charAt(right)) {
            break;
          }
          left++;
          right--;
        }
        if (left >= right) {
          count++;
        }
      }
    }
    return count;
  }

  public int countSubstrings22(String s) { // 中心拓展
    int n = s.length(), ans = 0;
    for (int i = 0; i < 2 * n - 1; ++i) { // 2 * n - 1
      int l = i / 2, r = i / 2 + i % 2;
      while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
        --l;
        ++r;
        ++ans;
      }
    }
    return ans;
  }

  public int countSubstrings(String s) { // 动态规划
    int length = s.length();
    boolean[][] dp = new boolean[length][length];
    int count = 0;//回文串的数量
    for (int j = 0; j < length; j++) {
      for (int i = 0; i <= j; i++) {
        //如果i和j指向的字符不一样，那么dp[i][j]就
        //不能构成回文字符串
        if (s.charAt(i) != s.charAt(j))
          continue;
        dp[i][j] = j - i <= 2 || dp[i + 1][j - 1]; // j - i <= 2  个数为1时，肯定是回文，个数为2时，上面已经判断相等
        //如果从i到j能构成回文串，count就加1
        if (dp[i][j])
          count++;
      }
    }
    return count;
  }

}
