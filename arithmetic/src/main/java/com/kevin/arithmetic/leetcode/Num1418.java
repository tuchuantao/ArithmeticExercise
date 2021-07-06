package com.kevin.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by tuchuantao on 2021/7/6
 * Desc:
 */
public class Num1418 {

  /**
   * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中
   * customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
   *
   * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table”
   * ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
   *
   * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
   *
   *
   * 示例 1：
   *
   * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried
   * Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
   * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5",
   * "0","1","0","1"],["10","1","0","0","0"]]
   * 解释：
   * 点菜展示表如下所示：
   * Table,Beef Burrito,Ceviche,Fried Chicken,Water
   * 3    ,0           ,2      ,1            ,0
   * 5    ,0           ,1      ,0            ,1
   * 10   ,1           ,0      ,0            ,0
   * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
   * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
   * 餐桌 10：Corina 点了 "Beef Burrito"
   * 示例 2：
   *
   * 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12",
   * "Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
   * 输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
   * 解释：
   * 对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
   * 而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
   * 示例 3：
   *
   * 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
   * 输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
   *
   * 提示：
   *
   * 1 <=orders.length <= 5 * 10^4
   * orders[i].length == 3
   * 1 <= customerNamei.length, foodItemi.length <= 20
   * customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。
   * tableNumberi 是 1 到 500 范围内的整数。
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant
   * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   */
  public List<List<String>> displayTable(List<List<String>> orders) {
    int len = orders.size();
    TreeMap<String, ArrayList<String>> orderMap = new TreeMap<>(new Comparator<String>() {
      @Override
      public int compare(String s, String t1) {
        return Integer.valueOf(s) - Integer.valueOf(t1);
      }
    });
    ArrayList<String> foodList = new ArrayList();
    List<String> tempList;
    ArrayList<String> tempFoodList;
    for (int i = 0; i < len; i++) {
      tempList = orders.get(i);
      tempFoodList = orderMap.getOrDefault(tempList.get(1), new ArrayList());
      tempFoodList.add(tempList.get(2));
      orderMap.put(tempList.get(1), tempFoodList);

      if (!foodList.contains(tempList.get(2))) {
        foodList.add(tempList.get(2));
      }
    }

    Collections.sort(foodList);
    List<List<String>> result = new ArrayList();
    foodList.add(0, "Table");
    result.add(foodList);
    int col = foodList.size();

    for (Map.Entry<String, ArrayList<String>> entry: orderMap.entrySet()) {
      String[] foodArr = new String[col];
      for (int i = 0; i < col; i++) {
        foodArr[i] = "0";
      }
      foodArr[0] = entry.getKey();
      for (String food: entry.getValue()) {
        int index = foodList.indexOf(food);
        String value = foodArr[index];
        foodArr[index] = Integer.valueOf(value) + 1 + "";
      }
      result.add(Arrays.asList(foodArr));
    }
    return result;
  }

  public static void main(String[] args) {
    List<List<String>> orders = new ArrayList();
    List<String> list = new ArrayList();
    list.add("David");
    list.add("3");
    list.add("Ceviche");
    orders.add(list);

    list = new ArrayList();
    list.add("Corina");
    list.add("10");
    list.add("Beef Burrito");
    orders.add(list);

    list = new ArrayList();
    list.add("David");
    list.add("3");
    list.add("Fried Chicken");
    orders.add(list);

    list = new ArrayList();
    list.add("Carla");
    list.add("5");
    list.add("Water");
    orders.add(list);

    list = new ArrayList();
    list.add("Carla");
    list.add("5");
    list.add("Ceviche");
    orders.add(list);

    list = new ArrayList();
    list.add("Rous");
    list.add("3");
    list.add("Ceviche");
    orders.add(list);

    new Num1418().displayTable(orders);
  }
}
