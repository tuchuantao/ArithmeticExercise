package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/8/3
 * Desc:
 */
public class Num581 {
  /**
   * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
   * 请你找出符合题意的 最短 子数组，并输出它的长度。
   *
   * 示例 1：
   * 输入：nums = [2,6,4,8,10,9,15]
   * 输出：5
   * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
   *
   * 示例 2：
   * 输入：nums = [1,2,3,4]
   * 输出：0
   *
   * 示例 3：
   * 输入：nums = [1]
   * 输出：0
   *
   * 提示：
   * 1 <= nums.length <= 10^4
   * -10^5 <= nums[i] <= 10^5
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findUnsortedSubarray11(int[] nums) { // 排序 O(n logn)
    int[] tempArr = nums.clone();
    Arrays.sort(tempArr);
    int len = nums.length;
    int startIndex = len;
    int endIndex = -1;
    for (int i = 0; i < len; i++) {
      if (tempArr[i] != nums[i]) {
        startIndex = Math.min(startIndex, i);
        endIndex = Math.max(endIndex, i);
      }
    }
    return endIndex - startIndex + 1 > 0 ? endIndex - startIndex + 1 : 0;
  }

  public int findUnsortedSubarray(int[] nums) { // 将数组分成三段， 左边 比中间最小的还小，  右边比中间最大的还大
    int len = nums.length;
    int maxn = Integer.MIN_VALUE, right = -1;
    int minn = Integer.MAX_VALUE, left = -1;
    for (int i = 0; i < len; i++) {
      if (maxn > nums[i]) { // 从左往右，找寻比递减(最大值)的位置
        right = i;
      } else {
        maxn = nums[i];
      }
      if (minn < nums[len - i - 1]) { // 从右向左，找寻递增(最小值)的位置
        left = len - i - 1;
      } else {
        minn = nums[len - i - 1];
      }
    }
    return right == -1 ? 0 : right - left + 1;
  }


  public static void main(String[] args) {
    int result = new Num581().findUnsortedSubarray(new int[]{2,6,4,8,10,9,15});
    System.out.println("result=" + result);
  }
}
