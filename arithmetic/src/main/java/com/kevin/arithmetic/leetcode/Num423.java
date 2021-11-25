package com.kevin.arithmetic.leetcode;

import java.util.HashMap;

/**
 * Created by tuchuantao on 2021/11/24
 * Desc: 从英文中重建数字
 */
public class Num423 {
  /**
   * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
   *
   * 示例 1：
   * 输入：s = "owoztneoer"
   * 输出："012"
   *
   * 示例 2：
   * 输入：s = "fviefuro"
   * 输出："45"
   * 
   * 提示：
   * 1 <= s.length <= 10^5
   * s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
   * s 保证是一个符合题目要求的字符串
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/reconstruct-original-digits-from-english
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  // zero
  // one
  // two
  // three
  // four
  // five
  // six
  // seven
  // eight
  // nine
  public String originalDigits(String s) {
    HashMap<Character, Integer> map = new HashMap();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      int count = map.getOrDefault(s.charAt(i), 0);
      count++;
      map.put(s.charAt(i), count);
    }

    int[] cnt = new int[10];
    cnt[0] = map.getOrDefault('z', 0);
    cnt[2] = map.getOrDefault('w', 0);
    cnt[4] = map.getOrDefault('u', 0);
    cnt[6] = map.getOrDefault('x', 0);
    cnt[8] = map.getOrDefault('g', 0);

    cnt[3] = map.getOrDefault('h', 0) - cnt[8];
    cnt[5] = map.getOrDefault('f', 0) - cnt[4];
    cnt[7] = map.getOrDefault('s', 0) - cnt[6];

    cnt[1] = map.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];
    cnt[9] = map.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

    StringBuffer ans = new StringBuffer();
    for (int i = 0; i < 10; ++i) {
      for (int j = 0; j < cnt[i]; ++j) {
        ans.append(i);
      }
    }
    return ans.toString();
  }
}
