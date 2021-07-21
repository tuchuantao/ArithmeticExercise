package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/16
 * Desc:
 */
public class Num34AndOffer53 {

  /**
   * 统计一个数字在排序数组中出现的次数。
   * <p>
   * <p>
   * <p>
   * 示例 1:
   * <p>
   * 输入: nums = [5,7,7,8,8,10], target = 8
   * 输出: 2
   * 示例2:
   * <p>
   * 输入: nums = [5,7,7,8,8,10], target = 6
   * 输出: 0
   * <p>
   * <p>
   * 限制：
   * <p>
   * 0 <= 数组长度 <= 50000
   * <p>
   * <p>
   * <p>
   * 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn
   * .com/problems/find-first-and-last-position-of-element-in-sorted-array/
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int search(int[] nums, int target) {
    int count = 0;
    int right = nums.length - 1;
    int left = 0;
    while (left <= right) {
      int center = left + ((right - left) >> 1);
      if (nums[center] == target) {
        left = center;
        count++;
        break;
      } else if (nums[center] < target) {
        left = center + 1;
      } else {
        right = center - 1;
      }
    }
    if (left >= 0 && left < nums.length && nums[left] == target) {
      int index = left - 1;
      while (index >= 0 && nums[index--] == target) {
        count++;
      }
      index = left + 1;
      while (index < nums.length && nums[index++] == target) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int result = new Num34AndOffer53().search(new int[]{}, 1);
//    int result = new Offer53AndNum34().search(new int[]{1}, 1);
    System.out.println("result=" + result);
  }
}
