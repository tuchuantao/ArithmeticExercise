package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/12/28
 * Desc: 每个元音包含偶数次的最长子字符串
 */
public class Num1371 {
  /**
   * 给你一个字符串s，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
   *
   * 示例 1：
   * 输入：s = "eleetminicoworoep"
   * 输出：13
   * 解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o各 2 个，以及 0 个 a，u 。
   *
   * 示例 2：
   * 输入：s = "leetcodeisgreat"
   * 输出：5
   * 解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
   *
   * 示例 3：
   * 输入：s = "bcbcbc"
   * 输出：6
   * 解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
   *
   * 提示：
   * 1 <= s.length <= 5 x 10^5
   * s只包含小写英文字母。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findTheLongestSubstring(String s) {
    Map<Integer, Integer> map = new HashMap();
    map.put(0, -1);
    int maxLen = 0;
    int len = s.length();
    char tempChar;
    int sum = 0;
    for (int i = 0; i < len; i++) {
      tempChar = s.charAt(i);
      switch (tempChar) {
        case 'a': {
          sum ^= 1;
        }
        case 'e': {
          sum ^= 2;
        }
        case 'i': {
          sum ^= 4;
        }
        case 'o': {
          sum ^= 8;
        }
        case 'u': {
          sum ^= 16;
        }
      }
      Integer lastIndex = map.get(sum);
      if (lastIndex == null) {
        map.put(sum, i);
      } else {
        maxLen = Math.max(maxLen, i - lastIndex);
      }
    }
    return maxLen;
  }
}
