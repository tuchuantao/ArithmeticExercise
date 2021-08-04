package com.kevin.arithmetic.leetcode;

import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/8/4
 * Desc: 有效三角形个数
 */
public class Num611 {
  /**
   * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
   *
   * 示例 1:
   * 输入: [2,2,3,4]
   * 输出: 3
   * 解释:
   * 有效的组合是:
   * 2,3,4 (使用第一个 2)
   * 2,3,4 (使用第二个 2)
   * 2,2,3
   *
   * 注意:
   * 数组长度不超过1000。
   * 数组里整数的范围为 [0, 1000]。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/valid-triangle-number
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int triangleNumber11(int[] nums) { // 暴力枚举   O(n^3)
    int len = nums.length;
    if (len < 3) {
      return 0;
    }
    int result = 0;
    for (int i = 0; i < len - 2; i++) {
      for (int j = i + 1; j < len - 1; j++) {
        for (int k = j + 1; k < len; k++) {
          if ((nums[i] + nums[j] > nums[k]) && (nums[i] + nums[k] > nums[j]) && (nums[j] + nums[k] > nums[i])) {
            result++;
          }
        }
      }
    }
    return result;
  }

  public int triangleNumber22(int[] nums) { // 排序
    int len = nums.length;
    if (len < 3) {
      return 0;
    }
    int result = 0;
    Arrays.sort(nums);
    for (int i = 0; i < len - 2; i++) {
      for (int j = i + 1; j < len - 1; j++) {
        for (int k = j + 1; k < len; k++) {
          if (nums[k] < nums[i] + nums[j]) {
            result++;
          } else {
            break;
          }
        }
      }
    }
    return result;
  }

}
