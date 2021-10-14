package com.kevin.arithmetic.leetcode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by tuchuantao on 2021/10/14
 * Desc: 滑动窗口最大值
 */
public class Num239 {
  /**
   * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
   * 返回滑动窗口中的最大值。
   *
   * 示例 1：
   * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
   * 输出：[3,3,5,5,6,7]
   * 解释：
   * 滑动窗口的位置                最大值
   * ---------------               -----
   * [1  3  -1] -3  5  3  6  7       3
   *  1 [3  -1  -3] 5  3  6  7       3
   *  1  3 [-1  -3  5] 3  6  7       5
   *  1  3  -1 [-3  5  3] 6  7       5
   *  1  3  -1  -3 [5  3  6] 7       6
   *  1  3  -1  -3  5 [3  6  7]      7
   *
   * 示例 2：
   * 输入：nums = [1], k = 1
   * 输出：[1]
   *
   * 示例 3：
   * 输入：nums = [1,-1], k = 1
   * 输出：[1,-1]
   *
   * 示例 4：
   * 输入：nums = [9,11], k = 2
   * 输出：[11]
   *
   * 示例 5：
   * 输入：nums = [4,-2], k = 2
   * 输出：[4]
   *
   * 提示：
   * 1 <= nums.length <= 10^5
   * -10^4<= nums[i] <= 10^4
   * 1 <= k <= nums.length
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] maxSlidingWindow1(int[] nums, int k) { // 超时
    Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2 - o1;  // o1 - o2: 递增    o2 - o1: 递减
      }
    });
    int len = nums.length;
    int[] resultArr = new int[len - k + 1];
    for (int i = 0; i < k; i++) {
      queue.add(nums[i]);
    }
    resultArr[0] = queue.peek();
    int index = 1;
    for (int i = k; i < len; i++) {
      queue.add(nums[i]);
      queue.remove(nums[i - k]);
      resultArr[index] = queue.peek();
      index++;
    }
    return resultArr;
  }

  public int[] maxSlidingWindow2(int[] nums, int k) { // 优先队列，同时保存下标
    int n = nums.length;
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
      public int compare(int[] pair1, int[] pair2) {
        return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
      }
    });
    for (int i = 0; i < k; ++i) {
      pq.offer(new int[]{nums[i], i});
    }
    int[] ans = new int[n - k + 1];
    ans[0] = pq.peek()[0];
    for (int i = k; i < n; ++i) {
      pq.offer(new int[]{nums[i], i});
      while (pq.peek()[1] <= i - k) { // 只处理最大堆的根节点
        pq.poll();
      }
      ans[i - k + 1] = pq.peek()[0];
    }
    return ans;
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    Deque<Integer> deque = new LinkedList<Integer>(); // 单调递减队列，只保存下标
    for (int i = 0; i < k; ++i) {
      while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.offerLast(i);
    }

    int[] ans = new int[n - k + 1];
    ans[0] = nums[deque.peekFirst()];
    for (int i = k; i < n; ++i) {
      while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
        deque.pollLast();
      }
      deque.offerLast(i);
      while (deque.peekFirst() <= i - k) {
        deque.pollFirst();
      }
      ans[i - k + 1] = nums[deque.peekFirst()];
    }
    return ans;
  }
}
