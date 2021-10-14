package com.kevin.arithmetic.lintcode;

/**
 * Created by tuchuantao on 2021/10/14
 * Desc: 递增的数
 */
public class Num330 {
  /**
   * 描述
   * 给你一个数字N,返回最大的比N小的且每一位是连续递增的数字
   *
   * 1 ≤ N ≤ 10^11
   *
   * 样例
   * 输入:998
   * 输出:789
   *
   * 输入:1341
   * 输出:1289
   *
   * 输入:100
   * 输出:89
   */
  public long getIncreasingNumber(long n) {
    if (n < 10) {
      return n;
    }
    char[] arr = String.valueOf(n).toCharArray();
    int len = arr.length;
    int index = 0;
    while (index < len - 1 && arr[index] < arr[index + 1]) { // 找到非递增点
      index++;
    }
    arr[index] -= 1; // 高位减 1  不包含本身
    if (index < len) {
      while (index > 0 && arr[index] <= arr[index - 1]) {
        arr[index - 1] -= 1;
        index--;
      }
      if (arr[index] - '0' <= 9 - len + index + 1) {
        index++;
      }
      while (index < len) {
        arr[index] = String.valueOf(9 - len + index + 1).toCharArray()[0];
        index++;
      }
    }
    return Long.parseLong(String.valueOf(arr));
  }


  public static void main(String[] args) {
    long result = new Num330().getIncreasingNumber(123456789);
    System.out.println("result=" + result);
  }
}
