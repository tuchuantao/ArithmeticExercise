package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2022/1/7
 * Desc: 爱吃香蕉的珂珂
 */
public class Num875 {
  /**
   * 珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
   * 珂珂可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
   * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
   * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
   *
   * 示例 1：
   * 输入: piles = [3,6,7,11], H = 8
   * 输出: 4
   *
   * 示例2：
   * 输入: piles = [30,11,23,4,20], H = 5
   * 输出: 30
   *
   * 示例3：
   * 输入: piles = [30,11,23,4,20], H = 6
   * 输出: 23
   *
   * 提示：
   * 1 <= piles.length <= 10^4
   * piles.length <= H <= 10^9
   * 1 <= piles[i] <= 10^9
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int minEatingSpeed1(int[] piles, int h) {
    int len = piles.length;
    int max = 0;
    long avg = 0;
    for (int num : piles) {
      max = Math.max(max, num);
      avg += num;
    }
    if (len == h) {
      return max;
    }
    avg = avg / h + (avg % h == 0 ? 0 : 1);

    while (avg <= max) { // [1000000000,1000000000], 3 超时
      int count = 0;
      for (int num : piles) {
        count += num / avg;
        if (num % avg != 0) {
          count++;
        }
      }
      if (count <= h) {
        break;
      }
      avg++;
    }
    return (int) avg;
  }

  public int minEatingSpeed(int[] piles, int h) { // 优化，二分查找
    int len = piles.length;
    long right = 0;
    long left = 0;
    for (int num : piles) {
      right = Math.max(right, num);
      left += num;
    }
    if (len == h) {
      return (int) right;
    }
    left = left / h + (left % h == 0 ? 0 : 1);

    long center;
    while (left < right) {
      center = left + (right - left) / 2;
      int tempCount = 0;
      for (int num : piles) {
        tempCount += num / center;
        if (num % center != 0) {
          tempCount++;
        }
      }
      if (tempCount <= h) { // tempCount == h 时不要着急返回，有可能会存在更小值
        right = center;
      } else {
        left = center + 1;
      }
    }
    return (int) left;
  }

  public static void main(String[] args) {
//    int ans = new Num875().minEatingSpeed(new int[]{3,6,7,11}, 8);
//    int ans = new Num875().minEatingSpeed(new int[]{312884470}, 312884469);
    int ans = new Num875().minEatingSpeed(new int[]{1000000000,1000000000}, 3);
    System.out.println("ans=" + ans);
  }
}
