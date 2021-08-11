package com.kevin.arithmetic.leetcode;

import java.util.Stack;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/8/11
 * Desc:
 */
public class Offer06 {
  /**
   * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
   *
   * 示例 1：
   * 输入：head = [1,3,2]
   * 输出：[2,3,1]
   *
   * 限制：
   * 0 <= 链表长度 <= 10000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] reversePrint(ListNode head) {
    Stack<ListNode> stack = new Stack();
    while (head != null) {
      stack.push(head);
      head = head.next;
    }
    if (!stack.isEmpty()) {
      int[] arr = new int[stack.size()];
      for (int i = 0; i < arr.length; i++) {
        arr[i] = stack.pop().val;
      }
      return arr;
    }
    return new int[0];
  }
}
