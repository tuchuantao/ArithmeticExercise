package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/9/27
 * Desc:
 */
public class Num416 {
  /**
   * 给你一个 只包含正整数 的 非空 数组nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
   *
   * 示例 1：
   * 输入：nums = [1,5,11,5]
   * 输出：true
   * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
   *
   * 示例 2：
   * 输入：nums = [1,2,3,5]
   * 输出：false
   * 解释：数组不能分割成两个元素和相等的子集。
   * 
   * 提示：
   * 1 <= nums.length <= 200
   * 1 <= nums[i] <= 100
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean canPartition11(int[] nums) { // 暴力递归，超时
    int len = nums.length;
    if (len <= 1) {
      return false;
    }
    int sum = 0, maxNum = 0;
    for (int i = 0; i < len; i++) {
      sum += nums[i];
      maxNum = Math.max(maxNum, nums[i]);
    }
    if (sum % 2 != 0) {
      return false;
    }
    sum = sum / 2;
    if (maxNum > sum) {
      return false;
    }

    return canPar(sum, nums, 1) || canPar(sum - nums[0], nums, 1);
  }

  public boolean canPar(int sum, int[] nums, int index) {
    if (sum == 0) {
      return true;
    } else if (sum < 0 || index >= nums.length) {
      return false;
    }
    return canPar(sum, nums, index + 1) || canPar(sum - nums[index], nums, index + 1);
  }


  public boolean canPartition(int[] nums) { // 动态规划
    int len = nums.length;
    if (len <= 1) {
      return false;
    }
    int sum = 0, maxNum = 0;
    for (int i = 0; i < len; i++) {
      sum += nums[i];
      maxNum = Math.max(maxNum, nums[i]);
    }
    if (sum % 2 != 0) {
      return false;
    }
    sum = sum / 2;
    if (maxNum > sum) {
      return false;
    }

    boolean[][] dp = new boolean[len][sum + 1]; // dp[i][j] 表示从数组的 [0,i]下标范围内选取若干个正整数（可以是 0 个），是否存在一种选取方案使得被选取的正整数的和等于 j。
    for (int i = 0; i < len; i++) {
      dp[i][0] = true;
    }
    dp[0][nums[0]] = true;
    for (int i = 1; i < len; i++) {
      int num = nums[i];
      for (int j = 1; j <= sum; j++) {
        if (j >= num) { // 跟当前比较，以确定当前位置是否能够被选择
          dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[len - 1][sum];
  }

  public boolean canPartition22(int[] nums) { // 动态规划优化
    int len = nums.length;
    if (len <= 1) {
      return false;
    }
    int sum = 0, maxNum = 0;
    for (int i = 0; i < len; i++) {
      sum += nums[i];
      maxNum = Math.max(maxNum, nums[i]);
    }
    if (sum % 2 != 0) {
      return false;
    }
    sum = sum / 2;
    if (maxNum > sum) {
      return false;
    }

    boolean[] dp = new boolean[sum + 1];
    dp[0] = true;
    // 且需要注意的是第二层的循环我们需要从大到小计算，因为如果我们从小到大更新 dp 值，那么在计算 dp[j] 值的时候，dp[j−nums[i]] 已经是被更新过的状态，不再是上一行的 dp 值。
    for (int i = 0; i < len; i++) {
      int num = nums[i];
      for (int j = sum; j >= num; j--) {
        dp[j] |= dp[j - num];
      }
    }
    return dp[sum];
  }
}
