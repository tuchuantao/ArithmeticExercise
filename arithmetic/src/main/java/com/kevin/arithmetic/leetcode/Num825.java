package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/12/27
 * Desc: 适龄的朋友
 */
public class Num825 {
  /**
   * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
   * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
   * age[y] <= 0.5 * age[x] + 7
   * age[y] > age[x]
   * age[y] > 100 && age[x] < 100
   * 否则，x 将会向 y 发送一条好友请求。
   * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
   * 返回在该社交媒体网站上产生的好友请求总数。
   *
   * 示例 1：
   * 输入：ages = [16,16]
   * 输出：2
   * 解释：2 人互发好友请求。
   *
   * 示例 2：
   * 输入：ages = [16,17,18]
   * 输出：2
   * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
   *
   * 示例 3：
   * 输入：ages = [20,30,100,110,120]
   * 输出：3
   * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
   *
   * 提示：
   * n == ages.length
   * 1 <= n <= 2 * 10^4
   * 1 <= ages[i] <= 120
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int numFriendRequests1(int[] ages) { // 双层循环（超时 74/88）
    int len = ages.length;
    int requestCount = 0;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        if (checkAge(ages[i], ages[j])) {
          System.out.println("x=" + ages[i] + "  y=" + ages[j]);
          requestCount++;
        }
        if (checkAge(ages[j], ages[i])) {
          System.out.println("x=" + ages[j] + "  y=" + ages[i]);
          requestCount++;
        }
      }
    }
    return requestCount;
  }

  public int numFriendRequests2(int[] ages) { // 优化双层循环 (超时 85/88)
    Arrays.sort(ages);
    int len = ages.length;
    int requestCount = 0;
    for (int i = len - 1; i >= 0; i--) {
      for (int j = i - 1; j >= 0; j--) {
        if (checkAge(ages[i], ages[j])) {
          requestCount += ages[i] == ages[j] ? 2 : 1;
          System.out.println("x=" + ages[i] + "  y=" + ages[j]);
        } else {
          break;
        }
      }
    }
    return requestCount;
  }

  private boolean checkAge(int x, int y) {
    if (0.5 * x + 7 >= y) {
      return false;
    }
    if (y > x) {
      return false;
    }
    if (y > 100 && x < 100) {
      return false;
    }
    return true;
  }


  public int numFriendRequests3(int[] ages) { // 排序 + 双指针
    int n = ages.length;
    Arrays.sort(ages);
    int left = 0, right = 0, ans = 0;
    for (int age : ages) {
      if (age < 15) {
        continue;
      }
      while (ages[left] <= 0.5 * age + 7) {
        ++left;
      }
      while (right + 1 < n && ages[right + 1] <= age) {
        ++right;
      }
      ans += right - left;
    }
    return ans;
  }

  public int numFriendRequests4(int[] ages) { // 排序 + 前缀和
    int[] cnt = new int[121];
    for (int age : ages) {
      ++cnt[age];
    }
    int[] pre = new int[121];
    for (int i = 1; i <= 120; ++i) {
      pre[i] = pre[i - 1] + cnt[i];
    }
    int ans = 0;
    for (int i = 15; i <= 120; ++i) {
      if (cnt[i] > 0) {
        int bound = (int) (i * 0.5 + 8);
        ans += cnt[i] * (pre[i] - pre[bound - 1] - 1);
      }
    }
    return ans;
  }
}
