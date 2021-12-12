package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tuchuantao on 2021/12/9
 * Desc: 找到字符串中所有字母异位词
 */
public class Num438 {
  /**
   * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
   * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
   *
   * 示例1:
   * 输入: s = "cbaebabacd", p = "abc"
   * 输出: [0,6]
   * 解释:
   * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
   * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
   *
   * 示例 2:
   * 输入: s = "abab", p = "ab"
   * 输出: [0,1,2]
   * 解释:
   * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
   * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
   * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
   *
   * 提示:
   * 1 <= s.length, p.length <= 3 * 10^4
   * s和p仅包含小写字母
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<Integer> findAnagrams(String s, String p) {
    int pLen = p.length();
    int sLen = s.length();
    if (sLen < pLen) {
      return new ArrayList<Integer>();
    }

    int[] pArr = new int[26];
    for (int i = 0; i < pLen; i++) {
      pArr[p.charAt(i) - 'a'] += 1;
    }

    List<Integer> list = new ArrayList();
    int startIndex = 0;
    int[] sArr = new int[26];
    for (int i = 0; i < sLen; i++) {
      if (pArr[s.charAt(i) - 'a'] == 0) {
        startIndex = i + 1;
        Arrays.fill(sArr, 0); // 注意状态重置
      } else {
        sArr[s.charAt(i) - 'a'] += 1;
        if (i - startIndex + 1 == pLen) {
          boolean isEquals = true;
          for (int j = 0; j < 26; j++) {
            if (pArr[j] != sArr[j]) {
              isEquals = false;
            }
          }
          if (isEquals) {
            list.add(startIndex);
          }
          sArr[s.charAt(startIndex) - 'a'] -= 1;
          startIndex++;
        }
      }
    }
    return list;
  }

  public static void main(String[] args) {
    new Num438().findAnagrams("cbaebabacd", "abc");
  }
}
