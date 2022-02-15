package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by tuchuantao on 2022/2/15
 * Desc: 前 K 个高频元素
 */
public class Num347 {
  /**
   * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
   *
   * 示例 1:
   * 输入: nums = [1,1,1,2,2,3], k = 2
   * 输出: [1,2]
   *
   * 示例 2:
   * 输入: nums = [1], k = 1
   * 输出: [1]
   * 
   * 提示：
   * 1 <= nums.length <= 10^5
   * k 的取值范围是 [1, 数组中不相同的元素的个数]
   * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
   * 
   * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n是数组大小。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    List<int[]> list = new ArrayList();
    Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<Integer, Integer> entry = iterator.next();
      list.add(new int[]{entry.getKey(), entry.getValue()});
    }
    Collections.sort(list, (a, b) -> a[1] - b[1]);
    int[] resArr = new int[k];
    for (int i = 0; i < k; i++) {
      resArr[i] = list.get(i)[0];
    }
    return resArr;
  }

  public int[] topKFrequent2(int[] nums, int k) { // 小顶堆
    Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
    for (int num : nums) {
      occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
    }

    // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
    PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
      public int compare(int[] m, int[] n) {
        return m[1] - n[1];
      }
    });
    for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
      int num = entry.getKey(), count = entry.getValue();
      if (queue.size() == k) {
        if (queue.peek()[1] < count) {
          queue.poll();
          queue.offer(new int[]{num, count});
        }
      } else {
        queue.offer(new int[]{num, count});
      }
    }
    int[] ret = new int[k];
    for (int i = 0; i < k; ++i) {
      ret[i] = queue.poll()[0];
    }
    return ret;
  }
}
