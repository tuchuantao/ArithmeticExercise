package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tuchuantao on 2021/11/23
 * Desc: 把数组排成最小的数
 */
public class Offer45 {
  /**
   * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
   *
   * 示例 1:
   * 输入: [10,2]
   * 输出: "102"
   *
   * 示例2:
   * 输入: [3,30,34,5,9]
   * 输出: "3033459"
   * 
   * 提示:
   * 0 < nums.length <= 100
   * 说明:
   * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
   * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String minNumber(int[] nums) { // 插入排序
    ArrayList<Integer> list = new ArrayList();
    int len = nums.length;
    list.add(nums[0]);
    for (int i = 1; i < len; i++) {
      int size = list.size();
      for (int j = 0; j < size; j++) {
        if (!compareNum(nums[i], list.get(j))) {
          list.add(j, nums[i]);
          break;
        }
      }
      if (list.size() == size) {
        list.add(nums[i]);
      }
    }
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < len; i++) {
      builder.append(list.get(i));
    }
    return builder.toString();
  }

  public boolean compareNum(int one, int two) {
    String strOne = new StringBuilder().append(one).append(two).toString();
    String strTwo = new StringBuilder().append(two).append(one).toString();
    return strOne.compareTo(strTwo) > 0;
  }

  public String minNumber2(int[] nums) { // 内置函数
    String[] strs = new String[nums.length];
    for(int i = 0; i < nums.length; i++)
      strs[i] = String.valueOf(nums[i]);
    Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
    StringBuilder res = new StringBuilder();
    for(String s : strs)
      res.append(s);
    return res.toString();
  }

}
