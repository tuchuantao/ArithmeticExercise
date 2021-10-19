package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuchuantao on 2021/10/18
 * Desc: 格雷编码
 */
public class Num89 {
  /**
   * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
   * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
   * 格雷编码序列必须以 0 开头。
   *
   * 示例 1:
   * 输入:2
   * 输出:[0,1,3,2]
   * 解释:
   * 00 - 0
   * 01 - 1
   * 11 - 3
   * 10 - 2
   * 对于给定的n，其格雷编码序列并不唯一。
   * 例如，[0,2,3,1]也是一个有效的格雷编码序列。
   * 00 - 0
   * 10 - 2
   * 11 - 3
   * 01 - 1
   *
   * 示例2:
   * 输入:0
   * 输出:[0]
   * 解释: 我们定义格雷编码序列必须以 0 开头。
   *     给定编码总位数为 n 的格雷编码序列，其长度为 2^n。当 n = 0 时，长度为 2^0 = 1。
   *     因此，当 n = 0 时，其格雷编码序列为 [0]。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/gray-code
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<Integer> grayCode(int n) {
    List<Integer> res = new ArrayList();
    res.add(0);
    int head = 1;
    for (int i = 0; i < n; i++) {
      for (int j = res.size() - 1; j >= 0; j--)
        res.add(head + res.get(j));
      head <<= 1; // head * 2
    }
    return res;
  }

  /**
   * 设 n 阶格雷码集合为 G(n)，则 G(n+1) 阶格雷码为：
   * 给 G(n) 阶格雷码每个元素二进制形式前面添加 0，得到 G'(n)；
   * 设 G(n) 集合倒序（镜像）为 R(n)，给 R(n) 每个元素二进制形式前面添加 1，得到 R'(n);
   * G(n+1) = G'(n) U R'(n) 拼接两个集合即可得到下一阶格雷码。
   */

  public static void main(String[] args) {
    List<Integer> list = new Num89().grayCode(3);
    for (Integer num : list) {
      System.out.print(num + ",");
    }
  }
}
