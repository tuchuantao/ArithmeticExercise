package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/9/9
 * Desc:
 */
public class Num208 {
  /**
   * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
   * 请你实现 Trie 类：
   * Trie() 初始化前缀树对象。
   * void insert(String word) 向前缀树中插入字符串 word 。
   * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
   * boolean startsWith(String prefix) 如果之前已经插入的字符串word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
   * 
   * 示例：
   * 输入
   * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
   * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
   * 输出
   * [null, null, true, false, true, null, true]
   *
   * 解释
   * Trie trie = new Trie();
   * trie.insert("apple");
   * trie.search("apple");   // 返回 True
   * trie.search("app");     // 返回 False
   * trie.startsWith("app"); // 返回 True
   * trie.insert("app");
   * trie.search("app");     // 返回 True
   * 
   * 提示：
   * 1 <= word.length, prefix.length <= 2000
   * word 和 prefix 仅由小写英文字母组成
   * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public class Trie {

    private Node header;

    /** Initialize your data structure here. */
    public Trie() {
      header = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
      char[] arr = word.toCharArray();
      int len = arr.length;
      Node node = header;
      Node child;
      for(int i = 0; i < len; i++) {
        child = node.childs[arr[i] - 'a'];
        if (child == null) {
          child = new Node(arr[i]);
          node.childs[arr[i] - 'a'] = child;
        }
        node = child;
      }
      node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      Node node = findPrefix(word);
      return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      return findPrefix(prefix) != null;
    }

    private Node findPrefix(String prefix) {
      char[] arr = prefix.toCharArray();
      int len = arr.length;
      int index = 0;
      Node node = header;
      for (; index < len; index++) {
        node = node.childs[arr[index] - 'a'];
        if (node == null) {
          return null;
        }
      }
      return node;
    }
  }

  class Node {

    public char val;
    public Node[] childs = new Node[26];
    public boolean isEnd;

    public Node() {}

    public Node(char val) {
      this.val = val;
    }
  }
}
