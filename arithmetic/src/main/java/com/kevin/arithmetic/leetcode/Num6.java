package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2022/3/1
 * Desc: Z 字形变换
 */
public class Num6 {
  /**
   * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
   * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
   * P   A   H   N
   * A P L S I I G
   * Y   I   R
   * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
   * 请你实现这个将字符串进行指定行数变换的函数：
   * string convert(string s, int numRows);
   * 
   * 示例 1：
   * 输入：s = "PAYPALISHIRING", numRows = 3
   * 输出："PAHNAPLSIIGYIR"
   *
   * 示例 2：
   * 输入：s = "PAYPALISHIRING", numRows = 4
   * 输出："PINALSIGYAHRPI"
   * 解释：
   * P     I    N
   * A   L S  I G
   * Y A   H R
   * P     I
   *
   * 示例 3：
   * 输入：s = "A", numRows = 1
   * 输出："A"
   * 
   * 提示：
   * 1 <= s.length <= 1000
   * s 由英文字母（小写和大写）、',' 和 '.' 组成
   * 1 <= numRows <= 1000
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/zigzag-conversion
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    int len = s.length();
    int base = numRows * 2 - 2;
    int index = 0;
    StringBuilder builder = new StringBuilder();
    while (index < numRows) {
      int temp = index;
      while (temp < len) {
        builder.append(s.charAt(temp));
        if (index > 0 && index < numRows - 1 && temp + (numRows - index) * 2 - 2 < len) {
          builder.append(s.charAt(temp + (numRows - index) * 2 - 2));
        }
        temp += base;
      }
      index++;
    }
    return builder.toString();
  }

  public String convert0(String s, int numRows) {
    if(s == null || s.length() == 0 || numRows <= 1) {
      return s;
    }
    char[] arr = s.toCharArray();
    int length = arr.length;
    int line = length / (numRows + numRows - 2) + 1;
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < numRows; i++) {
      for(int j = 0; j < line; j++) {
        if(i == 0) {
          if((numRows + numRows - 2) * j < length) {
            builder.append(arr[(numRows + numRows - 2) * j]);
          } else {
            break;
          }
        } else if(i == numRows - 1) {
          if((numRows + numRows - 2) * j + numRows - 1 < length) {
            builder.append(arr[(numRows + numRows - 2) * j + numRows - 1]);
          } else {
            break;
          }
        } else {
          if((numRows + numRows - 2) * j + i < length) {
            builder.append(arr[(numRows + numRows - 2) * j + i]);
          } else {
            break;
          }

          if((numRows + numRows - 2) * (j + 1) - i < length) {
            builder.append(arr[(numRows + numRows - 2) * (j + 1) - i]);
          } else {
            break;
          }
        }
      }
    }
    return builder.toString();
  }
}
