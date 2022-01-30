package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by tuchuantao on 2022/1/30
 * Desc: 两句话中的不常见单词
 */
public class Num884 {
  /**
   * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
   * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
   * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
   *
   * 示例 1：
   * 输入：s1 = "this apple is sweet", s2 = "this apple is sour"
   * 输出：["sweet","sour"]
   *
   * 示例 2：
   * 输入：s1 = "apple apple", s2 = "banana"
   * 输出：["banana"]
   *
   * 提示：
   * 1 <= s1.length, s2.length <= 200
   * s1 和 s2 由小写英文字母和空格组成
   * s1 和 s2 都不含前导或尾随空格
   * s1 和 s2 中的所有单词间均由单个空格分隔
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/uncommon-words-from-two-sentences
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String[] uncommonFromSentences(String s1, String s2) {
    HashMap<String, Integer> map = new HashMap();
    String[] strArr1 = s1.split(" ");
    String[] strArr2 = s2.split(" ");
    for (String str : strArr1) {
      int count = map.getOrDefault(str, 0);
      count++;
      map.put(str, count);
    }
    for (String str : strArr2) {
      int count = map.getOrDefault(str, 0);
      count++;
      map.put(str, count);
    }
    ArrayList<String> list = new ArrayList();
    Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, Integer> entry = iterator.next();
      if (entry.getValue() == 1) {
        list.add(entry.getKey());
      }
    }
    return list.toArray(new String[list.size()]);
  }
}
