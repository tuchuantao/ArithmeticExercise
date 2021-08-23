package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/8/23
 * Desc:
 */
public class Offer21 {
  /**
   * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
   *
   * 示例：
   * 输入：nums =[1,2,3,4]
   * 输出：[1,3,2,4]
   * 注：[3,1,2,4] 也是正确的答案之一。
   *
   * 提示：
   * 0 <= nums.length <= 50000
   * 1 <= nums[i] <= 10000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian
   * -mian-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] exchange(int[] nums) {
    int len = nums.length;
    if (len <= 1) {
      return nums;
    }
    int left = 0;
    int right = len - 1;
    while (left < right) {
      while (left < len && nums[left] % 2 != 0) {
        left++;
      }
      while (right >= 0 && nums[right] % 2 != 1) {
        right--;
      }
      if (left < right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
      }
    }
    return nums;
  }
}
