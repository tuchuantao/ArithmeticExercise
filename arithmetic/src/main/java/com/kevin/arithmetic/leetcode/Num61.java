package com.kevin.arithmetic.leetcode;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/9/7
 * Desc:
 */
public class Num61 {
  /**
   * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动k个位置。
   *
   * 示例 1：
   * 输入：head = [1,2,3,4,5], k = 2
   * 输出：[4,5,1,2,3]
   *
   * 示例 2：
   * 输入：head = [0,1,2], k = 4
   * 输出：[2,0,1]
   *
   * 提示：
   *
   * 链表中节点的数目在范围 [0, 500] 内
   * -100 <= Node.val <= 100
   * 0 <= k <= 2 * 109
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/rotate-list
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public ListNode rotateRight11(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) {
      return head;
    }
    int len = 0;
    ListNode temp = head;
    while (temp != null) {
      len++;
      temp = temp.next;
    }
    k = k % len;
    if (k == 0) {
      return head;
    }

    ListNode node = head;
    for (int i = 1; i < len - k; i++) {
      node = node.next;
    }

    ListNode newHead = node.next;
    node.next = null;
    ListNode cur = newHead;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = head;

    return newHead;
  }

  public ListNode rotateRight(ListNode head, int k) { // 闭合为环，然后断开
    if (head == null || head.next == null || k == 0) {
      return head;
    }
    ListNode temp = head;
    int len = 1;
    while (temp.next != null) {
      len++;
      temp = temp.next;
    }
    temp.next = head;
    k = len - k % len;
    temp = head;
    while (k-- > 0) {
      temp = temp.next;
    }
    ListNode newHead = temp.next;
    temp.next = null;
    return newHead;
  }

}
