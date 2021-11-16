package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/11/16
 * Desc: 字母异位词分组
 */
public class Num49 {
  /**
   * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
   * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
   *
   * 示例 1:
   * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
   * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
   *
   * 示例 2:
   * 输入: strs = [""]
   * 输出: [[""]]
   *
   * 示例 3:
   * 输入: strs = ["a"]
   * 输出: [["a"]]
   *
   * 提示：
   * 1 <= strs.length <= 10^4
   * 0 <= strs[i].length <= 100
   * strs[i]仅包含小写字母
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/group-anagrams
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap();
    int len = strs.length;
    char[] arr;
    for (int i = 0; i < len; i++) {
      arr = new char[26];
      int strLen = strs[i].length();
      for (int j = 0; j < strLen; j++) {
        arr[strs[i].charAt(j) - 'a'] += 1;
      }
      String key = strLen + String.valueOf(arr);
      List<String> list = map.getOrDefault(key, new ArrayList<String>());
      list.add(strs[i]);
      map.put(key, list);
    }
    List<List<String>> list = new ArrayList();
    if (!map.isEmpty()) {
      for (List<String> items: map.values()) {
        list.add(items);
      }
    }
    return list;
  }
}
