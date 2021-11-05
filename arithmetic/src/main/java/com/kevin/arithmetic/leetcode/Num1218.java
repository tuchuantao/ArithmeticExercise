package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/11/5
 * Desc: 最长定差子序列
 */
public class Num1218 {
  /**
   * 给你一个整数数组arr和一个整数difference，请你找出并返回 arr中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
   * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
   *
   * 示例 1：
   * 输入：arr = [1,2,3,4], difference = 1
   * 输出：4
   * 解释：最长的等差子序列是 [1,2,3,4]。
   *
   * 示例2：
   * 输入：arr = [1,3,5,7], difference = 1
   * 输出：1
   * 解释：最长的等差子序列是任意单个元素。
   *
   * 示例 3：
   * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
   * 输出：4
   * 解释：最长的等差子序列是 [7,5,3,1]。
   *
   * 提示：
   * 1 <= arr.length <= 10^5
   * -10^4 <= arr[i], difference <= 10^4
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int longestSubsequence1(int[] arr, int difference) { // 暴力，超时
    int len = arr.length;
    if (len <= 1) {
      return len;
    }
    Map<Integer, List<Integer>> map = new HashMap();
    for (int i = 0; i < len; i++) {
      List<Integer> list = map.getOrDefault(arr[i], new ArrayList());
      list.add(i);
      map.put(arr[i], list);
    }
    int maxLen = 1;
    for (int i = 0; i < len; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) {
        continue;
      }
      int currIndex = -1;
      int curNum = arr[i];
      int tempLen = 0;
      while (map.get(curNum) != null) {
        int lastIndex = currIndex;
        List<Integer> list = map.get(curNum);
        for (Integer index : list) {
          if (index > currIndex) {
            tempLen++;
            curNum += difference;
            currIndex = index;
            break;
          }
        }
        if (currIndex == lastIndex) {
          break;
        }
      }
      maxLen = Math.max(maxLen, tempLen);
    }
    return maxLen;
  }


  public int longestSubsequence(int[] arr, int difference) { // 动态规划
    int len = arr.length;
    if (len <= 1) {
      return len;
    }
    Map<Integer, List<Integer>> map = new HashMap();
    for (int i = 0; i < len; i++) {
      List<Integer> list = map.getOrDefault(arr[i], new ArrayList());
      list.add(i);
      map.put(arr[i], list);
    }
    int[] dp = new int[len];
    Arrays.fill(dp, 1);
    int maxLen = 1;
    for (int i = 1; i < len; i++) {
      List<Integer> list = map.get(arr[i] - difference);
      if (list != null && !list.isEmpty()) {
        int maxIndex = -1;
        for (Integer index : list) {
          if (index >= i) {
            break;
          }
          if (maxIndex > -1) {
            maxIndex = dp[maxIndex] > dp[index] ? maxIndex : index;
          } else {
            maxIndex = index;
          }
        }
        if (maxIndex > -1) {
          dp[i] = dp[maxIndex] + 1;
          maxLen = Math.max(maxLen, dp[i]);
        }
      }
    }

    return maxLen;
  }

  public int longestSubsequence2(int[] arr, int difference) { // 动态规划
    int ans = 0;
    Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
    for (int v : arr) {
      dp.put(v, dp.getOrDefault(v - difference, 0) + 1); // 后面的一定比前面的长，所以可以直接覆盖
      ans = Math.max(ans, dp.get(v));
    }
    return ans;
  }
}
