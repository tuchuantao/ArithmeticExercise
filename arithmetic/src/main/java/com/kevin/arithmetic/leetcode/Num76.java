package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by tuchuantao on 2021/12/13
 * Desc: 最小覆盖子串
 */
public class Num76 {
  /**
   * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
   *
   * 注意：
   * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
   * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
   *
   * 示例 1：
   * 输入：s = "ADOBECODEBANC", t = "ABC"
   * 输出："BANC"
   *
   * 示例 2：
   * 输入：s = "a", t = "a"
   * 输出："a"
   *
   * 示例 3:
   * 输入: s = "a", t = "aa"
   * 输出: ""
   * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
   * 因此没有符合条件的子字符串，返回空字符串。
   *
   * 提示：
   * 1 <= s.length, t.length <= 10^5
   * s 和 t 由英文字母组成
   *
   * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/minimum-window-substring
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String minWindow(String source, String target) {
    int len = source.length();
    int targetLen = target.length();
    if (targetLen > len) {
      return "";
    }
    Map<Character, Integer> map = new HashMap();
    for (int i = 0; i < targetLen; i++) {
      map.put(target.charAt(i), map.getOrDefault(target.charAt(i), 0) + 1);
    }
    int startIndex = 0;
    int minLen = Integer.MAX_VALUE;
    int minStartIndex = -1;
    int diff = targetLen;
    for (int i = 0; i < len; i++) {
      Integer count = map.get(source.charAt(i));
      if (count != null) {
        count--;
        map.put(source.charAt(i), count);
        if (count >= 0) {
          diff--;
          if (diff == 0) {
            while (diff == 0) {
              Integer tempCount = map.get(source.charAt(startIndex));
              if (tempCount != null) {
                tempCount++;
                map.put(source.charAt(startIndex), tempCount);
                if (tempCount > 0) {
                  diff++;
                }
              }
              startIndex++;
            }
            int tempMin = i - startIndex + 2;
            if (minLen > tempMin) {
              minLen = tempMin;
              minStartIndex = startIndex - 1;
            }
          }
        }
      }
    }
    return minStartIndex > -1 ? source.substring(minStartIndex, minStartIndex + minLen) : "";
  }

}
