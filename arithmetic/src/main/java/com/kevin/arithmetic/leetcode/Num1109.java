package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/9/1
 * Desc: 航班预订统计
 */
public class Num1109 {
  /**
   * 这里有n个航班，它们分别从 1 到 n 进行编号。
   * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [firsti, lasti, seatsi]意味着在从 firsti到 lasti
   * （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi个座位。
   * 请你返回一个长度为 n 的数组answer，其中 answer[i] 是航班 i 上预订的座位总数。
   *
   * 示例 1：
   * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
   * 输出：[10,55,45,25,25]
   * 解释：
   * 航班编号        1   2   3   4   5
   * 预订记录 1 ：   10  10
   * 预订记录 2 ：       20  20
   * 预订记录 3 ：       25  25  25  25
   * 总座位数：      10  55  45  25  25
   * 因此，answer = [10,55,45,25,25]
   *
   * 示例 2：
   * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
   * 输出：[10,25]
   * 解释：
   * 航班编号        1   2
   * 预订记录 1 ：   10  10
   * 预订记录 2 ：       15
   * 总座位数：      10  25
   * 因此，answer = [10,25]
   *
   * 提示：
   * 1 <= n <= 2 * 10^4
   * 1 <= bookings.length <= 2 * 10^4
   * bookings[i].length == 3
   * 1 <= firsti <= lasti <= n
   * 1 <= seatsi <= 10^4
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int[] corpFlightBookings1(int[][] bookings, int n) {
    int[] arr = new int[n];
    int len = bookings.length;
    for (int i = 0; i < len; i++) {
      int start = bookings[i][0];
      if (start <= n) {
        int end = Math.min(n, bookings[i][1]);
        while (start <= end) {
          arr[start - 1] += bookings[i][2];
          start++;
        }
      }
    }
    return arr;
  }

  public int[] corpFlightBookings(int[][] bookings, int n) {
    int[] nums = new int[n];
    for (int[] booking : bookings) {
      nums[booking[0] - 1] += booking[2];
      if (booking[1] < n) {
        nums[booking[1]] -= booking[2];
      }
    }
    for (int i = 1; i < n; i++) {
      nums[i] += nums[i - 1];
    }
    return nums;
  }

  public static void main(String[] args) {
    new Num1109().corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}}, 5);
  }
}
