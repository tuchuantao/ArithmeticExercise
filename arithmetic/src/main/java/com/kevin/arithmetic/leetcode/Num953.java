package com.kevin.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tuchuantao on 2022/1/6
 * Desc: 验证外星语词典
 */
public class Num953 {
  /**
   * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
   * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
   * <p>
   * 示例 1：
   * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
   * 输出：true
   * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
   * <p>
   * 示例 2：
   * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
   * 输出：false
   * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
   * <p>
   * 示例 3：
   * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
   * 输出：false
   * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅'
   * 是空白字符，定义为比任何其他字符都小（更多信息）。
   * <p>
   * 提示：
   * 1 <= words.length <= 100
   * 1 <= words[i].length <= 20
   * order.length == 26
   * 在words[i]和order中的所有字符都是英文小写字母。
   * <p>
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/verifying-an-alien-dictionary
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> map = new HashMap();
    for (int i = 0; i < 26; i++) {
      map.put(order.charAt(i), i);
    }
    int len = words.length;
    for (int i = 0; i < len - 1; i++) {
      int minLen = Math.min(words[i].length(), words[i + 1].length());
      boolean needCheckLen = true;
      for (int j = 0; j < minLen; j++) {
        if (map.get(words[i].charAt(j)) > map.get(words[i + 1].charAt(j))) { // NOTE: 细心
          return false;
        } else if (map.get(words[i].charAt(j)) < map.get(words[i + 1].charAt(j))) { // NOTE: 细心
          needCheckLen = false;
          break;
        }
      }
      if (needCheckLen && words[i].length() > words[i + 1].length()) {
        return false;
      }
    }
    return true;
  }
}