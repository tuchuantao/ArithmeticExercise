package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/12/27
 * Desc: 区域和检索 - 数组不可变
 */
public class Num303 {
  /**
   * 给定一个整数数组 nums，求出数组从索引i到j（i≤j）范围内元素的总和，包含i、j两点。
   * 实现 NumArray 类：
   * NumArray(int[] nums) 使用数组 nums 初始化对象
   * int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）范围内元素的总和，包含i、j两点（也就是 sum(nums[i], 
   * nums[i + 1], ... , nums[j])）
   *
   * 示例：
   * 输入：
   * ["NumArray", "sumRange", "sumRange", "sumRange"]
   * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
   * 输出：
   * [null, 1, -1, -3]
   *
   * 解释：
   * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
   * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
   * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
   * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
   *
   * 提示：
   * 0 <= nums.length <= 10^4
   * -10^5<= nums[i] <=10^5
   * 0 <= i <= j < nums.length
   * 最多调用 10^4 次 sumRange 方法
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  class NumArray {

    private int[] sumArr;

    public NumArray(int[] nums) {
      int len = nums.length;
      sumArr = new int[len];
      int sum = 0;
      for (int i = 0; i < len; i++) {
        sum += nums[i];
        sumArr[i] = sum;
      }
    }

    public int sumRange(int left, int right) {
      int leftSum = left - 1 >= 0 ? sumArr[left - 1] : 0;
      int rightSum = sumArr[right];
      return rightSum - leftSum;
    }
  }
}
