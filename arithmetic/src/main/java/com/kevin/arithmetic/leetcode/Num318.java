package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/17
 * Desc: 最大单词长度乘积
 */
public class Num318 {
  /**
   * 给定一个字符串数组words，找到length(word[i]) * length(word[j])
   * 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
   *
   * 示例1:
   * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
   * 输出: 16 
   * 解释: 这两个单词为 "abcw", "xtfn"。
   *
   * 示例 2:
   * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
   * 输出: 4 
   * 解释: 这两个单词为 "ab", "cd"。
   *
   * 示例 3:
   * 输入: ["a","aa","aaa","aaaa"]
   * 输出: 0 
   * 解释: 不存在这样的两个单词。
   *
   * 提示：
   * 2 <= words.length <= 1000
   * 1 <= words[i].length <= 1000
   * words[i]仅包含小写字母
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int maxProduct(String[] words) {
    int len = words.length;
    int[] arr = new int[len];
    for (int i = 0; i < len; i++) {
      int result = 0;
      int strLen = words[i].length();
      for (int j = 0; j < strLen; j++) {
        int num = words[i].charAt(j) - '0';
        result |= (1 << num);
      }
      arr[i] = result;
    }

    int max = 0;
    for (int i = 0; i < len; i++) {
      for (int j = i; j < len; j++) {
        if ((arr[i] & arr[j]) == 0) {
          max = Math.max(max, words[i].length() * words[j].length());
        }
      }
    }
    return max;
  }
}
