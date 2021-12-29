package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/12/29
 * Desc: 相同元素的间隔之和
 */
public class Num2121 {
  /**
   * 给你一个下标从 0 开始、由 n 个整数组成的数组 arr 。
   * arr 中两个元素的 间隔 定义为它们下标之间的 绝对差 。更正式地，arr[i] 和 arr[j] 之间的间隔是 |i - j| 。
   * 返回一个长度为 n 的数组intervals ，其中 intervals[i] 是 arr[i] 和 arr 中每个相同元素（与 arr[i] 的值相同）的 间隔之和 。
   * 注意：|x| 是 x 的绝对值。
   *
   * 示例 1：
   * 输入：arr = [2,1,3,1,2,3,3]
   * 输出：[4,2,7,2,4,4,5]
   * 解释：
   * - 下标 0 ：另一个 2 在下标 4 ，|0 - 4| = 4
   * - 下标 1 ：另一个 1 在下标 3 ，|1 - 3| = 2
   * - 下标 2 ：另两个 3 在下标 5 和 6 ，|2 - 5| + |2 - 6| = 7
   * - 下标 3 ：另一个 1 在下标 1 ，|3 - 1| = 2
   * - 下标 4 ：另一个 2 在下标 0 ，|4 - 0| = 4
   * - 下标 5 ：另两个 3 在下标 2 和 6 ，|5 - 2| + |5 - 6| = 4
   * - 下标 6 ：另两个 3 在下标 2 和 5 ，|6 - 2| + |6 - 5| = 5
   *
   * 示例 2：
   * 输入：arr = [10,5,10,10]
   * 输出：[5,0,3,4]
   * 解释：
   * - 下标 0 ：另两个 10 在下标 2 和 3 ，|0 - 2| + |0 - 3| = 5
   * - 下标 1 ：只有这一个 5 在数组中，所以到相同元素的间隔之和是 0
   * - 下标 2 ：另两个 10 在下标 0 和 3 ，|2 - 0| + |2 - 3| = 3
   * - 下标 3 ：另两个 10 在下标 0 和 2 ，|3 - 0| + |3 - 2| = 4
   *
   * 提示：
   * n == arr.length
   * 1 <= n <= 10^5
   * 1 <= arr[i] <= 10^5
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/intervals-between-identical-elements
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public long[] getDistances1(int[] arr) { // 哈希 + 枚举 (超时)
    Map<Integer, List<Integer>> map = new HashMap();
    int len = arr.length;
    long[] resArr = new long[len];
    for (int i = 0; i < len; i++) {
      List<Integer> list = map.getOrDefault(arr[i], new ArrayList());
      for (Integer index : list) {
        resArr[index] += Math.abs(i - index);
        resArr[i] += Math.abs(i - index);
      }
      list.add(i);
      map.put(arr[i], list);
    }
    return resArr;
  }

  public long[] getDistances(int[] arr) {
    // 前缀，<key,val>表示值为key的前面一个相同的下标为val[0]，相同的个数为val[1]
    Map<Integer, int[]> preMap = new HashMap<>();
    int n = arr.length;
    long[] re1 = new long[n];
    for (int i = 0; i < n; i++) {
      int[] tempArr = preMap.getOrDefault(arr[i], new int[2]);
      // 当其前面有与他下相同的时候。相同的下标为ordefaule[0],相同了几个为orderfault[1]
      if (tempArr[1] != 0) {
        re1[i] += re1[tempArr[0]] + (i - tempArr[0]) * tempArr[1];
      }
      tempArr[0] = i;
      tempArr[1]++;
      preMap.put(arr[i], tempArr);
    }
    // 后缀
    Map<Integer, int[]> subMap = new HashMap<>();
    long[] re2 = new long[n];
    for (int i = n - 1; i >= 0; i--) {
      int[] tempArr = subMap.getOrDefault(arr[i], new int[2]);
      // 当其后面有与他下相同的时候。相同的下标为ordefaule[0],相同了几个为orderfault[1]
      if (tempArr[1] != 0) {
        re2[i] += re2[tempArr[0]] + (tempArr[0] - i) * tempArr[1];
      }
      tempArr[0] = i;
      tempArr[1]++;
      subMap.put(arr[i], tempArr);
    }
    long[] re = new long[n];
    for (int i = 0; i < n; i++) {
      re[i] = re1[i]+re2[i];
    }
    return re;
  }

//  public long[] getDistances2(int[] arr) {
//    // key存储的是值,value集合存储的是相同值对应的下标集合
//    Map<Integer, List<Integer>> map = new HashMap<>();
//    for (int i = 0; i < arr.length; i++) {
//      map.computeIfAbsent(arr[i], t -> new ArrayList<>()).add(i);
//    }
//    long[] result = new long[arr.length];
//    // 遍历map的value
//    for (List<Integer> list : map.values()) {
//      // 先计算出当前集合第一个元素所对应的间隔和,后续集合中的其它元素都可根据第一个间隔和推算出来
//      for (int i : list) {
//        result[list.get(0)] += i - list.get(0);
//      }
//      // 遍历其它的相同元素,并根据第集合中第一个元素对应的间隔和推算出来
//      for (int i = 1; i < list.size(); i++) {
//        result[list.get(i)] = result[list.get(i - 1)] + (2L * i - list.size()) * (list.get(i) - list.get(i - 1));
//      }
//    }
//    return result;
//  }
}
