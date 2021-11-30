package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/11/30
 * Desc: 数组中数字出现的次数 II
 */
public class Num137 {
  /**
   * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
   *
   * 示例 1：
   * 输入：nums = [3,4,3,3]
   * 输出：4
   *
   * 示例 2：
   * 输入：nums = [9,1,7,9,7,9,7]
   * 输出：1
   * 
   * 限制：
   * 1 <= nums.length <= 10000
   * 1 <= nums[i] < 2^31
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int singleNumber(int[] nums) { // 统计每一位出现1的个数
    int[] dig = new int[32];
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < 32; j++) {
        dig[j] += (nums[i] & (1 << j)) == 0 ? 0 : 1;
      }
    }
    int res = 0;
    for (int i = 0; i < 32; i++) {
      if (dig[i] % 3 != 0) {
        res ^= (1 << i);
      }
    }
    return res;
  }

  public int singleNumber2(int[] nums) {
    int ans = 0;
    for (int i = 0; i < 32; ++i) {
      int total = 0;
      for (int num: nums) {
        total += ((num >> i) & 1);
      }
      if (total % 3 != 0) {
        ans |= (1 << i);
      }
    }
    return ans;
  }
}
