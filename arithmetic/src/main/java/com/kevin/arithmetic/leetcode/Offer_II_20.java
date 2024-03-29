package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/12/21
 * Desc: 回文子字符串的个数
 */
public class Offer_II_20 {
  /**
   * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
   * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
   *
   * 示例 1：
   * 输入：s = "abc"
   * 输出：3
   * 解释：三个回文子串: "a", "b", "c"
   *
   * 示例 2：
   * 输入：s = "aaa"
   * 输出：6
   * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
   *
   * 提示：
   * 1 <= s.length <= 1000
   * s 由小写英文字母组成
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/a7VOhD
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int countSubstrings1(String s) { // 中心拓展
    int len = s.length();
    int ans = len;
    for (int i = 0; i < len; i++) {
      // 以当前位置为中心
      int left = i - 1;
      int right = i + 1;
      while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
        ans++;
        left--;
        right++;
      }

      // 以当前位置和下一位置为中心
      left = i;
      right = i + 1;
      while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
        ans++;
        left--;
        right++;
      }
    }
    return ans;
  }

  public int countSubstrings(String s) { // Manacher 算法
    int n = s.length();
    StringBuffer t = new StringBuffer("$#");
    for (int i = 0; i < n; ++i) {
      t.append(s.charAt(i));
      t.append('#');
    }
    n = t.length();
    t.append('!');

    int[] f = new int[n];
    int iMax = 0, rMax = 0, ans = 0;
    for (int i = 1; i < n; ++i) {
      // 初始化 f[i]
      f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
      // 中心拓展
      while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
        ++f[i];
      }
      // 动态维护 iMax 和 rMax
      if (i + f[i] - 1 > rMax) {
        iMax = i;
        rMax = i + f[i] - 1;
      }
      // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
      ans += f[i] / 2;
    }

    return ans;
  }
}
