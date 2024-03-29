package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/8/19
 * Desc: 无重复字符的最长子串
 */
public class Num3AndOffer48 {
  /**
   * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
   *
   * 示例1:
   * 输入: "abcabcbb"
   * 输出: 3 
   * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
   *
   * 示例 2:
   * 输入: "bbbbb"
   * 输出: 1
   * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
   *
   * 示例 3:
   * 输入: "pwwkew"
   * 输出: 3
   * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
   *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
   * 
   * 提示：
   * s.length <= 40000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int lengthOfLongestSubstring1(String s) {
    Map<Character, Integer> map = new HashMap();
    int left = 0;
    int right = 0;
    int maxSubLen = 0; // ""
    int len = s.length();
    while (right < len) {
      int index = map.getOrDefault(s.charAt(right), -1);
      if (left <= index) {
        maxSubLen = Math.max(maxSubLen, right - left);
        left = index + 1;
      }
      map.put(s.charAt(right), right);
      right++;
    }
    maxSubLen = Math.max(maxSubLen, right - left);
    return maxSubLen;
  }

  // 不能使用，因为字符不确定范围  "aabaab!bb"
  public int lengthOfLongestSubstring(String s) { // 双指针 + 位运算
    int len = s.length();
    if (len <= 1) {
      return len;
    }
    int maxLen = 1;
    int left = 0;
    int right = 0;
    int subNum = 1 << (s.charAt(0) - 'a');
    while (++right < len) {
      int num = 1 << (s.charAt(right) - 'a');
      if ((subNum & num) != 0) {
        maxLen = Math.max(maxLen, right - left);
        while (true) {
          if (s.charAt(left) == s.charAt(right)) {
            left++;
            break;
          } else {
            subNum ^= (1 << (s.charAt(left) - 'a'));
            left++;
          }
        }
      } else {
        subNum ^= num;
      }
    }
    maxLen = Math.max(maxLen, right - left);
    return maxLen;
  }
}
