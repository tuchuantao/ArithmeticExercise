package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by tuchuantao on 2022/1/5
 * Desc: 数据流中的第 K 大元素
 */
public class Num703 {
  /**
   * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
   * 请实现 KthLargest类：
   * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
   * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
   *
   * 示例：
   * 输入：
   * ["KthLargest", "add", "add", "add", "add", "add"]
   * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
   * 输出：
   * [null, 4, 5, 5, 8, 8]
   *
   * 解释：
   * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
   * kthLargest.add(3);   // return 4
   * kthLargest.add(5);   // return 5
   * kthLargest.add(10);  // return 5
   * kthLargest.add(9);   // return 8
   * kthLargest.add(4);   // return 8
   * 
   * 提示：
   * 1 <= k <= 10^4
   * 0 <= nums.length <= 10^4
   * -10^4 <= nums[i] <= 10^4
   * -10^4 <= val <= 10^4
   * 最多调用 add 方法 10^4 次
   * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  static class KthLargest {
    private int mK;
    private List<Integer> mList = new ArrayList();

//    public KthLargest(int k, int[] nums) {
//      mK = k;
//      Arrays.sort(nums);
//      int len = nums.length;
//      for (int i = len - 1; i >= 0; i--) {
//        mList.add(nums[i]);
//      }
//    }
//
//    public int add(int val) {
//      if (mList.size() >= mK && val <= mList.get(mK - 1)) {
//        return mList.get(mK - 1);
//      } else {
//        int beforeSize = mList.size();
//        for (int i = 0; i < beforeSize; i++) {
//          if (val > mList.get(i)) {
//            mList.add(i, val);
//            break;
//          }
//        }
//        if (beforeSize == mList.size()) {
//          mList.add(val);
//        }
//      }
//      return mList.get(mK - 1);
//    }
//  }

    //   优先队列
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
      this.k = k;
      pq = new PriorityQueue<Integer>();
      for (int x : nums) {
        add(x);
      }
    }

    public int add(int val) {
      pq.offer(val);
      if (pq.size() > k) {
        pq.poll();
      }
      return pq.peek();
    }
  }


  public static void main(String[] args) {
    KthLargest obj = new KthLargest(3, new int[]{4, 5, 8, 2});
    System.out.println(obj.add(3));
    System.out.println(obj.add(5));
    System.out.println(obj.add(10));
    System.out.println(obj.add(9));
    System.out.println(obj.add(4));
  }
}
