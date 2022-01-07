package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Collections;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/9/7
 * Desc: 链表排序
 */
public class Num148 {
  /**
   * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
   *
   * 进阶：
   * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
   *
   * 示例 1：
   * 输入：head = [4,2,1,3]
   * 输出：[1,2,3,4]
   *
   * 示例 2：
   * 输入：head = [-1,5,3,4,0]
   * 输出：[-1,0,3,4,5]
   *
   * 示例 3：
   * 输入：head = []
   * 输出：[]
   *
   * 提示：
   * 链表中节点的数目在范围 [0, 5 * 10^4] 内
   * -10^5 <= Node.val <= 10^5
   */
  public ListNode sortList(ListNode head) { // 使用辅助空间
    if (head == null || head.next == null) {
      return head;
    }
    ArrayList<ListNode> list = new ArrayList();
    while (head != null) {
      list.add(head);
      head = head.next;
    }
    Collections.sort(list, (o1, o2) -> o1.val - o2.val);
    int len = list.size();
    for (int i = 0; i < len - 1; i++) {
      list.get(i).next = list.get(i + 1);
    }
    list.get(len - 1).next = null;
    return list.get(0);
  }
}
