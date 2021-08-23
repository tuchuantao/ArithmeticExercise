package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/23
 * Desc:
 */
public class Num1646 {
  /**
   * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
   *
   * nums[0] = 0
   * nums[1] = 1
   * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
   * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
   * 返回生成数组 nums 中的 最大 值。
   *
   * 示例 1：
   * 输入：n = 7
   * 输出：3
   * 解释：根据规则：
   *   nums[0] = 0
   *   nums[1] = 1
   *   nums[(1 * 2) = 2] = nums[1] = 1
   *   nums[(1 * 2) + 1 = 3] = nums[1] + nums[2] = 1 + 1 = 2
   *   nums[(2 * 2) = 4] = nums[2] = 1
   *   nums[(2 * 2) + 1 = 5] = nums[2] + nums[3] = 1 + 2 = 3
   *   nums[(3 * 2) = 6] = nums[3] = 2
   *   nums[(3 * 2) + 1 = 7] = nums[3] + nums[4] = 2 + 1 = 3
   * 因此，nums = [0,1,1,2,1,3,2,3]，最大值 3
   *
   * 示例 2：
   * 输入：n = 2
   * 输出：1
   * 解释：根据规则，nums[0]、nums[1] 和 nums[2] 之中的最大值是 1
   *
   * 示例 3：
   * 输入：n = 3
   * 输出：2
   * 解释：根据规则，nums[0]、nums[1]、nums[2] 和 nums[3] 之中的最大值是 2
   *
   * 提示：
   * 0 <= n <= 100
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/get-maximum-in-generated-array
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int getMaximumGenerated(int n) {
    if (n <= 1) {
      return n;
    }
    int[] arr = new int[n + 1];
    arr[0] = 0;
    arr[1] = 1;
    int max = 1;
    for (int i = 1; i <= n / 2 + 1; i++) {
      if (i * 2 <= n) {
        arr[i * 2] = arr[i];
        max = Math.max(max, arr[i * 2]);
      }
      if (i * 2 + 1 <= n) {
        arr[i * 2 + 1] = arr[i] + arr[i + 1];
        max = Math.max(max, arr[i * 2 + 1]);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int result = new Num1646().getMaximumGenerated(4);
    System.out.println("result=" + result);
  }
}
