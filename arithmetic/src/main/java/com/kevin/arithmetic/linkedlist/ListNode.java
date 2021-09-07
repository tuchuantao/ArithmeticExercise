package com.kevin.arithmetic.linkedlist;

/**
 * Created by tuchuantao on 2021/8/11
 * Desc:
 */
public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {}
  public ListNode(int x) { val = x; }

  public static ListNode create(int[] arr) {
    ListNode preHead = new ListNode();
    ListNode cur = preHead;
    for (int count : arr) {
      ListNode node = new ListNode(count);
      cur.next = node;
      cur = node;
    }
    return preHead.next;
  }
}
