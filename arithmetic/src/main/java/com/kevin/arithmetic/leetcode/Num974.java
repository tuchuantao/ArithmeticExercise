package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2022/1/4
 * Desc: 和可被 K 整除的子数组
 */
public class Num974 {
  /**
   * 给定一个整数数组 A，返回其中元素之和可被 K整除的（连续、非空）子数组的数目。
   *
   * 示例：
   * 输入：A = [4,5,0,-2,-3,1], K = 5
   * 输出：7
   * 解释：
   * 有 7 个子数组满足其元素之和可被 K = 5 整除：
   * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
   * 
   * 提示：
   * 1 <= A.length <= 30000
   * -10000 <= A[i] <= 10000
   * 2 <= K <= 10000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int subarraysDivByK(int[] nums, int k) { // 哈希表 + 逐一统计
    Map<Integer, Integer> record = new HashMap<Integer, Integer>();
    record.put(0, 1);
    int sum = 0, ans = 0;
    for (int elem : nums) {
      sum += elem;
      // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
      int modulus = (sum % k + k) % k;
      int same = record.getOrDefault(modulus, 0);
      ans += same;
      record.put(modulus, same + 1);
    }
    return ans;
  }

  public int subarraysDivByK2(int[] nums, int k) { // 哈希表 + 单次统计
    Map<Integer, Integer> record = new HashMap<Integer, Integer>();
    record.put(0, 1);
    int sum = 0;
    for (int elem : nums) {
      sum += elem;
      // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
      int modulus = (sum % k + k) % k;
      record.put(modulus, record.getOrDefault(modulus, 0) + 1);
    }

    int ans = 0;
    for (Map.Entry<Integer, Integer> entry: record.entrySet()) {
      ans += entry.getValue() * (entry.getValue() - 1) / 2;
    }
    return ans;
  }
}
