package com.kevin.arithmetic.leetcode;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/8/30
 * Desc:
 */
public class Num143 {
  /**
   * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
   * L0→ L1→ … → Ln-1→ Ln
   * 请将其重新排列后变为：
   * L0→Ln→L1→Ln-1→L2→Ln-2→ …
   * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
   *
   * 示例 1:
   * 输入: head = [1,2,3,4]
   * 输出: [1,4,2,3]
   *
   * 示例 2:
   * 输入: head = [1,2,3,4,5]
   * 输出: [1,5,2,4,3]
   *
   * 提示：
   * 链表的长度范围为 [1, 5 * 10^4]
   * 1 <= node.val <= 1000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/reorder-list
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public void reorderList(ListNode head) {
    // 1、找到中间节点
    // 2、逆序后半链表
    // 3、重新排列
    if (head == null || head.next == null) {
      return;
    }
    // 1、寻找中间节点
    ListNode oneStep = head;
    ListNode twoStep = head;
    while (twoStep.next != null && twoStep.next.next != null) {
      oneStep = oneStep.next;
      twoStep = twoStep.next.next;
    }

    // 2、逆序后半链表
    ListNode pre = null;
    ListNode cur = oneStep.next;
    oneStep.next = null;
    while (cur != null) {
      ListNode temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
    }

    // 3、合并链表
    ListNode newHead = head;
    ListNode temp;
    while (newHead != null && pre != null) {
      temp = newHead.next;
      newHead.next = pre;
      newHead = temp;
      temp = pre.next;
      pre.next = newHead;
      pre = temp;
    }
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    new Num143().reorderList(node1);
  }

  public void reorderList1(ListNode head) {
    if (head == null) {
      return;
    }

    // 获得中间节点
    ListNode mid = findMid(head);

    // 中间节点之后的部分进行反转
    ListNode head2 = mid.next;
    mid.next = null;
    head2 = reverseList(head2);

    // 合并
    ListNode head1 = head;
    mergeList(head1, head2);
  }

  // LeetCode 876
  private ListNode findMid(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast= fast.next.next;
    }
    return slow;
  }

  // LeetCode 206
  private ListNode reverseList(ListNode head){
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode nextNode = cur.next;
      cur.next = prev;
      prev =cur;
      cur = nextNode;
    }
    return prev;
  }


  private void mergeList(ListNode head1, ListNode head2) {
    ListNode next1 = null;
    ListNode next2 = null;
    while (head1 != null && head2 != null) {
      next1 = head1.next;
      next2 = head2.next;

      head1.next = head2;
      head1 = next1;

      head2.next = head1;
      head2 = next2;
    }
  }
}
