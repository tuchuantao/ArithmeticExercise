package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by tuchuantao on 2021/7/23
 * Desc:
 */
public class Num862 {
  /**
   * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
   * 如果没有和至少为K的非空子数组，返回-1。
   * <p>
   * 示例 1：
   * 输入：A = [1], K = 1
   * 输出：1
   * <p>
   * 示例 2：
   * 输入：A = [1,2], K = 4
   * 输出：-1
   * <p>
   * 示例 3：
   * 输入：A = [2,-1,2], K = 3
   * 输出：3
   * <p>
   * 提示：
   * 1 <= A.length <= 50000
   * -10 ^ 5<= A[i] <= 10 ^ 5
   * 1 <= K <= 10 ^ 9
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int shortestSubarray11(int[] nums, int k) { // 暴力
    int len = nums.length;
    for (int i = 1; i < len; i++) {
      nums[i] += nums[i - 1];
    }
    int subLen = 1;
    while (subLen <= len) {
      for (int i = 0; i <= len - subLen; i++) {
        int sum = nums[i + subLen - 1];
        if (i > 0) {
          sum -= nums[i - 1];
        }
        if (sum >= k) {
          return subLen;
        }
      }
      subLen++;
    }
    return -1;
  }

  public int shortestSubarray(int[] nums, int K) {
    int N = nums.length;
    long[] P = new long[N + 1];
    for (int i = 0; i < N; ++i)
      P[i + 1] = P[i] + (long) nums[i];

    // Want smallest y-x with P[y] - P[x] >= K
    int ans = N + 1; // N+1 is impossible
    Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

    for (int y = 0; y < P.length; ++y) {
      // Want opt(y) = largest x with P[x] <= P[y] - K;
      while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
        monoq.removeLast();
      while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
        ans = Math.min(ans, y - monoq.removeFirst());

      monoq.addLast(y);
    }

    return ans < N + 1 ? ans : -1;
  }
}