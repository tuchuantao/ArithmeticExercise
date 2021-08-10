package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by tuchuantao on 2021/8/10
 * Desc:
 */
public class Offer09 {
  /**
   * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
   * (若队列中没有元素，deleteHead操作返回 -1 )
   *
   * 示例 1：
   * 输入：
   * ["CQueue","appendTail","deleteHead","deleteHead"]
   * [[],[3],[],[]]
   * 输出：[null,null,3,-1]
   *
   * 示例 2：
   * 输入：
   * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
   * [[],[],[5],[2],[],[]]
   * 输出：[null,-1,null,null,5,2]
   *
   * 提示：
   * 1 <= values <= 10000
   * 最多会对appendTail、deleteHead 进行10000次调用
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */

  Deque<Integer> mStack1 = new LinkedList();
  Deque<Integer> mStack2 = new LinkedList();
  public Offer09() {
  }

  public void appendTail(int value) {
    mStack2.push(value);
  }

  public int deleteHead() {
    if (mStack1.isEmpty()) {
      while (!mStack2.isEmpty()) {
        mStack1.push(mStack2.pop());
      }
    }
    return mStack1.isEmpty() ? -1 : mStack1.pop();
  }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
