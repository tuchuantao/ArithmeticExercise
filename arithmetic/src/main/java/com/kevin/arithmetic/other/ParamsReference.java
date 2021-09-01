package com.kevin.arithmetic.other;

/**
 * Created by tuchuantao on 2021/9/1
 * Desc:
 */
public class ParamsReference {

  static Integer i = 0;

  public static void main(String[] args) {
    testInteger(i);
    System.out.println("num=" + i);
  }

  private static void testInteger(Integer num) {
    num = 2;
//    num = Integer.valueOf(2);
  }
}
