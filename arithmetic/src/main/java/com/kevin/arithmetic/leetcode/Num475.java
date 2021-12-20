package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/12/20
 * Desc: 供暖器
 */
public class Num475 {
  /**
   * 冬季已经来临。你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
   * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
   * 现在，给出位于一条水平线上的房屋houses 和供暖器heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
   * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
   *
   * 示例 1:
   * 输入: houses = [1,2,3], heaters = [2]
   * 输出: 1
   * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
   *
   * 示例 2:
   * 输入: houses = [1,2,3,4], heaters = [1,4]
   * 输出: 1
   * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
   *
   * 示例 3：
   * 输入：houses = [1,5], heaters = [2]
   * 输出：3
   * 
   * 提示：
   * 1 <= houses.length, heaters.length <= 3 * 10^4
   * 1 <= houses[i], heaters[i] <= 10^9
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/heaters
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findRadius(int[] houses, int[] heaters) { // 排序 + 双指针
    Arrays.sort(houses);
    Arrays.sort(heaters);
    int minLen = 0;
    int index = 0;
    int len = heaters.length;
    for (int hou : houses) {
      if (hou <= heaters[index]) {
        minLen = Math.max(minLen, heaters[index] - hou);
      } else if (index < len - 1) {
        while (++index < len && heaters[index] < hou) {
        }
        if (index < len) {
          int last = hou - heaters[index - 1];
          int cur = heaters[index] - hou;
          if (cur < last) {
            minLen = Math.max(minLen, cur);
          } else {
            index--;
            minLen = Math.max(minLen, last);
          }
        } else {
          index = len - 1;
          minLen = Math.max(minLen, hou - heaters[index]);
        }
      } else {
        minLen = Math.max(minLen, hou - heaters[index]);
      }
    }
    return minLen;
  }

  // public int findRadius(int[] houses, int[] heaters) { // 排序 + 二分查找，    只对heaters排序，查找距离每个房子最近的加热器
}
