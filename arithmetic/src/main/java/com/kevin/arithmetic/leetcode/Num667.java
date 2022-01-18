package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by tuchuantao on 2022/1/17
 * Desc: 键值映射（单词之和）
 */
public class Num667 {
  /**
   * 实现一个 MapSum 类，支持两个方法，insert和sum：
   *
   * MapSum() 初始化 MapSum 对象
   * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key
   * 已经存在，那么原来的键值对将被替代成新的键值对。
   * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
   *
   * 示例：
   * 输入：
   * ["MapSum", "insert", "sum", "insert", "sum"]
   * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
   * 输出：
   * [null, null, 3, null, 5]
   *
   * 解释：
   * MapSum mapSum = new MapSum();
   * mapSum.insert("apple", 3);
   * mapSum.sum("ap");           // return 3 (apple = 3)
   * mapSum.insert("app", 2);
   * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
   *
   * 提示：
   * 1 <= key.length, prefix.length <= 50
   * key 和 prefix 仅由小写英文字母组成
   * 1 <= val <= 1000
   * 最多调用 50 次 insert 和 sum
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/map-sum-pairs
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  class MapSum { // 字典树

    private Node header;

    public MapSum() {
      header = new Node();
    }

    public void insert(String key, int val) {
      Node cur = null;
      Node lastNode = header;
      for (char c : key.toCharArray()) {
        cur = lastNode.childMap.get(c);
        if (cur == null) {
          cur = new Node();
        }
        lastNode.childMap.put(c, cur);
        lastNode = cur;
      }
      cur.val = val;
    }

    public int sum(String prefix) {
      Node cur = null;
      Node lastNode = header;
      for (char c : prefix.toCharArray()) {
        cur = lastNode.childMap.get(c);
        if (cur == null) {
          break;
        }
        lastNode = cur;
      }
      if (cur == null) {
        return 0;
      }
      Deque<Node> deque = new LinkedList();
      deque.addLast(cur);
      int sum = 0;
      while (!deque.isEmpty()) {
        Node node = deque.removeFirst();
        sum += node.val;
        if (!node.childMap.isEmpty()) {
          Iterator<Node> iterator = node.childMap.values().iterator();
          while (iterator.hasNext()) {
            deque.addLast(iterator.next());
          }
        }
      }
      return sum;
    }
  }

  class Node {
    Map<Character, Node> childMap = new HashMap();
    int val = 0;
  }

  //class MapSum { // 前缀和
  //    Map<String, Integer> map;
  //    Map<String, Integer> prefixmap;
  //
  //    public MapSum() {
  //        map = new HashMap<>();
  //        prefixmap = new HashMap<>();
  //    }
  //
  //    public void insert(String key, int val) {
  //        int delta = val - map.getOrDefault(key, 0);
  //        map.put(key, val);
  //        for (int i = 1; i <= key.length(); ++i) {
  //            String currprefix = key.substring(0, i);
  //            prefixmap.put(currprefix, prefixmap.getOrDefault(currprefix, 0) + delta);
  //        }
  //    }
  //
  //    public int sum(String prefix) {
  //        return prefixmap.getOrDefault(prefix, 0);
  //    }
  //}
}
