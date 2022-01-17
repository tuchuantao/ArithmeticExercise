package com.kevin.arithmetic.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tuchuantao on 2022/1/11
 * Desc: 数组中两个数的最大异或值
 */
public class Num421 {
  /**
   * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
   * 进阶：你可以在 O(n) 的时间解决这个问题吗？
   *
   * 示例 1：
   * 输入：nums = [3,10,5,25,2,8]
   * 输出：28
   * 解释：最大运算结果是 5 XOR 25 = 28.
   *
   * 示例 2：
   * 输入：nums = [0]
   * 输出：0
   *
   * 示例 3：
   * 输入：nums = [2,4]
   * 输出：6
   *
   * 示例 4：
   * 输入：nums = [8,10,2]
   * 输出：10
   *
   * 示例 5：
   * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
   * 输出：127
   *
   * 提示：
   * 1 <= nums.length <= 2 * 10^4
   * 0 <= nums[i] <= 2^31 - 1
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  // 最高位的二进制位编号为 30
  static final int HIGH_BIT = 30;

  public int findMaximumXOR1(int[] nums) { // x = a ^ b 等价于 a = x ^ b
    int x = 0;
    for (int k = HIGH_BIT; k >= 0; --k) {
      Set<Integer> seen = new HashSet<Integer>();
      // 将所有的 pre^k(a_j) 放入哈希表中
      for (int num : nums) {
        // 如果只想保留从最高位开始到第 k 个二进制位为止的部分
        // 只需将其右移 k 位
        seen.add(num >> k);
      }

      // 目前 x 包含从最高位开始到第 k+1 个二进制位为止的部分
      // 我们将 x 的第 k 个二进制位置为 1，即为 x = x*2+1
      int xNext = x * 2 + 1;
      boolean found = false;

      // 枚举 i
      for (int num : nums) {
        if (seen.contains(xNext ^ (num >> k))) {
          found = true;
          break;
        }
      }

      if (found) {
        x = xNext;
      } else {
        // 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0
        // 即为 x = x*2
        x = xNext - 1;
      }
    }
    return x;
  }


  // 字典树的根节点
  Trie root = new Trie();

  /**
   * 如果 nums[i]的第 k 个二进制位为 0，那么我们应当往表示 1 的子节点走，这样 0 ^ 1 = 1，可以使得 x 的第 k 个二进制位为 1。如果不存在表示 1 的子节点，那么我们只能往表示 0 的子节点走，x 的第 k 个二进制位为 0；
   * 如果 nums[i]的第 k 个二进制位为 1，那么我们应当往表示 0 的子节点走，这样 1 ^ 0 = 1，可以使得 x 的第 k 个二进制位为 1。如果不存在表示 0 的子节点，那么我们只能往表示 1 的子节点走，x 的第 k 个二进制位为 0。
   */
  public int findMaximumXOR(int[] nums) { // 字典树
    int n = nums.length;
    int x = 0;
    for (int i = 1; i < n; ++i) {
      // 将 nums[i-1] 放入字典树，此时 nums[0 .. i-1] 都在字典树中
      add(nums[i - 1]);
      // 将 nums[i] 看作 ai，找出最大的 x 更新答案
      x = Math.max(x, check(nums[i]));
    }
    return x;
  }

  public void add(int num) {
    Trie cur = root;
    for (int k = HIGH_BIT; k >= 0; --k) {
      int bit = (num >> k) & 1;
      if (bit == 0) {
        if (cur.left == null) {
          cur.left = new Trie();
        }
        cur = cur.left;
      }
      else {
        if (cur.right == null) {
          cur.right = new Trie();
        }
        cur = cur.right;
      }
    }
  }

  public int check(int num) {
    Trie cur = root;
    int x = 0;
    for (int k = HIGH_BIT; k >= 0; --k) {
      int bit = (num >> k) & 1;
      if (bit == 0) {
        // a_i 的第 k 个二进制位为 0，应当往表示 1 的子节点 right 走
        if (cur.right != null) {
          cur = cur.right;
          x = x * 2 + 1;
        } else {
          cur = cur.left;
          x = x * 2;
        }
      } else {
        // a_i 的第 k 个二进制位为 1，应当往表示 0 的子节点 left 走
        if (cur.left != null) {
          cur = cur.left;
          x = x * 2 + 1;
        } else {
          cur = cur.right;
          x = x * 2;
        }
      }
    }
    return x;
  }

class Trie {
  // 左子树指向表示 0 的子节点
  Trie left = null;
  // 右子树指向表示 1 的子节点
  Trie right = null;
}

}
