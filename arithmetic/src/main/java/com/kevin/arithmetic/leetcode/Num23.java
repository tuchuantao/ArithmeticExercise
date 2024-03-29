package com.kevin.arithmetic.leetcode;

import java.util.List;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/9/9
 * Desc:
 */
public class Num23 {
  /**
   * 给你一个链表数组，每个链表都已经按升序排列。
   * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
   *
   * 示例 1：
   * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
   * 输出：[1,1,2,3,4,4,5,6]
   * 解释：链表数组如下：
   * [
   *   1->4->5,
   *   1->3->4,
   *   2->6
   * ]
   * 将它们合并到一个有序链表中得到。
   * 1->1->2->3->4->4->5->6
   *
   * 示例 2：
   * 输入：lists = []
   * 输出：[]
   *
   * 示例 3：
   * 输入：lists = [[]]
   * 输出：[]
   *
   * 提示：
   * k == lists.length
   * 0 <= k <= 10^4
   * 0 <= lists[i].length <= 500
   * -10^4 <= lists[i][j] <= 10^4
   * lists[i] 按 升序 排列
   * lists[i].length 的总和不超过 10^4
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode preHead = new ListNode();
    ListNode cur = preHead;
    int len = lists.length;
    while (true) {
      int minIndex = -1;
      for (int i = 0; i < len; i++) {
        if (lists[i] != null) {
          if (minIndex == -1 || lists[i].val < lists[minIndex].val) {
            minIndex = i;
          }
        }
      }
      if (minIndex == -1) {
        break;
      } else {
        cur.next = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        cur = cur.next;
      }
    }
    return preHead.next;
  }

  public static void main(String[] args) {
    ListNode head1 = ListNode.create(new int[]{1, 4, 5});
    ListNode head2 = ListNode.create(new int[]{1, 3, 4});
    ListNode head3 = ListNode.create(new int[]{2, 6});
    new Num23().mergeKLists(new ListNode[]{head1, head2, head3});
  }
}
