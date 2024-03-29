package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/8/27
 * Desc:
 */
public class Offer40 {
  /**
   * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
   *
   * 示例 1：
   * 输入：arr = [3,2,1], k = 2
   * 输出：[1,2] 或者 [2,1]
   *
   * 示例 2：
   * 输入：arr = [0,1,2,1], k = 1
   * 输出：[0]
   * 
   * 限制：
   * 0 <= k <= arr.length <= 10000
   * 0 <= arr[i]<= 10000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] getLeastNumbers(int[] arr, int k) { // 优化，快排 & 去除无必要比较
    int[] vec = new int[k];
    Arrays.sort(arr);
    for (int i = 0; i < k; ++i) {
      vec[i] = arr[i];
    }
    return vec;
  }
}
