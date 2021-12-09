package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/12/9
 * Desc: 有效的字母异位词
 */
public class Num242 {
  /**
   * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
   * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
   *
   * 示例1:
   * 输入: s = "anagram", t = "nagaram"
   * 输出: true
   *
   * 示例 2:
   * 输入: s = "rat", t = "car"
   * 输出: false
   * 
   * 提示:
   *
   * 1 <= s.length, t.length <= 5 * 10^4
   * s 和 t仅包含小写字母
   * 
   *
   * 进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/valid-anagram
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isAnagram(String s, String t) {
    int sourceLen = s.length();
    int targetLen = t.length();
    if (sourceLen != targetLen) {
      return false;
    }
    int[] arr = new int[32];
    for (int i = 0; i < sourceLen; i++) {
      arr[s.charAt(i) - 'a'] += 1;
      arr[t.charAt(i) - 'a'] -= 1;
    }
    for (int i = 0; i < 32; i++) {
      if (arr[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
