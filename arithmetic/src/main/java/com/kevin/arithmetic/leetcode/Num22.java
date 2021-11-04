package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/11/4
 * Desc: 括号生成
 */
public class Num22 {
  /**
   * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
   * 有效括号组合需满足：左括号必须以正确的顺序闭合。
   *
   * 示例 1：
   * 输入：n = 3
   * 输出：["((()))","(()())","(())()","()(())","()()()"]
   *
   * 示例 2：
   * 输入：n = 1
   * 输出：["()"]
   *
   * 提示：
   * 1 <= n <= 8
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/generate-parentheses
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<String> generateParenthesis(int n) {
    List<String> list = new ArrayList();
    realGenerate(list, new StringBuilder().append("("), 1, 0, n);
    return list;
  }

  public void realGenerate(List<String> list, StringBuilder builder, int left, int right, int target) {
    if (left == right && left == target) {
      list.add(builder.toString());
      return;
    }
    if (left == right) {
      builder.append("(");
      realGenerate(list, builder, left + 1, right, target);
    } else {
      StringBuilder builder1 = new StringBuilder(builder.toString());
      builder1.append(")");
      realGenerate(list, builder1, left, right + 1, target);

      if (left < target) {
        StringBuilder builder2 = new StringBuilder(builder.toString());
        builder2.append("(");
        realGenerate(list, builder2, left + 1, right, target);
      }
    }
  }

  public List<String> generateParenthesis2(int n) {
    List<String> ans = new ArrayList<String>();
    backtrack(ans, new StringBuilder(), 0, 0, n);
    return ans;
  }

  public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
    if (cur.length() == max * 2) {
      ans.add(cur.toString());
      return;
    }
    if (open < max) {
      cur.append('(');
      backtrack(ans, cur, open + 1, close, max);
      cur.deleteCharAt(cur.length() - 1);
    }
    if (close < open) {
      cur.append(')');
      backtrack(ans, cur, open, close + 1, max);
      cur.deleteCharAt(cur.length() - 1);
    }
  }
}
