package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/12/30
 * Desc: 一手顺子
 */
public class Num846 {
  /**
   * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
   * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
   *
   * 示例 1：
   * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
   * 输出：true
   * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
   *
   * 示例 2：
   * 输入：hand = [1,2,3,4,5], groupSize = 4
   * 输出：false
   * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
   *
   * 提示：
   * 1 <= hand.length <= 10^4
   * 0 <= hand[i] <= 10^9
   * 1 <= groupSize <= hand.length
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/hand-of-straights
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isNStraightHand(int[] hand, int groupSize) {
    int len = hand.length;
    if (len % groupSize != 0) {
      return false;
    }
    Arrays.sort(hand);
    Map<Integer, Integer> map = new HashMap();
    List<Integer> list = new ArrayList();
    int index = 0;
    while (index < len) {
      int count = 1;
      while(index < len - 1 && hand[index] == hand[index + 1]) {
        index++;
        count++;
      }
      map.put(hand[index - count + 1], count);
      list.add(hand[index - count + 1]);
      index++;
    }
    int size = list.size();
    index = 0;
    while (index < size) {
      while (index < size && map.get(list.get(index)) == 0) {
        index++;
      }
      if (index >= size) {
        return true;
      }
      int first = list.get(index);
      map.put(first, map.get(first) - 1);
      for (int i = 1; i < groupSize; i++) {
        int count = map.getOrDefault(first + i, 0);
        if (count <= 0) {
          return false;
        }
        count--;
        map.put(first + i, count);
      }
    }
    return true;
  }
}
