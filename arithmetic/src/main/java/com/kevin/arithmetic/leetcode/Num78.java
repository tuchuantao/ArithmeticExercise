package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/11/17
 * Desc: 子集
 */
public class Num78 {
  /**
   * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
   * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
   *
   * 示例 1：
   * 输入：nums = [1,2,3]
   * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
   *
   * 示例 2：
   * 输入：nums = [0]
   * 输出：[[],[0]]
   * 
   * 提示：
   * 1 <= nums.length <= 10
   * -10 <= nums[i] <= 10
   * nums 中的所有元素 互不相同
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/subsets
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<List<Integer>> subsets(int[] nums) { // 动态规划
    int len = nums.length;
    List<List<Integer>> ansList = new ArrayList();
    ansList.add(new ArrayList<>());
    int listSize;
    for (int i = 0; i < len; i++) {
      listSize = ansList.size();
      for (int j = 0; j < listSize; j++) {
        List<Integer> list =  new ArrayList(ansList.get(j));
        list.add(nums[i]);
        ansList.add(list);
      }
    }
    return ansList;
  }
}
