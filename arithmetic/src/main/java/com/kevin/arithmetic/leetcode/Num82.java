package com.kevin.arithmetic.leetcode;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/9/7
 * Desc:
 */
public class Num82 {
  /**
   * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
   * 返回同样按升序排列的结果链表。
   *
   * 示例 1：
   * 输入：head = [1,2,3,3,4,4,5]
   * 输出：[1,2,5]
   *
   * 示例 2：
   * 输入：head = [1,1,1,2,3]
   * 输出：[2,3]
   *
   * 提示：
   * 链表中节点数目在范围 [0, 300] 内
   * -100 <= Node.val <= 100
   * 题目数据保证链表已经按升序排列
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode preHead = new ListNode(head.val - 1);
    preHead.next = head;
    ListNode cur = preHead;
    ListNode pre = null;
    while (cur != null && cur.next != null) {
      if (cur.val == cur.next.val) {
        int count = cur.val;
        while (cur != null && cur.val == count) {
          cur = cur.next;
        }
        pre.next = cur;
      } else {
        pre = cur;
        cur = cur.next;
      }
    }
    return preHead.next;
  }
}
