package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/26
 * Desc:
 */
public class Num300 {
  /**
   * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
   * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
   *
   * 示例 1：
   * 输入：nums = [10,9,2,5,3,7,101,18]
   * 输出：4
   * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
   *
   * 示例 2：
   * 输入：nums = [0,1,0,3,2,3]
   * 输出：4
   *
   * 示例 3：
   * 输入：nums = [7,7,7,7,7,7,7]
   * 输出：1
   *
   * 提示：
   * 1 <= nums.length <= 2500
   * -10^4 <= nums[i] <= 10^4
   *
   * 进阶：
   * 你可以设计时间复杂度为 O(n^2) 的解决方案吗？
   * 你能将算法的时间复杂度降低到O(n log(n)) 吗?
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int lengthOfLIS11(int[] nums) { // 动态规划
    int len = nums.length;
    if (len == 0) {
      return len;
    }
    int[] dp = new int[len];
    int maxLen = 0;
    for (int i = 0; i < len; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxLen = Math.max(maxLen, dp[i]);
    }
    return maxLen;
  }

  /**
   * 以输入序列 [0, 8, 4, 12, 2][0,8,4,12,2] 为例：
   *
   * 第一步插入 00，d = [0]d=[0]；
   * 第二步插入 88，d = [0, 8]d=[0,8]；
   * 第三步插入 44，d = [0, 4]d=[0,4]；
   * 第四步插入 1212，d = [0, 4, 12]d=[0,4,12]；
   * 第五步插入 22，d = [0, 2, 12]d=[0,2,12]。
   * @param nums
   * @return
   */
  public int lengthOfLIS(int[] nums) { // 贪心 + 二分查找
    int len = 1, n = nums.length;
    if (n == 0) {
      return 0;
    }
    int[] d = new int[n + 1];
    d[len] = nums[0];
    for (int i = 1; i < n; ++i) {
      if (nums[i] > d[len]) {
        d[++len] = nums[i];
      } else {
        int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
        while (l <= r) {
          int mid = (l + r) >> 1;
          if (d[mid] < nums[i]) {
            pos = mid;
            l = mid + 1;
          } else {
            r = mid - 1;
          }
        }
        d[pos + 1] = nums[i];
      }
    }
    return len;
  }
}
