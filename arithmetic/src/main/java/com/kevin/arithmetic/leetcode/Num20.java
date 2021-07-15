package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tuchuantao on 2021/7/15
 * Desc:
 */
public class Num20 {

  /**
   * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
   *
   * 有效字符串需满足：
   *
   * 左括号必须用相同类型的右括号闭合。
   * 左括号必须以正确的顺序闭合。
   * 
   *
   * 示例 1：
   *
   * 输入：s = "()"
   * 输出：true
   * 示例2：
   *
   * 输入：s = "()[]{}"
   * 输出：true
   * 示例3：
   *
   * 输入：s = "(]"
   * 输出：false
   * 示例4：
   *
   * 输入：s = "([)]"
   * 输出：false
   * 示例5：
   *
   * 输入：s = "{[]}"
   * 输出：true
   * 
   *
   * 提示：
   *
   * 1 <= s.length <= 104
   * s 仅由括号 '()[]{}' 组成
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/valid-parentheses
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isValid(String s) {
    int len = s.length();
    if (len % 2 == 1) {
      return false;
    }

    HashMap<Character, Character> map = new HashMap();
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');

    Deque<Character> stack = new LinkedList<Character>();
    char[] arr = s.toCharArray();
    for (int i = 0; i < len; i++) {
      if (map.containsKey(arr[i])) {
        if (stack.isEmpty() || stack.pop() != map.get(arr[i])) {
          return false;
        }
      } else {
        stack.push(arr[i]);
      }
    }
    return stack.isEmpty();
  }
}
