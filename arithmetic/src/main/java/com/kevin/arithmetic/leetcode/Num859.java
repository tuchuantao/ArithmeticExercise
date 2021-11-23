package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/11/23
 * Desc: 亲密字符串
 */
public class Num859 {
  /**
   * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回true；否则返回 false 。
   * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
   * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
   *
   * 示例 1：
   * 输入：s = "ab", goal = "ba"
   * 输出：true
   * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
   *
   * 示例 2：
   * 输入：s = "ab", goal = "ab"
   * 输出：false
   * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
   *
   * 示例 3：
   * 输入：s = "aa", goal = "aa"
   * 输出：true
   * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
   *
   * 示例 4：
   * 输入：s = "aaaaaaabc", goal = "aaaaaaacb"
   * 输出：true
   *
   * 提示：
   * 1 <= s.length, goal.length <= 2 * 10^4
   * s 和 goal 由小写英文字母组成
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/buddy-strings
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean buddyStrings(String s, String goal) {
    int len = s.length();
    if (len <= 1 || len != goal.length()) {
      return false;
    }
    if (s.equals(goal)) {
      int[] count = new int[26];
      for (int i = 0; i < len; i++) {
        int index = s.charAt(i) - 'a';
        if (count[index] == 1) {
          return true;
        }
        count[index] = 1;
      }
    } else {
      ArrayList<Integer> list = new ArrayList();
      for (int i = 0; i < len; i++) {
        if (s.charAt(i) != goal.charAt(i)) {
          list.add(i);
        }
      }
      if (list.size() == 2) {
        return s.charAt(list.get(0)) == goal.charAt(list.get(1)) && s.charAt(list.get(1)) == goal.charAt(list.get(0));
      }
    }
    return false;
  }
}
