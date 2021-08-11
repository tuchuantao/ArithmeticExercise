package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by tuchuantao on 2021/8/6
 * Desc:
 */
public class Num207 {
  /**
   * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
   * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，
   * 表示如果要学习课程ai 则必须 先学习课程 bi 。
   * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
   * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
   *
   * 示例 1：
   * 输入：numCourses = 2, prerequisites = [[1,0]]
   * 输出：true
   * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
   *
   * 示例 2：
   * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
   * 输出：false
   * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
   * 
   * 提示：
   * 1 <= numCourses <= 10^5
   * 0 <= prerequisites.length <= 5000
   * prerequisites[i].length == 2
   * 0 <= ai, bi < numCourses
   * prerequisites[i] 中的所有课程对 互不相同
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/course-schedule
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  Map<Integer, ArrayList<Integer>> map = new HashMap();
  public boolean canFinish(int numCourses, int[][] prerequisites) { // 深度遍历，剪枝
    int len = prerequisites.length;
    for (int i = 0; i < len; i++) {
      ArrayList<Integer> list = map.getOrDefault(prerequisites[i][0], new ArrayList());
      list.add(prerequisites[i][1]);
      map.put(prerequisites[i][0], list);
    }

    int[] courses = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (courses[i] == 1) {
        continue;
      }
      if (!canFinish(i, new ArrayList(), courses)) {
        return false;
      }
    }
    return true;
  }

  private boolean canFinish(int currCourse, ArrayList<Integer> selectedCourses, int[] courses) {
    ArrayList<Integer> preList = map.getOrDefault(currCourse, new ArrayList());
    if (preList == null) {
      return true;
    }
    selectedCourses.add(currCourse);
    courses[currCourse] = 1;
    int len = preList.size();
    for (int i = 0; i < len; i++) {
      if (selectedCourses.contains(preList.get(i))) {
        return false;
      }
      if (courses[preList.get(i)] == 1) {
        continue;
      }
      if (!canFinish(preList.get(i), selectedCourses, courses)) {
        return false;
      }
    }
    selectedCourses.remove(selectedCourses.size() - 1);
    return true;
  }


  List<List<Integer>> edges;
  int[] visited;
  boolean valid = true;
  public boolean canFinish11(int numCourses, int[][] prerequisites) { // 深度遍历 & 三色状态
    edges = new ArrayList<List<Integer>>();
    for (int i = 0; i < numCourses; ++i) {
      edges.add(new ArrayList<Integer>());
    }
    visited = new int[numCourses];
    for (int[] info : prerequisites) {
      edges.get(info[1]).add(info[0]);
    }
    for (int i = 0; i < numCourses && valid; ++i) {
      if (visited[i] == 0) {
        dfs(i);
      }
    }
    return valid;
  }

  public void dfs(int u) {
    visited[u] = 1;
    for (int v: edges.get(u)) {
      if (visited[v] == 0) {
        dfs(v);
        if (!valid) {
          return;
        }
      } else if (visited[v] == 1) {
        valid = false;
        return;
      }
    }
    visited[u] = 2;
  }



  public static void main(String[] args) {
    boolean result = new Num207().canFinish(2, new int[][]{{1, 0}});
    System.out.println("result=" + result);
  }
}
