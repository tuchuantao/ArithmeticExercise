package com.kevin.arithmetic.leetcode;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/8/11
 * Desc:
 */
public class Num206AndOffer24 {
  /**
   * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
   * <p>
   * 示例:
   * 输入: 1->2->3->4->5->NULL
   * 输出: 5->4->3->2->1->NULL
   * <p>
   * 限制：
   * 0 <= 节点个数 <= 5000
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode currPoint = head;
    ListNode nextPoint = currPoint.next;
    head.next = null;
    ListNode tempPoint;
    while (nextPoint != null) {
      tempPoint = nextPoint.next;
      nextPoint.next = currPoint;
      currPoint = nextPoint;
      nextPoint = tempPoint;
    }
    return currPoint;
  }
}
