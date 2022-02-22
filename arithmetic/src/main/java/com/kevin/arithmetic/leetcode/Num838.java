package com.kevin.arithmetic.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Created by tuchuantao on 2022/2/21
 * Desc: 推多米诺
 */
public class Num838 {
  /**
   * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
   * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
   * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
   * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
   * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
   * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
   * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
   * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
   * 返回表示最终状态的字符串。
   *
   * 示例 1：
   * 输入：dominoes = "RR.L"
   * 输出："RR.L"
   * 解释：第一张多米诺骨牌没有给第二张施加额外的力。
   *
   * 示例 2：
   * 输入：dominoes = ".L.R...LR..L.."
   * 输出："LL.RR.LLRRLL.."
   *
   * 提示：
   * n == dominoes.length
   * 1 <= n <= 10^5
   * dominoes[i] 为 'L'、'R' 或 '.'
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/push-dominoes
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public String pushDominoes1(String dominoes) {
    int len = dominoes.length();
    char[] arr = dominoes.toCharArray();
    int count = 0;
    while (count < len) {
      count = 0;
      for (int i = 0; i < len; i++) {
        if ((arr[i] == 'L' && i - 1 >= 0 && arr[i - 1] == '.' && (i - 2 < 0 || arr[i - 2] != 'R')) ||
            (arr[i] == 'R' && i + 1 < len && arr[i + 1] == '.' && (i + 2 >= len || arr[i + 2] != 'L'))) {
          break;
        } else {
          count++;
        }
      }
      if (count == len) {
        break;
      }

      for (int i = 0; i < len; i++) {
        if (arr[i] == 'L') {
          if (i - 1 >= 0 && arr[i - 1] == '.') {
            arr[i - 1] = 'L';
          }
        } else if (arr[i] == 'R') {
          if (i + 1 < len && arr[i + 1] == '.') {
            if (i + 2 < len && arr[i + 2] == 'L') {
              i += 2;
            } else {
              arr[i + 1] = 'R';
              i++;
            }
          }
        }
      }
    }
    return String.valueOf(arr);
  }

  public String pushDominoes2(String dominoes) {
    int n = dominoes.length();
    Deque<Integer> queue = new ArrayDeque<Integer>();
    int[] time = new int[n];
    Arrays.fill(time, -1);
    List<Character>[] force = new List[n];
    for (int i = 0; i < n; i++) {
      force[i] = new ArrayList<Character>();
    }
    for (int i = 0; i < n; i++) {
      char f = dominoes.charAt(i);
      if (f != '.') {
        queue.offer(i);
        time[i] = 0;
        force[i].add(f);
      }
    }

    char[] res = new char[n];
    Arrays.fill(res, '.');
    while (!queue.isEmpty()) {
      int i = queue.poll();
      if (force[i].size() == 1) {
        char f = force[i].get(0);
        res[i] = f;
        int ni = f == 'L' ? i - 1 : i + 1;
        if (ni >= 0 && ni < n) {
          int t = time[i];
          if (time[ni] == -1) {
            queue.offer(ni);
            time[ni] = t + 1;
            force[ni].add(f);
          } else if (time[ni] == t + 1) {
            force[ni].add(f);
          }
        }
      }
    }
    return new String(res);
  }

  public String pushDominoes(String dominoes) {
    char[] s = dominoes.toCharArray();
    int n = s.length, i = 0;
    char left = 'L';
    while (i < n) {
      int j = i;
      while (j < n && s[j] == '.') { // 找到一段连续的没有被推动的骨牌
        j++;
      }
      char right = j < n ? s[j] : 'R';
      if (left == right) { // 方向相同，那么这些竖立骨牌也会倒向同一方向
        while (i < j) {
          s[i++] = right;
        }
      } else if (left == 'R' && right == 'L') { // 方向相对，那么就从两侧向中间倒
        int k = j - 1;
        while (i < k) {
          s[i++] = 'R';
          s[k--] = 'L';
        }
      }
      left = right;
      i = j + 1;
    }
    return new String(s);
  }


  public static void main(String[] args) {
//    String res = new Num838().pushDominoes(".L.R...LR..L..");
//    String res = new Num838().pushDominoes("..R..");
    String res = new Num838().pushDominoes(".L.R.");
//    String res = new Num838().pushDominoes(".L.R...LR..L..");
    System.out.println("res=" + res);
  }
  //"..R.."
  //输出：
  //"..RR."
  //预期结果：
  //"..RRR"
}
