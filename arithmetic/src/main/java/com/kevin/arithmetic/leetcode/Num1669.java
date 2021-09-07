package com.kevin.arithmetic.leetcode;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/9/7
 * Desc:
 */
public class Num1669 {
  /**
   * 给你两个链表list1 和list2，它们包含的元素分别为n 个和m 个。
   * 请你将list1中下标从 a 到 b 的全部节点都删除，并将list2接在被删除节点的位置。
   * 下图中蓝色边和节点展示了操作后的结果：
   * 请你返回结果链表的头指针。
   *
   * 示例 1：
   * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
   * 输出：[0,1,2,1000000,1000001,1000002,5]
   * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
   *
   * 示例 2：
   * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
   * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
   * 解释：上图中蓝色的边和节点为答案链表。
   *
   * 提示：
   * 3 <= list1.length <= 10^4
   * 1 <= a <= b < list1.length - 1
   * 1 <= list2.length <= 10^4
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    ListNode twoEnd = list2;
    while (twoEnd.next != null) {
      twoEnd = twoEnd.next;
    }
    ListNode preHead = new ListNode(a - 1);
    preHead.next = list1;
    ListNode cur = preHead;
    int index = 0;
    while (true) {
      if (index == a) {
        ListNode node = cur.next;
        cur.next = list2;
        cur = node;
      }
      if (index == b) {
        twoEnd.next = cur.next;
        return preHead.next;
      }
      cur = cur.next;
      index++;
    }
  }

  public static void main(String[] args) {
    ListNode list1 = ListNode.create(new int[]{0, 1, 2});
    ListNode list2 = ListNode.create(new int[]{10001, 10002, 10003});
    new Num1669().mergeInBetween(list1, 1, 1, list2);
  }
}
