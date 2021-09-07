package com.kevin.arithmetic.leetcode;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/9/7
 * Desc:
 */
public class Num86 {
  /**
   * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
   * 你应当 保留 两个分区中每个节点的初始相对位置。
   *
   * 示例 1：
   * 输入：head = [1,4,3,2,5,2], x = 3
   * 输出：[1,2,2,4,3,5]
   *
   * 示例 2：
   * 输入：head = [2,1], x = 2
   * 输出：[1,2]
   *
   * 提示：
   * 链表中节点的数目在范围 [0, 200] 内
   * -100 <= Node.val <= 100
   * -200 <= x <= 200
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/partition-list
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public ListNode partition(ListNode head, int x) {
    ListNode maxHead = null;
    ListNode maxCur = null;
    ListNode preHead = new ListNode(x - 1);
    preHead.next = head;
    ListNode cur = preHead;
    ListNode pre = null;
    while (cur != null) {
      if (cur.val >= x) {
        pre.next = cur.next;
        cur.next = null;
        if (maxCur == null) {
          maxHead = cur;
          maxCur = cur;
        } else {
          maxCur.next = cur;
          maxCur = cur;
        }
        cur = pre.next;
      } else {
        pre = cur;
        cur = cur.next;
      }
    }
    pre.next = maxHead;
    return preHead.next;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.create(new int[]{1, 4, 3, 2, 5, 2});
    new Num86().partition(head, 3);
  }
}
