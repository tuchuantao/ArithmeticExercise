package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/3
 * Desc:
 */
public class Num58 {
  /**
   * 给你一个字符串 s，由若干单词组成，单词之间用单个或多个连续的空格字符隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0。
   * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
   * <p>
   * 示例 1：
   * 输入：s = "Hello World"
   * 输出：5
   * <p>
   * 示例 2：
   * 输入：s = " "
   * 输出：0
   * <p>
   * 提示：
   * <p>
   * 1 <= s.length <= 10^4
   * s 仅有英文字母和空格 ' ' 组成
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/length-of-last-word
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int lengthOfLastWord11(String s) {
    s.trim();
    String[] arr = s.split(" ");
    int len = arr.length;
    int subLen = 0;
    for (int i = len - 1; i >= 0; i--) {
      subLen = arr[i].length();
      for (int j = 0; j < subLen; j++) {
        char charItem = arr[i].charAt(j);
        if (!((charItem >= 'a' && charItem <= 'z') || (charItem >= 'A' && charItem <= 'Z'))) { // 完全没必有，题目已经给出限定条件
          subLen = 0;
          break;
        }
      }
      if (subLen > 0) {
        break;
      }
    }
    return subLen;
  }

  public int lengthOfLastWord(String s) {
    int end = s.length() - 1;
    while (end >= 0 && s.charAt(end) == ' ') {
      end--;
    }
    if (end < 0) {
      return 0;
    }
    int start = end;
    while (start >= 0 && s.charAt(start) != ' ') {
      start--;
    }
    return end - start;
  }
}
