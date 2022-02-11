package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by tuchuantao on 2022/2/11
 * Desc: 单词替换
 */
public class Num648 {
  /**
   * 在英语中，我们有一个叫做词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为继承词(successor)。
   * 例如，词根an，跟随着单词other(其他)，可以形成新的单词another(另一个)。
   * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子sentence。
   * 你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
   * 你需要输出替换之后的句子。
   *
   * 示例 1：
   * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
   * 输出："the cat was rat by the bat"
   *
   * 示例 2：
   * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
   * 输出："a a b c"
   *
   * 提示：
   * 1 <= dictionary.length<= 1000
   * 1 <= dictionary[i].length <= 100
   * dictionary[i]仅由小写字母组成。
   * 1 <= sentence.length <= 10^6
   * sentence仅由小写字母和空格组成。
   * sentence 中单词的总量在范围 [1, 1000] 内。
   * sentence 中每个单词的长度在范围 [1, 1000] 内。
   * sentence 中单词之间由一个空格隔开。
   * sentence没有前导或尾随空格。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/replace-words
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String replaceWords1(List<String> dictionary, String sentence) {
    // 1、构建字典树
    Node header = new Node();
    for (String str : dictionary) {
      Node curNode = header;
      for (char c : str.toCharArray()) {
        Node child = curNode.childMap.get(c);
        if (child == null) {
          child = new Node(c);
          curNode.childMap.put(c, child);
        }
        curNode = child;
      }
      curNode.isEnd = true;
    }

    // 2、查找
    String[] arr = sentence.split(" ");
    StringBuilder builder = new StringBuilder();
    for (String str : arr) {
      Node curNode = header;
      int i = 0;
      int len = str.length();
      for (; i < len; i++) {
        Node node = curNode.childMap.get(str.charAt(i));
        if (node == null) {
          i = len;
          break;
        } else if (node.isEnd) {
          i = i + 1;
          break;
        }
        curNode = node;
      }
      builder.append(str.substring(0, i)).append(" ");
    }
    return builder.delete(builder.length() - 1,builder.length()).toString();
  }

  private class Node {
    char value;
    boolean isEnd;
    Map<Character, Node> childMap;

    public Node() {
      this('0');
    }

    public Node(char value) {
      childMap = new HashMap();
      this.value = value;
    }
  }

  public String replaceWords(List<String> roots, String sentence) { // 前缀哈希
    Set<String> rootset = new HashSet();
    for (String root: roots) rootset.add(root);

    StringBuilder ans = new StringBuilder();
    for (String word: sentence.split("\\s+")) {
      String prefix = "";
      for (int i = 1; i <= word.length(); ++i) {
        prefix = word.substring(0, i);
        if (rootset.contains(prefix)) break;
      }
      if (ans.length() > 0) ans.append(" ");
      ans.append(prefix);
    }
    return ans.toString();
  }

}
