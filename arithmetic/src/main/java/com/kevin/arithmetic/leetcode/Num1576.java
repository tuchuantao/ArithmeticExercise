package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2022/1/5
 * Desc: 替换所有的问号
 */
public class Num1576 {
  /**
   * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
   * 注意：你 不能 修改非 '?' 字符。
   * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
   * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
   *
   * 示例 1：
   * 输入：s = "?zs"
   * 输出："azs"
   * 解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
   *
   * 示例 2：
   * 输入：s = "ubv?w"
   * 输出："ubvaw"
   * 解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
   *
   * 示例 3：
   * 输入：s = "j?qg??b"
   * 输出："jaqgacb"
   *
   * 示例 4：
   * 输入：s = "??yw?ipkj?"
   * 输出："acywaipkja"
   *
   * 提示：
   * 1 <= s.length<= 100
   * s 仅包含小写英文字母和 '?' 字符
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String modifyString(String s) {
    int len = s.length();
    char[] arr = s.toCharArray();
    for (int i = 0; i < len; i++) {
      if (arr[i] == '?') {
        for (int j = 0; j < 26; j++) {
          if ((i - 1 < 0 || arr[i - 1] != (char)('a' + j)) &&
              (i + 1 == len || arr[i + 1] != (char)('a' + j))) {
            arr[i] = (char) ('a' + j);
            break;
          }
        }
      }
    }
    return String.valueOf(arr);
  }
}
