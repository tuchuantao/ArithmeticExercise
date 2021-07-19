package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/7/19
 * Desc:
 */
public class Num118 {

  /**
   * 给定一个非负整数numRows，生成杨辉三角的前numRows行。
   *
   *
   *
   * 在杨辉三角中，每个数是它左上方和右上方的数的和。
   *
   * 示例:
   *
   * 输入: 5
   * 输出:
   * [
   *      [1],
   *     [1,1],
   *    [1,2,1],
   *   [1,3,3,1],
   *  [1,4,6,4,1]
   * ]
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/pascals-triangle
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList();
    for (int i = 1; i <= numRows; i++) {
      List<Integer> itemList =  new ArrayList();
      itemList.add(1);
      if (i != 1) {
        List<Integer> dp = result.get(i - 1 - 1);
        for (int j = 1; j < i - 1; j++) {
          itemList.add(dp.get(j - 1) + dp.get(j));
        }
        itemList.add(1);
      }
      result.add(itemList);
    }
    return result;
  }
}
