package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/8/16
 * Desc:
 */
public class Offer50 {
  /**
   * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
   * 示例:
   *
   * s = "abaccdeff"
   * 返回 "b"
   *
   * s = ""
   * 返回 " "
   *
   * 限制：
   * 0 <= s 的长度 <= 50000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public char firstUniqChar(String s) {
    HashMap<Character, Integer> map = new HashMap();
    int len = s.length();
    ArrayList<Character> list = new ArrayList();
    for (int i = 0; i < len; i++) {
      Integer count = map.getOrDefault(s.charAt(i), 0);
      count++;
      map.put(s.charAt(i), count);
      if (count < 2) {
        list.add(s.charAt(i));
      } else {
        list.remove((Character) s.charAt(i));
      }
    }
    char result = ' ';
    if (list.size() != 0) {
      result = list.get(0);
    }
    return result;
  }
}
