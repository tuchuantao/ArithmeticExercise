package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/9/7
 * Desc:
 */
public class Num1019 {
  /**
   * 给出一个以头节点head作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
   * 每个节点都可能有下一个更大值（next larger value）：对于node_i，如果其next_larger(node_i)是node_j.val，
   * 那么就有j > i且node_j.val > node_i.val，而j是可能的选项中最小的那个。如果不存在这样的j，那么下一个更大值为0。
   * 返回整数答案数组answer，其中answer[i] = next_larger(node_{i+1})。
   * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为2，第二个节点值为 1，第三个节点值为5 。
   *
   * 示例 1：
   * 输入：[2,1,5]
   * 输出：[5,5,0]
   *
   * 示例 2：
   * 输入：[2,7,4,3,5]
   * 输出：[7,0,5,5,0]
   *
   * 示例 3：
   * 输入：[1,7,5,1,9,2,5,1]
   * 输出：[7,9,9,9,0,5,0,0]
   *
   * 提示：
   * 对于链表中的每个节点，1 <= node.val<= 10^9
   * 给定列表的长度在 [0, 10000]范围内
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/next-greater-node-in-linked-list
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] nextLargerNodes(ListNode head) {
    head = reverse(head); // 反转链表
    int count = head.val;
    head = head.next;
    int[] arr = new int[count];
    count--;
    Deque<Integer> deque = new LinkedList(); // 单调递增
    while (head != null) {
      if (deque.isEmpty()) {
        arr[count--] = 0;
        deque.addLast(head.val);
      } else {
        while (!deque.isEmpty() && head.val >= deque.getLast()) {
          deque.removeLast();
        }
        if (deque.isEmpty()) {
          arr[count--] = 0;
        } else {
          arr[count--] = deque.getLast();
        }
        deque.addLast(head.val);
      }

      head = head.next;
    }
    return arr;
  }

  public ListNode reverse(ListNode head) {
    ListNode cur = head;
    ListNode pre = null;
    ListNode temp = null;
    int count = 0;
    while (cur != null) {
      temp = cur.next;
      cur.next = pre;
      pre = cur;
      cur = temp;
      count++;
    }
    ListNode newHead = new ListNode(count);
    newHead.next = pre;
    return newHead;
  }

  public static void main(String[] args) {
    ListNode one = new ListNode(2);
    ListNode two = new ListNode(1);
    ListNode three = new ListNode(5);
    one.next = two;
    two.next = three;
    new Num1019().nextLargerNodes(one);
  }
}
