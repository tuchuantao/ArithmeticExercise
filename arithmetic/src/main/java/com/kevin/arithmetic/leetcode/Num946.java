package com.kevin.arithmetic.leetcode;

import java.util.Stack;

/**
 * Created by tuchuantao on 2021/11/29
 * Desc: 验证栈序列
 */
public class Num946 {
  /**
   * 给定pushed和popped两个序列，每个序列中的值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回
   * false。
   *
   * 示例 1：
   * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
   * 输出：true
   * 解释：我们可以按以下顺序执行：
   * push(1), push(2), push(3), push(4), pop() -> 4,
   * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
   *
   * 示例 2：
   * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
   * 输出：false
   * 解释：1 不能在 2 之前弹出。
   *
   * 提示：
   * 1 <= pushed.length <= 1000
   * 0 <= pushed[i] <= 1000
   * pushed 的所有元素 互不相同
   * popped.length == pushed.length
   * popped 是 pushed 的一个排列
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/validate-stack-sequences
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   * @param pushed
   * @param popped
   * @return
   */
  public boolean validateStackSequences(int[] pushed, int[] popped) {
    int len = pushed.length;
    if (len <= 2) {
      return true;
    }
    int popIndex = 0;
    Stack<Integer> stack = new Stack();
    for (int i = 0; i < len; i++) {
      stack.push(pushed[i]);
      while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
        stack.pop();
        popIndex++;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    boolean result = new Num946().validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1});
    System.out.println("result=" + result);
  }
}
