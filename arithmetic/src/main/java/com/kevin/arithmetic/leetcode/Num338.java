package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/12/7
 * Desc: 比特位计数
 */
public class Num338 {
  /**
   * 给你一个整数 n ，对于0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
   *
   * 示例 1：
   * 输入：n = 2
   * 输出：[0,1,1]
   * 解释：
   * 0 -->  0
   * 1 -->  1
   * 2 --> 10
   *
   * 示例 2：
   * 输入：n = 5
   * 输出：[0,1,1,2,1,2]
   * 解释：
   * 0 -->   0
   * 1 -->   1
   * 2 -->  10
   * 3 -->  11
   * 4 --> 100
   * 5 --> 101
   *
   * 提示：
   * 0 <= n <= 10^5
   *
   * 进阶：
   * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
   * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的__builtin_popcount ）
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/counting-bits
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] countBits1(int n) {
    List<Integer> list = new ArrayList();
    list.add(0);
    list.add(1);
    int len = n - 1;
    while (len > 0) {
      int size = Math.min(len, list.size());
      for (int i = 0; i < size; i++) {
        list.add(list.get(i) + 1);
      }
      len -= size;
    }
    int[] ansArr = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      ansArr[i] = list.get(i);
    }
    return ansArr;
  }

  public int[] countBits2(int n) { // 动态规划 - 最高有效位
    int[] bits = new int[n + 1];
    int highBit = 0;
    for (int i = 1; i <= n; i++) {
      if ((i & (i - 1)) == 0) {
        highBit = i;
      }
      bits[i] = bits[i - highBit] + 1;
    }
    return bits;
  }

  public int[] countBits(int n) { // 动态规划 - 最低有效位
    int[] bits = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      bits[i] = bits[i >> 1] + (i & 1);
    }
    return bits;
  }
}
