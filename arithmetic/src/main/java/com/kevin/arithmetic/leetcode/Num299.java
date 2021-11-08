package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/11/8
 * Desc: 猜数字游戏
 */
public class Num299 {
  /**
   * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
   * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
   * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
   * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
   * 给你一个秘密数字secret 和朋友猜测的数字guess ，请你返回对朋友这次猜测的提示。
   * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B表示奶牛。
   * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
   *
   * 示例 1:
   * 输入: secret = "1807", guess = "7810"
   * 输出: "1A3B"
   * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
   * "1807"
   *   |
   * "7810"
   *
   * 示例 2:
   * 输入: secret = "1123", guess = "0111"
   * 输出: "1A1B"
   * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
   * "1123"        "1123"
   *   |      or     |
   * "0111"        "0111"
   * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
   *
   * 示例 3：
   * 输入：secret = "1", guess = "0"
   * 输出："0A0B"
   *
   * 示例 4：
   * 输入：secret = "1", guess = "1"
   * 输出："1A0B"
   *
   * 提示：
   *
   * 1 <= secret.length, guess.length <= 1000
   * secret.length == guess.length
   * secret 和 guess 仅由数字组成
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/bulls-and-cows
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String getHint(String secret, String guess) {
    HashMap<Character, ArrayList<Integer>> map = new HashMap();
    int len = secret.length();
    int[] arr = new int[len];
    int bCount = 0, cCount = 0;
    for (int i = 0; i < len; i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bCount++;
        arr[i] = 1;
      } else {
        ArrayList<Integer> list = map.getOrDefault(secret.charAt(i), new ArrayList());
        list.add(i);
        map.put(secret.charAt(i), list);
      }
    }

    for (int i = 0; i < len; i++) {
      if (arr[i] == 1) {
        continue;
      }
      ArrayList<Integer> list = map.get(guess.charAt(i));
      if (list != null && !list.isEmpty()) {
        for (Integer index : list) {
          if (arr[index] == 0) {
            cCount++;
            arr[index] = 2;
            break;
          }
        }
      }
    }
    return new StringBuilder().append(bCount).append("A").append(cCount).append("B").toString();
  }

  public String getHint2(String secret, String guess) {
    int bulls = 0;
    int[] cntS = new int[10];
    int[] cntG = new int[10];
    for (int i = 0; i < secret.length(); ++i) {
      if (secret.charAt(i) == guess.charAt(i)) {
        ++bulls;
      } else {
        ++cntS[secret.charAt(i) - '0'];
        ++cntG[guess.charAt(i) - '0'];
      }
    }
    int cows = 0;
    for (int i = 0; i < 10; ++i) {
      cows += Math.min(cntS[i], cntG[i]);
    }
    return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
  }

  public static void main(String[] args) {
    String result = new Num299().getHint("1807", "7810");
    System.out.println("result=" + result);
  }
}
