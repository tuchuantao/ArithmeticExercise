package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/12/6
 * Desc: 字符串的排列
 */
public class Num567 {
  /**
   * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
   * 换句话说，s1 的排列之一是 s2 的 子串 。
   *
   * 示例 1：
   * 输入：s1 = "ab" s2 = "eidbaooo"
   * 输出：true
   * 解释：s2 包含 s1 的排列之一 ("ba").
   *
   * 示例 2：
   * 输入：s1= "ab" s2 = "eidboaoo"
   * 输出：false
   *
   * 提示：
   * 1 <= s1.length, s2.length <= 10^4
   * s1 和 s2 仅包含小写字母
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/permutation-in-string
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean checkInclusion(String target, String source) {
    int len = source.length();
    int targetLen = target.length();
    if (targetLen > len) {
      return false;
    }
    Map<Character, Integer> map = new HashMap();
    for (int i = 0; i < targetLen; i++) {
      map.put(target.charAt(i), map.getOrDefault(target.charAt(i), 0) + 1);
    }
    int startIndex = 0;
    Map<Character, Integer> tempMap = new HashMap(map);
    for (int i = 0; i < len; i++) {
      if (tempMap.get(source.charAt(i)) == null) {
        tempMap = new HashMap(map);
        startIndex = i + 1;
      } else {
        int count = tempMap.get(source.charAt(i));
        tempMap.put(source.charAt(i), --count);
        while (tempMap.get(source.charAt(i)) < 0) {
          tempMap.put(source.charAt(startIndex), tempMap.get(source.charAt(startIndex)) + 1);
          startIndex++;
        }
        if (i - startIndex + 1 == targetLen) {
          return true;
        }
      }
    }
    return false;
  }
}
