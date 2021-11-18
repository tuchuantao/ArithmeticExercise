package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/11/18
 * Desc: 和为s的连续正数序列
 */
public class Offer57_2 {
  /**
   * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
   * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
   *
   * 示例 1：
   * 输入：target = 9
   * 输出：[[2,3,4],[4,5]]
   *
   * 示例 2：
   * 输入：target = 15
   * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
   *
   * 限制：
   * 1 <= target <= 10^5
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[][] findContinuousSequence1(int target) { // 暴力枚举
    List<int[]> ansList = new ArrayList();
    for (int i = 1; i <= target / 2 ; i++) {
      int sum = target;
      for (int j = i; j <= target / 2 + 1; j++) {
        if (sum == j) {
          int[] arr = new int[j - i + 1];
          for (int k = i; k <= j ; k++) {
            arr[k - i] = i;
          }
          ansList.add(arr);
          break;
        } else if (sum < 0) {
          break;
        }
        sum -= j;
      }
    }
    return ansList.toArray(new int[ansList.size()][]);
  }

  public int[][] findContinuousSequence(int target) { // 双指针
    List<int[]> ansList = new ArrayList();
    for (int l = 1, r = 2; l < r;) {
      int sum = (l + r) * (r - l + 1) / 2;
      if (sum == target) {
        int[] res = new int[r - l + 1];
        for (int i = l; i <= r; ++i) {
          res[i - l] = i;
        }
        ansList.add(res);
        l++;
      } else if (sum < target) {
        r++;
      } else {
        l++;
      }
    }
    return ansList.toArray(new int[ansList.size()][]);
  }

}
