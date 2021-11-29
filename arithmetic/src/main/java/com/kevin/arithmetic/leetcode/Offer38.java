package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/11/29
 * Desc: 字符串的排列
 */
public class Offer38 {
  /**
   * 输入一个字符串，打印出该字符串中字符的所有排列。
   * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
   *
   * 示例:
   * 输入：s = "abc"
   * 输出：["abc","acb","bac","bca","cab","cba"]
   *
   * 限制：
   * 1 <= s 的长度 <= 8
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String[] permutation(String s) { // 注意原字符串有重复字符
    int len = s.length();
    if (len == 1) {
      return new String[]{s};
    }
    Deque<List<Character>> deque = new LinkedList();
    List<Character> list = new ArrayList();
    list.add(s.charAt(0));
    deque.addLast(list);
    for (int i = 1; i < len; i++) {
      int dequeSize = deque.size();
      for (int j = 0; j < dequeSize; j++) {
        list = deque.removeFirst();
        int itemSize = list.size();
        for (int k = 0; k < itemSize + 1; k++) {
          List<Character> newItem = new ArrayList<>(list);
          newItem.add(k, s.charAt(i));
          deque.addLast(newItem);
        }
      }
    }

    String[] ansArr = new String[deque.size()];
    int index = 0;
    HashMap<String, Byte> map = new HashMap();
    while (!deque.isEmpty()) {
      list = deque.removeFirst();
      StringBuilder builder = new StringBuilder();
      for (char c : list) {
        builder.append(c);
      }
      String key = builder.toString();
      if (map.get(key) == null) {
        map.put(key, Byte.MIN_VALUE);
        ansArr[index] = key;
        index++;
      }
    }
    return Arrays.copyOf(ansArr, index);
  }
}
