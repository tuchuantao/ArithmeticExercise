package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

import com.kevin.arithmetic.linkedlist.ListNode;

/**
 * Created by tuchuantao on 2021/9/7
 * Desc:
 */
public class Num1171 {
  /**
   * 给你一个链表的头节点head，请你编写代码，反复删去链表中由 总和值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
   * 删除完毕后，请你返回最终结果链表的头节点。
   * 你可以返回任何满足题目要求的答案。
   * （注意，下面示例中的所有序列，都是对ListNode对象序列化的表示。）
   *
   * 示例 1：
   * 输入：head = [1,2,-3,3,1]
   * 输出：[3,1]
   * 提示：答案 [1,2,1] 也是正确的。
   *
   * 示例 2：
   * 输入：head = [1,2,3,-3,4]
   * 输出：[1,2,4]
   *
   * 示例 3：
   * 输入：head = [1,2,3,-3,-2]
   * 输出：[1]
   *
   * 提示：
   * 给你的链表中可能有 1 到1000个节点。
   * 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public ListNode removeZeroSumSublists(ListNode head) { // 前缀和
    HashMap<Integer, ListNode> preSumMap = new HashMap();
    ListNode pre = new ListNode(0);
    pre.next = head;
    ListNode temp = pre; // 从新的头节点开始，因为之前的头节点有可能被删除
    int sum = 0;
    while (temp != null) {
      sum += temp.val;
      preSumMap.put(sum, temp);
      temp = temp.next;
    }

    sum = 0;
    temp = pre;
    while (temp != null) {
      sum += temp.val;
      temp.next = preSumMap.get(sum).next;
      temp = temp.next;
    }

    return pre.next;
  }
}
