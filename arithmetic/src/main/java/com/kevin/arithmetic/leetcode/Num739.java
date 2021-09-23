package com.kevin.arithmetic.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/9/23
 * Desc:
 */
public class Num739 {
  /**
   * 请根据每日 气温 列表 temperatures，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。
   *
   * 示例 1:
   * 输入: temperatures = [73,74,75,71,69,72,76,73]
   * 输出:[1,1,4,2,1,1,0,0]
   *
   * 示例 2:
   * 输入: temperatures = [30,40,50,60]
   * 输出:[1,1,1,0]
   *
   * 示例 3:
   * 输入: temperatures = [30,60,90]
   * 输出: [1,1,0]
   *
   * 提示：
   * 1 <=temperatures.length <= 10^5
   * 30 <=temperatures[i]<= 100
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/daily-temperatures
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] dailyTemperatures(int[] temperatures) {
    int len = temperatures.length;
    int[] result = new int[len];
    if (len == 1) {
      return result;
    }

    Deque<int[]> deque = new LinkedList();
    for (int i = 0; i < len; i++) {
      if (i < len - 1 && temperatures[i] < temperatures[i + 1]) {
        result[i] = 1;
      }
      while (!deque.isEmpty()) {
        int[] top = deque.peek();
        if (temperatures[i] > top[0]) {
          result[top[1]] = i - top[1];
          deque.removeFirst();
        } else {
          break;
        }
      }
      if (i < len - 1 && temperatures[i] >= temperatures[i + 1]) {
        deque.addFirst(new int[]{temperatures[i], i});
      }
    }
    return result;
  }

  public int[] dailyTemperatures11(int[] temperatures) {
    int length = temperatures.length;
    int[] ans = new int[length];
    Deque<Integer> stack = new LinkedList<Integer>();
    for (int i = 0; i < length; i++) {
      int temperature = temperatures[i];
      while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
        int prevIndex = stack.pop();
        ans[prevIndex] = i - prevIndex;
      }
      stack.push(i);
    }
    return ans;
  }
}
