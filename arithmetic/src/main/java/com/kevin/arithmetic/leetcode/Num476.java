package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;

/**
 * Created by tuchuantao on 2021/10/18
 * Desc: 数字的补数
 */
public class Num476 {
  /**
   * 给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。
   *
   * 示例 1：
   * 输入：num = 5
   * 输出：2
   * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
   *
   * 示例 2：
   * 输入：num = 1
   * 输出：0
   * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
   *
   * 提示：
   * 给定的整数 num 保证在 32 位带符号整数的范围内。
   * num >= 1
   * 你可以假定二进制数不包含前导零位。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/number-complement
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int findComplement1(int num) {
    ArrayList<Integer> list = new ArrayList();
    while (num != 0) {
      list.add(num % 2);
      num = num / 2;
    }
    int size = list.size();
    if (size == 0) {
      return 1;
    }
    int base = 1;
    for (int i = 0; i < size; i++) {
      if (list.get(i) == 0) {
        num = num + base;
      }
      base *= 2;
    }
    return num;
  }

  public int findComplement(int num) {

  }
}
