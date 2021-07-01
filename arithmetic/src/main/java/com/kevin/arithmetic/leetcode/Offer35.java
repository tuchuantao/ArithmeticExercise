package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by tuchuantao on 2021/6/22
 * Desc: https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class Offer35 {

  /**
   * 输入一个字符串，打印出该字符串中字符的所有排列。
   * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
   *
   * 示例:
   *
   * 输入：s = "abc"
   * 输出：["abc","acb","bac","bca","cab","cba"]
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   * @param s
   * @return
   */
  public static String[] permutation(String s) {
    char[] chars = s.toCharArray();
    int len = chars.length;
    ArrayList<ArrayList<Character>> result = new ArrayList();
    for (int i = 0; i < len; i++) {
      if (result.size() > 0) {
        ArrayList<ArrayList<Character>> temp = new ArrayList(result);
        result.clear();
        for (ArrayList<Character> item: temp) {
          for (int j = 0; j <= i; j++) {
            ArrayList<Character> itemTemp = new ArrayList(item);
            itemTemp.add(j, chars[i]);
            result.add(itemTemp);
          }
        }
      } else {
        ArrayList<Character> item = new ArrayList();
        item.add(chars[i]);
        result.add(item);
      }
    }

    String[] resultArr = new String[result.size()];
    for (int i = 0; i < result.size(); i++) {
      StringBuilder builder = new StringBuilder();
      for (Character item: result.get(i)) {
        builder.append(item);
      }
      resultArr[i] = builder.toString();
    }
    return resultArr;
  }

  public static void main(String[] args) {
    String[] result = permutation("abc");

    for (String str: result) {
      System.out.print(str + ", ");
    }
  }
}
