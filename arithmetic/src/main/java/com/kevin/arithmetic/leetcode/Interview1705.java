package com.kevin.arithmetic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/12/27
 * Desc: 字母与数字
 */
public class Interview1705 {
  /**
   * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
   * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
   *
   * 示例 1:
   * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
   * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
   *
   * 示例 2:
   * 输入: ["A","A"]
   * 输出: []
   *
   * 提示：
   * array.length <= 100000
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/find-longest-subarray-lcci
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String[] findLongestSubarray(String[] array) {
    Map<Integer, Integer> map = new HashMap();
    int maxLen = 0;
    int maxIndex = 0;
    int len = array.length;
    int sum = 0;
    map.put(0, -1);
    for (int i = 0; i < len; i++) {
      if (Character.isDigit(array[i].charAt(0))) {
        sum++;
      } else {
        sum--;
      }
      if (map.get(sum) == null) {
        map.put(sum, i);
      } else {
        int startIndex = map.get(sum);
        int subLen = i - startIndex;
        if (subLen > maxLen) {
          maxLen = subLen;
          maxIndex = startIndex + 1;
        }
      }
    }
    return maxLen <= 0 ? new String[0] : Arrays.copyOfRange(array, maxIndex, maxIndex + maxLen);
  }
}
