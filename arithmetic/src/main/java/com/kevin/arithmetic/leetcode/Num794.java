package com.kevin.arithmetic.leetcode;

/**
 * Created by tuchuantao on 2021/12/9
 * Desc: 有效的井字游戏
 */
public class Num794 {
  /**
   * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
   * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
   * 以下是井字游戏的规则：
   * 玩家轮流将字符放入空位（' '）中。
   * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
   * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
   * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
   * 当所有位置非空时，也算为游戏结束。
   * 如果游戏结束，玩家不允许再放置字符。
   *
   * 示例 1：
   * 输入：board = ["O  ","   ","   "]
   * 输出：false
   * 解释：玩家 1 总是放字符 "X" 。
   *
   * 示例 2：
   * 输入：board = ["XOX"," X ","   "]
   * 输出：false
   * 解释：玩家应该轮流放字符。
   *
   * 示例 3：
   * 输入：board = ["XXX","   ","OOO"]
   * 输出：false
   *
   * Example 4:
   * 输入：board = ["XOX","O O","XOX"]
   * 输出：true
   *
   * 提示：
   * board.length == 3
   * board[i].length == 3
   * board[i][j] 为 'X'、'O' 或 ' '
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/valid-tic-tac-toe-state
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public boolean validTicTacToe(String[] board) { // ["XXX","   ","OOO"] 需要考虑游戏结束的情况
    boolean xVictory = false;
    boolean oVictory = false;
    for (int i = 0; i < 3; i++) {
      if (board[i].equals("XXX")) {
        if (xVictory) {
          return false;
        }
        xVictory = true;
      } else if (board[i].equals("OOO")) {
        if (oVictory) {
          return false;
        }
        oVictory = true;
      }
    }

    boolean xColVictory = false;
    boolean oColVictory = false;
    for (int i = 0; i < 3; i++) {
      if (board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X') {
        if (xColVictory) {
          return false;
        }
        xColVictory = true;
      } else if (board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O') {
        if (oColVictory) {
          return false;
        }
        oColVictory = true;
      }
    }

    xVictory |= xColVictory;
    oVictory |= oColVictory;
    if ((board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X') ||
        (board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X')) {
      xVictory = true;
    }
    if ((board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O') ||
        (board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O')) {
      oVictory = true;
    }

    if (xVictory && oVictory) {
      return false;
    }

    int xCount = 0;
    int oCount = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i].charAt(j) == 'X') {
          xCount++;
        } else if (board[i].charAt(j) == 'O') {
          oCount++;
        }
      }
    }
    return (xCount - oCount == 0 && !xVictory) || (xCount - oCount == 1 && !oVictory);
  }
}
