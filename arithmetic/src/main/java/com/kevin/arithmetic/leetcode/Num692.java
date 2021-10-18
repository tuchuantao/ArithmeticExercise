package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by tuchuantao on 2021/10/18
 * Desc: 前K个高频单词
 */
public class Num692 {
  /**
   * 给一非空的单词列表，返回前k个出现次数最多的单词。
   * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
   *
   * 示例 1：
   * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
   * 输出: ["i", "love"]
   * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
   *     注意，按字母顺序 "i" 在 "love" 之前。
   *
   * 示例 2：
   * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
   * 输出: ["the", "is", "sunny", "day"]
   * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
   *     出现次数依次为 4, 3, 2 和 1 次。
   *
   * 注意：
   * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
   * 输入的单词均由小写字母组成。
   *
   * 扩展练习：
   * 尝试以O(n log k) 时间复杂度和O(n) 空间复杂度解决。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/top-k-frequent-words
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<String> topKFrequent2(String[] words, int k) { // map + 排序
    Map<String, Integer> cnt = new HashMap<String, Integer>();
    for (String word : words) {
      cnt.put(word, cnt.getOrDefault(word, 0) + 1);
    }
    List<String> rec = new ArrayList<String>();
    for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
      rec.add(entry.getKey());
    }
    Collections.sort(rec, new Comparator<String>() {
      public int compare(String word1, String word2) {
        return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
      }
    });
    return rec.subList(0, k);
  }

  public List<String> topKFrequent1(String[] words, int k) { // 优先队列
    PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[1] - o1[1];
      }
    });
    Arrays.sort(words);
    int len = words.length;
    int lastIndex = 0;
    for (int i = 1; i < len; i++) {
      if (words[i] != words[lastIndex]) {
        queue.offer(new int[]{lastIndex, i - lastIndex});
        if (i == len - 1) {
          queue.offer(new int[]{i, 1});
        }
        lastIndex = i;
      }
    }
    if (lastIndex < len - 1) {
      queue.offer(new int[]{lastIndex, len - 1 - lastIndex});
    }
    List<String> list = new ArrayList(k);
    int size = queue.size();
    for (int i = 0; i < k && i < size; i++) {
      list.add(words[queue.poll()[0]]);
    }
    return list;
  }

  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> cnt = new HashMap<String, Integer>();
    for (String word : words) {
      cnt.put(word, cnt.getOrDefault(word, 0) + 1);
    }
    PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
        return entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue();
      }
    });
    for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
      pq.offer(entry);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    List<String> ret = new ArrayList<String>();
    while (!pq.isEmpty()) {
      ret.add(pq.poll().getKey());
    }
    Collections.reverse(ret);
    return ret;
  }

  public static void main(String[] args) {
    new Num692().topKFrequent(new String[]{"yes","lint","code","yes","code","baby","you","baby","chrome","safari","lint","code","body","lint","code"}, 3);
  }
}
