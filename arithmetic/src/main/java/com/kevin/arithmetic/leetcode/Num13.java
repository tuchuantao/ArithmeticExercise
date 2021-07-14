package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/7/14
 * Desc:
 */
public class Num13 {

  /**
   * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
   *
   * 字符          数值
   * I             1
   * V             5
   * X             10
   * L             50
   * C             100
   * D             500
   * M             1000
   * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
   *
   * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4
   * 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
   *
   * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
   * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
   * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
   * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
   *
   * 
   *
   * 示例1:
   *
   * 输入:"III"
   * 输出: 3
   * 示例2:
   *
   * 输入:"IV"
   * 输出: 4
   * 示例3:
   *
   * 输入:"IX"
   * 输出: 9
   * 示例4:
   *
   * 输入:"LVIII"
   * 输出: 58
   * 解释: L = 50, V= 5, III = 3.
   * 示例5:
   *
   * 输入:"MCMXCIV"
   * 输出: 1994
   * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
   * 
   *
   * 提示：
   *
   * 1 <= s.length <= 15
   * s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
   * 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
   * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
   * IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
   * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/roman-to-integer
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public int romanToInt(String s) {
    HashMap<String, Integer> map = new HashMap();
    map.put("I", 1);
    map.put("II", 2);
    map.put("III", 3);
    map.put("IV", 4);
    map.put("V", 5);
    map.put("VI", 6);
    map.put("VII", 7);
    map.put("VIII", 8);
    map.put("IX", 9);
    map.put("X", 10);
    map.put("XL", 40);
    map.put("L", 50);
    map.put("XC", 90);
    map.put("C", 100);
    map.put("CD", 400);
    map.put("D", 500);
    map.put("CM", 900);
    map.put("M", 1000);

    int len = s.length();
    int result = 0;
    for (int i = 0; i < len; i++) {
      int index = i;
      while (index < len && map.getOrDefault(s.substring(i, index + 1), null) != null) {
        index++;
      }
      int num = map.get(s.substring(i, index)).intValue();
      if (index < len && num < 10) {
        Integer next = map.getOrDefault(s.substring(index, index + 1), null);
        if (next != null && next.intValue() >= 10) {
          num *= next.intValue();
          index++;
        }
      }
      result += num;
      i = index - 1;
    }
    return result;
  }

  //  LXXX	80 而不是 VIIIX






  Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
    put('I', 1);
    put('V', 5);
    put('X', 10);
    put('L', 50);
    put('C', 100);
    put('D', 500);
    put('M', 1000);
  }};

  public int romanToInt2(String s) {
    int ans = 0;
    int n = s.length();
    for (int i = 0; i < n; ++i) {
      int value = symbolValues.get(s.charAt(i));
      if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
        ans -= value;
      } else {
        ans += value;
      }
    }
    return ans;
  }

  /**
   * 羅馬數字	數值	拉丁語
   * I	1	ūnus
   * II	2	duo
   * III	3	trēs
   * IV	4	quattuor
   * V	5	quīnque
   * VI	6	sex
   * VII	7	septem
   * VIII	8	octō
   * IX	9	novem
   * X	10	decem
   * XI	11	ūndecim
   * XII	12	duodecim
   * XIII	13	tresdecim
   * XIV	14	quattuordecim
   * XV	15	quīndecim
   * XVI	16	sēdecim
   * XVII	17	septendecim
   * XVIII	18	octōdecim 或 duodēvīgintī
   * XIX	19	novendecim 或 ūndēvīgintī
   * XX	20	vīgintī
   * XXX	30	trīgintā
   * XL	40	quadrāgintā
   * L	50	quīnquāgintā
   * LX	60	sexāgintā
   * LXX	70	septuāgintā
   * LXXX	80	octōgintā
   * XC	90	nōnāgintā
   * XCIX	99	nōnāgintā novem
   * C	100	centum
   * CI	101	centum et ūnus
   * CII	102	centum et duo
   * CXCIX	199	centum nōnāgintā novem
   * CC	200	ducentī
   * CCC	300	trecentī
   * CD	400	quādringentī
   * D	500	quingentī
   * DC	600	sescentī
   * DCC	700	septingentī
   * DCCC	800	octingentī
   * CM	900	nongentī
   * M	1000	mīlle
   * MCD	1400
   * MCDXXXVII	1437
   * MD	1500
   * MDCCC	1800
   * MCM	1900
   * MM	2000
   * MMM	3000
   * MMMCCCXXXIII	3333
   * MV	4000
   * V	5000
   * X	10000
   * L	50000
   * C	100000	deciēns
   * D	500000
   * M	1000000
   * @param args
   */

  public static void main(String[] args) {
    int result = new Num13().romanToInt2("LXXX");
    System.out.println("result=" + result);
  }
}
