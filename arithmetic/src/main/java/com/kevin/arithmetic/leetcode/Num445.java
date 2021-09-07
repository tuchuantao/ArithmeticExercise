package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.LinkedList;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/9/7
 * Desc:
 */
public class Num445 {
  /**
   * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
   * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
   *
   * 示例1：
   * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
   * 输出：[7,8,0,7]
   *
   * 示例2：
   * 输入：l1 = [2,4,3], l2 = [5,6,4]
   * 输出：[8,0,7]
   *
   * 示例3：
   * 输入：l1 = [0], l2 = [0]
   * 输出：[0]
   *
   * 提示：
   * 链表的长度范围为 [1, 100]
   * 0 <= node.val <= 9
   * 输入数据保证链表代表的数字无前导 0
   *
   * 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) { // 1、翻转
    l1 = reverse(l1);
    l2 = reverse(l2);
    ListNode head = l1;
    ListNode pre = null;
    int last = 0;
    while (l1 != null || l2 != null) {
      int sum = last;
      if (l1 == null) {
        l1 = new ListNode(0);
        pre.next = l1;
      } else {
        sum += l1.val;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }
      last = sum / 10;
      sum = sum % 10;
      l1.val = sum;

      pre = l1;
      l1 = l1.next;
    }
    if (last == 1) {
      ListNode node = new ListNode(1);
      pre.next = node;
    }
    return reverse(head);
  }

  private ListNode reverse(ListNode head) {
    ListNode cur = head;
    ListNode pre = null;
    ListNode temp;
    while (cur != null) {
      temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
    }
    return pre;
  }


  public ListNode addTwoNumbers11(ListNode l1, ListNode l2) { // 栈
    Deque<Integer> stack1 = new LinkedList<Integer>();
    Deque<Integer> stack2 = new LinkedList<Integer>();
    while (l1 != null) {
      stack1.push(l1.val);
      l1 = l1.next;
    }
    while (l2 != null) {
      stack2.push(l2.val);
      l2 = l2.next;
    }
    int carry = 0;
    ListNode ans = null;
    while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
      int a = stack1.isEmpty() ? 0 : stack1.pop();
      int b = stack2.isEmpty() ? 0 : stack2.pop();
      int cur = a + b + carry;
      carry = cur / 10;
      cur %= 10;
      ListNode curnode = new ListNode(cur);
      curnode.next = ans;
      ans = curnode;
    }
    return ans;
  }
}
