package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2022/1/5
 * Desc: 数组的相对排序
 */
public class Num1122 {
  /**
   * 给你两个数组，arr1 和arr2，
   * arr2中的元素各不相同
   * arr2 中的每个元素都出现在arr1中
   * 对 arr1中的元素进行排序，使 arr1 中项的相对顺序和arr2中的相对顺序相同。未在arr2中出现过的元素需要按照升序放在arr1的末尾。
   *
   * 示例：
   * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
   * 输出：[2,2,2,1,4,3,3,9,6,7,19]
   * 
   * 提示：
   * 1 <= arr1.length, arr2.length <= 1000
   * 0 <= arr1[i], arr2[i] <= 1000
   * arr2中的元素arr2[i]各不相同
   * arr2 中的每个元素arr2[i]都出现在arr1中
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/relative-sort-array
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    int len = arr1.length;
    int[] ans = new int[len];
    Map<Integer, Integer> map = new HashMap();
    for (int num : arr2) {
      map.put(num, 0);
    }
    Arrays.sort(arr1);
    int index = len - 1;
    for (int i = len - 1; i >= 0; i--) {
      if (map.get(arr1[i]) != null) {
        map.put(arr1[i], map.get(arr1[i]) + 1);
      } else {
        ans[index] = arr1[i];
        index--;
      }
    }
    index = 0;
    for (int num : arr2) {
      int count = map.get(num);
      while (count > 0) {
        ans[index] = num;
        index++;
        count--;
      }
    }
    return ans;
  }
}
