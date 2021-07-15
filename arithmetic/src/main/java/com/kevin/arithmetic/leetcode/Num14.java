package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/15
 * Desc:
 */
public class Num14 {

  /**
   * 编写一个函数来查找字符串数组中的最长公共前缀。
   * <p>
   * 如果不存在公共前缀，返回空字符串""。
   * <p>
   * <p>
   * <p>
   * 示例 1：
   * <p>
   * 输入：strs = ["flower","flow","flight"]
   * 输出："fl"
   * 示例 2：
   * <p>
   * 输入：strs = ["dog","racecar","car"]
   * 输出：""
   * 解释：输入不存在公共前缀。
   * <p>
   * <p>
   * 提示：
   * <p>
   * 0 <= strs.length <= 200
   * 0 <= strs[i].length <= 200
   * strs[i] 仅由小写英文字母组成
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/longest-common-prefix
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String longestCommonPrefix(String[] strs) {
    int len = strs.length;
    if (len == 0) {
      return "";
    }

    char[] arr = strs[0].toCharArray();
    int index = arr.length;
    for (int i = 1; i < len; i++) {
      char[] itemArr = strs[i].toCharArray();
      index = Math.min(itemArr.length, index);
      for (int j = 0; j < index; j++) {
        if (arr[j] != itemArr[j]) {
          index = j;
          break;
        }
      }
      if (index == 0) {
        break;
      }
    }
    return index == 0 ? "" : String.valueOf(arr, 0, index);
  }
}
