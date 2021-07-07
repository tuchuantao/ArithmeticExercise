package com.kevin.arithmetic.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/7/7
 * Desc:
 */
public class Num1711 {

  /**
   * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
   *
   * 你可以搭配 任意 两道餐品做一顿大餐。
   *
   * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐
   * 的数量。结果需要对 10^9 + 7 取余。
   *
   * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
   *
   *
   * 示例 1：
   *
   * 输入：deliciousness = [1,3,5,7,9]
   * 输出：4
   * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
   * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
   * 示例 2：
   *
   * 输入：deliciousness = [1,1,1,3,3,3,7]
   * 输出：15
   * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
   *
   * 提示：
   *
   * 1 <= deliciousness.length <= 10^5
   * 0 <= deliciousness[i] <= 2^20
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/count-good-meals
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int countPairs11(int[] deliciousness) {
    Arrays.sort(deliciousness);
    int len = deliciousness.length;
    long result = 0;
    long tempSum;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        tempSum = deliciousness[i] + deliciousness[j];
        if (isPowerOfTwo(tempSum)) {
          result++;
        }
      }
    }
    return (int) (result % 1000000007);
  }

  /**
   * 将要判断的数转换成二进制数，并将其中的0全部舍去，最后判断最后的长度是否为1
   * @param num
   * @return
   */
  public boolean isPowerOfTwo(long num){
    return Long.toBinaryString(num).replaceAll("0", "").length() == 1;
  }

  public int countPairs(int[] deliciousness) {
    final int MOD = 1000000007;
    int maxVal = 0;
    for (int val : deliciousness) {
      maxVal = Math.max(maxVal, val);
    }
    int maxSum = maxVal * 2;
    int pairs = 0;
    Map<Integer, Integer> map = new HashMap();
    int len = deliciousness.length;
    for (int i = 0; i < len; i++) {
      int val = deliciousness[i];
      for (int sum = 1; sum <= maxSum; sum <<= 1) {
        int count = map.getOrDefault(sum - val, 0);
        pairs = (pairs + count) % MOD;
      }
      map.put(val, map.getOrDefault(val, 0) + 1);
    }
    return pairs;
  }
}
