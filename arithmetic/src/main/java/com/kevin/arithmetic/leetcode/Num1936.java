package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/7/19
 * Desc:
 */
public class Num1936 {

  /**
   * 给你一个 严格递增 的整数数组 rungs ，用于表示梯子上每一台阶的 高度 。当前你正站在高度为 0 的地板上，并打算爬到最后一个台阶。
   * <p>
   * 另给你一个整数 dist 。每次移动中，你可以到达下一个距离你当前位置（地板或台阶）不超过dist高度的台阶。当然，你也可以在任何正 整数 高度处插入尚不存在的新台阶。
   * <p>
   * 返回爬到最后一阶时必须添加到梯子上的 最少台阶数。
   * <p>
   * <p>
   * <p>
   * 示例 1：
   * <p>
   * 输入：rungs = [1,3,5,10], dist = 2
   * 输出：2
   * 解释：
   * 现在无法到达最后一阶。
   * 在高度为 7 和 8 的位置增设新的台阶，以爬上梯子。
   * 梯子在高度为 [1,3,5,7,8,10] 的位置上有台阶。
   * 示例 2：
   * <p>
   * 输入：rungs = [3,6,8,10], dist = 3
   * 输出：0
   * 解释：
   * 这个梯子无需增设新台阶也可以爬上去。
   * 示例 3：
   * <p>
   * 输入：rungs = [3,4,6,7], dist = 2
   * 输出：1
   * 解释：
   * 现在无法从地板到达梯子的第一阶。
   * 在高度为 1 的位置增设新的台阶，以爬上梯子。
   * 梯子在高度为 [1,3,4,6,7] 的位置上有台阶。
   * 示例 4：
   * <p>
   * 输入：rungs = [5], dist = 10
   * 输出：0
   * 解释：这个梯子无需增设新台阶也可以爬上去。
   * <p>
   * <p>
   * 提示：
   * <p>
   * 1 <= rungs.length <= 10^5
   * 1 <= rungs[i] <= 10^9
   * 1 <= dist <= 10^9
   * rungs 严格递增
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/add-minimum-number-of-rungs
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int addRungs(int[] rungs, int dist) {
    int lastHeight = 0;
    int count = 0;
    int len = rungs.length;
    for (int i = 0; i < len; i++) {
      if (rungs[i] - dist > lastHeight) {
        int distance = rungs[i] - lastHeight - dist; // - dist  两倍的距离，其实只需要搭一个桥
        count += (distance / dist);
        if (distance % dist != 0) {
          count++;
        }
      }
      lastHeight = rungs[i];
    }
    return count;
  }
}
