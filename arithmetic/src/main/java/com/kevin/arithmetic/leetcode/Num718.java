package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by tuchuantao on 2021/9/26
 * Desc:
 */
public class Num718 {
  /**
   * 给两个整数数组A和B，返回两个数组中公共的、长度最长的子数组的长度。
   * <p>
   * 示例：
   * 输入：
   * A: [1,2,3,2,1]
   * B: [3,2,1,4,7]
   * 输出：3
   * <p>
   * 解释：
   * 长度最长的公共子数组是 [3, 2, 1] 。
   * <p>
   * 提示：
   * 1 <= len(A), len(B) <= 1000
   * 0 <= A[i], B[i] < 100
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findLength11(int[] nums1, int[] nums2) { // O(n^2)  暴力
    int len1 = nums1.length;
    int len2 = nums2.length;
    if (len1 == 0 || len2 == 0) {
      return 0;
    }
    int maxLen = 0;
    HashMap<Integer, ArrayList<Integer>> map = new HashMap();
    for (int i = 0; i < len1; i++) {
      ArrayList<Integer> list = map.getOrDefault(nums1[i], new ArrayList());
      list.add(i);
      map.put(nums1[i], list);
    }

    for (int i = 0; i < len2; i++) {
      ArrayList<Integer> list = map.get(nums2[i]);
      if (list != null && !list.isEmpty()) {
        for (int index : list) {
          int index2 = i + 1;
          index++;
          int subLen = 1;
          while (index < len1 && index2 < len2 && nums1[index] == nums2[index2]) {
            subLen++;
            index2++;
            index++;
          }
          maxLen = Math.max(maxLen, subLen);
        }
      }
    }
    return maxLen;
  }

  public int findLength(int[] A, int[] B) { // 动态规划
    int n = A.length, m = B.length;
    int[][] dp = new int[n + 1][m + 1];
    int ans = 0;
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
        ans = Math.max(ans, dp[i][j]);
      }
    }
    return ans;
  }
}