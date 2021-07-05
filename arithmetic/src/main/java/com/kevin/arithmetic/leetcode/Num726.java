package com.kevin.arithmetic.leetcode;

import java.util.Calendar;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by tuchuantao on 2021/7/5
 * Desc:
 */
public class Num726 {

  /**
   * 给定一个化学式formula（作为字符串），返回每种原子的数量。
   *
   * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
   *
   * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
   *
   * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
   *
   * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
   *
   * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
   *
   * 示例 1:
   *
   * 输入:
   * formula = "H2O"
   * 输出: "H2O"
   * 解释:
   * 原子的数量是 {'H': 2, 'O': 1}。
   * 示例 2:
   *
   * 输入:
   * formula = "Mg(OH)2"
   * 输出: "H2MgO2"
   * 解释:
   * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
   * 示例 3:
   *
   * 输入:
   * formula = "K4(ON(SO3)2)2"
   * 输出: "K4N2O14S4"
   * 解释:
   * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
   * 注意:
   *
   * 所有原子的第一个字母为大写，剩余字母都是小写。
   * formula的长度在[1, 1000]之间。
   * formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
   *
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/number-of-atoms
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  int i, n;
  String formula;

  /**
   * 对于括号序列相关的题目，通用的解法是使用递归或栈。本题中我们将使用栈解决。
   *
   * 从左到右遍历该化学式，并使用哈希表记录当前层遍历到的原子及其数量，因此初始时需将一个空的哈希表压入栈中。对于当前遍历的字符：
   *
   * 如果是左括号，将一个空的哈希表压入栈中，进入下一层。
   *
   * 如果不是括号，则读取一个原子名称，若后面还有数字，则读取一个数字，否则将该原子后面的数字视作 11。然后将原子及数字加入栈顶的哈希表中。
   *
   * 如果是右括号，则说明遍历完了当前层，若括号右侧还有数字，则读取该数字 \textit{num}num，否则将该数字视作 11。然后将栈顶的哈希表弹出，将弹出的哈希表中的原子数量与
   * \textit{num}num 相乘，加到上一层的原子数量中。
   *
   * 遍历结束后，栈顶的哈希表即为化学式中的原子及其个数。遍历哈希表，取出所有「原子-个数」对加入数组中，对数组按照原子字典序排序，然后遍历数组，按题目要求拼接成答案。
   *
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/number-of-atoms/solution/yuan-zi-de-shu-liang-by
   * -leetcode-solutio-54lv/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * @param formula
   * @return
   */
  public String countOfAtoms1(String formula) {
    this.i = 0;
    this.n = formula.length();
    this.formula = formula;

    Deque<HashMap<String, Integer>> stack = new LinkedList();
    stack.push(new HashMap());
    char ch;
    while (i < n) {
      ch = formula.charAt(i);
      if (ch == '(') {
        i++;
        stack.push(new HashMap());
      } else if (ch == ')') {
        i++;
        HashMap<String, Integer> currMap = stack.pop();
        HashMap<String, Integer> topMap = stack.peek();
        int num = parseNum1();
        for (Map.Entry<String, Integer> item: currMap.entrySet()) {
          String key = item.getKey();
          int value = item.getValue();
          topMap.put(key, topMap.getOrDefault(key, 0) + value * num); // topMap.getOrDefault(key, 0)
        }
      } else {
        String atom = parseAtom1();
        int num = parseNum1();
        HashMap<String, Integer> topMap = stack.peek();
        topMap.put(atom, topMap.getOrDefault(atom, 0) + num); // topMap.getOrDefault(key, 0)
      }
    }


    Map<String, Integer> map = stack.pop();
    TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(map);

    StringBuffer sb = new StringBuffer();
    for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
      String atom = entry.getKey();
      int count = entry.getValue();
      sb.append(atom);
      if (count > 1) {
        sb.append(count);
      }
    }
    return sb.toString();
  }

  private int parseNum1() {
    if (i >= n || !Character.isDigit(formula.charAt(i))) {
      return 1;
    }
    int num = 0;
    while (i < n && Character.isDigit(formula.charAt(i))) {
      num = num * 10 + formula.charAt(i++) - '0';
    }
    return num;
  }

  private String parseAtom1() {
    StringBuilder builder = new StringBuilder();
    builder.append(formula.charAt(i++));
    while (i < n && Character.isLowerCase(formula.charAt(i))) {
      builder.append(formula.charAt(i++));
    }
    return builder.toString();
  }


  public static void main(String[] args) {
    Num726 obj = new Num726();
    String result = obj.countOfAtoms1("Mg(OH)2");
    System.out.println("result=" + result);
  }

















  public String countOfAtoms(String formula) {
    this.i = 0;
    this.n = formula.length();
    this.formula = formula;

    Deque<Map<String, Integer>> stack = new LinkedList<Map<String, Integer>>();
    stack.push(new HashMap<String, Integer>());
    while (i < n) {
      char ch = formula.charAt(i);
      if (ch == '(') {
        i++;
        stack.push(new HashMap<String, Integer>()); // 将一个空的哈希表压入栈中，准备统计括号内的原子数量
      } else if (ch == ')') {
        i++;
        int num = parseNum(); // 括号右侧数字
        Map<String, Integer> popMap = stack.pop(); // 弹出括号内的原子数量
        Map<String, Integer> topMap = stack.peek();
        for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
          String atom = entry.getKey();
          int v = entry.getValue();
          topMap.put(atom, topMap.getOrDefault(atom, 0) + v * num); // 将括号内的原子数量乘上 num，加到上一层的原子数量中
        }
      } else {
        String atom = parseAtom();
        int num = parseNum();
        Map<String, Integer> topMap = stack.peek();
        topMap.put(atom, topMap.getOrDefault(atom, 0) + num); // 统计原子数量
      }
    }

    Map<String, Integer> map = stack.pop();
    TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(map); // TreeMap默认对Key进行升序排序

    StringBuffer sb = new StringBuffer();
    for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
      String atom = entry.getKey();
      int count = entry.getValue();
      sb.append(atom);
      if (count > 1) {
        sb.append(count);
      }
    }
    return sb.toString();
  }

  public String parseAtom() {
    StringBuffer sb = new StringBuffer();
    sb.append(formula.charAt(i++)); // 扫描首字母
    while (i < n && Character.isLowerCase(formula.charAt(i))) {
      sb.append(formula.charAt(i++)); // 扫描首字母后的小写字母
    }
    return sb.toString();
  }

  public int parseNum() {
    if (i == n || !Character.isDigit(formula.charAt(i))) {
      return 1; // 不是数字，视作 1
    }
    int num = 0;
    while (i < n && Character.isDigit(formula.charAt(i))) {
      num = num * 10 + formula.charAt(i++) - '0'; // 扫描数字
    }
    return num;
  }
}
