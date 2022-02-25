package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2022/2/25
 * Desc: 复数乘法
 */
public class Num537 {
  /**
   * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
   *  实部 是一个整数，取值范围是 [-100, 100]
   *  虚部 也是一个整数，取值范围是 [-100, 100]
   *  i^2 == -1
   * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
   *
   * 示例 1：
   * 输入：num1 = "1+1i", num2 = "1+1i"
   * 输出："0+2i"
   * 解释：(1 + i) * (1 + i) = 1 + i^2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
   *
   * 示例 2：
   * 输入：num1 = "1+-1i", num2 = "1+-1i"
   * 输出："0+-2i"
   * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
   *
   * 提示：
   * num1 和 num2 都是有效的复数表示。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/complex-number-multiplication
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String complexNumberMultiply(String num1, String num2) {
    int indexOne = num1.lastIndexOf('+');
    int indexTwo = num2.lastIndexOf('+');
    int oneFirst = Integer.valueOf(num1.substring(0, indexOne));
    int oneSecond = Integer.valueOf(num1.substring(indexOne + 1, num1.length() - 1));
    int twoFirst = Integer.valueOf(num2.substring(0, indexTwo));
    int twoSecond = Integer.valueOf(num2.substring(indexTwo + 1, num2.length() - 1));

    int one = oneFirst * twoFirst - oneSecond * twoSecond;
    int two = oneFirst * twoSecond + oneSecond * twoFirst;
    return new StringBuilder().append(one).append("+").append(two).append("i").toString();
  }

}
