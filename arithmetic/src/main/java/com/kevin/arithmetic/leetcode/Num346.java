package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuchuantao on 2022/1/5
 * Desc: 滑动窗口的平均值
 */
public class Num346 {
  /**
   * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
   * 实现 MovingAverage 类：
   * MovingAverage(int size) 用窗口大小 size 初始化对象。
   * double next(int val)成员函数 next每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，即滑动窗口里所有数字的平均值。
   * 
   * 示例：
   * 输入：
   * inputs = ["MovingAverage", "next", "next", "next", "next"]
   * inputs = [[3], [1], [10], [3], [5]]
   * 输出：
   * [null, 1.0, 5.5, 4.66667, 6.0]
   *
   * 解释：
   * MovingAverage movingAverage = new MovingAverage(3);
   * movingAverage.next(1); // 返回 1.0 = 1 / 1
   * movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
   * movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
   * movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
   *
   * 提示：
   * 1 <= size <= 1000
   * -10^5 <= val <= 10^5
   * 最多调用 next 方法 10^4 次
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/qIsx9U
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  class MovingAverage {

    int mSize;
    double mSum;
    List<Integer> mList;

    public MovingAverage(int size) {
      mSize = size;
      mList = new ArrayList();
    }

    public double next(int val) {
      mList.add(val);
      mSum += val;
      if (mList.size() > mSize) {
        mSum -= mList.get(mList.size() - mSize - 1);
      }
      return mSum / (mList.size() >= mSize ? mSize : mList.size());
    }
  }
}
