package com.kevin.arithmetic.leetcode;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/8/12
 * Desc:
 */
public class Num234 {
  /**
   * 请判断一个链表是否为回文链表。
   *
   * 示例 1:
   * 输入: 1->2
   * 输出: false
   *
   * 示例 2:
   * 输入: 1->2->2->1
   * 输出: true
   *
   * 进阶：
   * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
//  public boolean isPalindrome(ListNode head) {
//    int len = 0;
//    ListNode newHead = head;
//    while (newHead != null) {
//      len++;
//      newHead = newHead.next;
//    }
//
//  }

  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }

    // 找到前半部分链表的尾节点并反转后半部分链表
    ListNode firstHalfEnd = endOfFirstHalf(head);
    ListNode secondHalfStart = reverseList(firstHalfEnd.next);

    // 判断是否回文
    ListNode p1 = head;
    ListNode p2 = secondHalfStart;
    boolean result = true;
    while (result && p2 != null) {
      if (p1.val != p2.val) {
        result = false;
      }
      p1 = p1.next;
      p2 = p2.next;
    }

    // 还原链表并返回结果
    firstHalfEnd.next = reverseList(secondHalfStart);
    return result;
  }

  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

  private ListNode endOfFirstHalf(ListNode head) { // 快慢指针，寻找中间分隔
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
