package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tuchuantao on 2021/9/9
 * Desc:
 */
public class Num373 {
  /**
   * 给定两个以升序排列的整数数组 nums1 和 nums2,以及一个整数 k。
   * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
   * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
   *
   * 示例 1:
   * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
   * 输出: [1,2],[1,4],[1,6]
   * 解释: 返回序列中的前 3 对数：
   *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
   *
   * 示例 2:
   * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
   * 输出: [1,1],[1,1]
   * 解释: 返回序列中的前 2 对数：
   *     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
   *
   * 示例 3:
   * 输入: nums1 = [1,2], nums2 = [3], k = 3
   * 输出: [1,3],[2,3]
   * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
   *
   * 提示:
   * 1 <= nums1.length, nums2.length <= 10^4
   * -10^9 <= nums1[i], nums2[i] <= 10^9
   * nums1, nums2 均为升序排列
   * 1 <= k <= 1000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) { // 暴力
    List<List<Integer>> list = new ArrayList();
    int maxIndex1 = Math.min(nums1.length, k);
    int maxIndex2 = Math.min(nums2.length, k);
    for (int i = 0; i < maxIndex1; i++) {
      for (int j = 0; j < maxIndex2; j++) {
        ArrayList<Integer> subList = new ArrayList();
        subList.add(nums1[i]);
        subList.add(nums2[j]);
        list.add(subList);
      }
    }
    list.sort((o1, o2) -> o1.get(0) + o1.get(1) - (o2.get(0) + o2.get(1)));
    if (list.size() > k) {
      list = list.subList(0, k);
    }
    return list;
  }

}
