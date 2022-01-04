package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2022/1/4
 * Desc: 最大连续1的个数 III
 */
public class Num1004 {
  /**
   * 给定一个由若干 0 和 1 组成的数组A，我们最多可以将K个值从 0 变成 1 。
   * 返回仅包含 1 的最长（连续）子数组的长度。
   *
   * 示例 1：
   * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
   * 输出：6
   * 解释： 
   * [1,1,1,0,0,1,1,1,1,1,1]
   * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
   *
   * 示例 2：
   * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
   * 输出：10
   * 解释：
   * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
   * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
   *
   * 提示：
   * 1 <= A.length <= 20000
   * 0 <= K <= A.length
   * A[i] 为0或1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int longestOnes(int[] nums, int k) { // 前缀和
    Map<Integer, Integer> map = new HashMap();
    int sum = 0;
    int maxLen = 0;
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      if (nums[i] == 0) {
        sum++;
        map.put(sum, i);
      }
      maxLen = Math.max(maxLen, sum <= k ? i + 1 : i - map.get(sum - k));
    }
    return maxLen;
  }

  public int longestOnes2(int[] nums, int k) { // 滑动窗口
    int n = nums.length;
    int left = 0, lsum = 0, rsum = 0;
    int ans = 0;
    for (int right = 0; right < n; ++right) {
      rsum += 1 - nums[right];
      while (lsum < rsum - k) {
        lsum += 1 - nums[left];
        ++left;
      }
      ans = Math.max(ans, right - left + 1);
    }
    return ans;
  }

  /**
   * 解题思路
   * 对于数组 AA 的区间 [left,right] 而言，只要它包含不超过 k 个0，我们就可以根据它构造出一段满足要求，并且长度为 right−left+1 的区间。
   *
   * 因此，我们可以将该问题进行如下的转化，即：
   *   对于任意的右端点 right，希望找到最小的左端点 left，使得 [left,right] 包含不超过 k 个 0。
   *   只要我们枚举所有可能的右端点，将得到的区间的长度取最大值，即可得到答案。
   *
   * 要想快速判断一个区间内 0 的个数，我们可以考虑将数组 A 中的 0 变成 1，1 变成 0。此时，我们对数组 A 求出前缀和，记为数组 P，那么 [left,right] 中包含不超过 k 个 1（注意这里就不是 0 了），当且仅当二者的前缀和之差：
   * P[right]−P[left−1]
   * 小于等于 k。这样一来，我们就可以容易地解决这个问题了。
   */
}
