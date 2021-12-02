package com.kevin.arithmetic.util;

/**
 * Created by tuchuantao on 2021/11/16
 * Desc:
 */
public class Utils {

  public static <T> void printArr(double[] arr) {
    int len = arr.length;
    System.out.print("[");
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i] + ",");
    }
    System.out.println("]");
  }

  public static <T> void printArr(String[] arr) {
    int len = arr.length;
    System.out.print("[");
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i] + ",");
    }
    System.out.println("]");
  }

  public static void printMulArr(int[][] arr) {
    int len = arr.length;
    for (int i = 0; i < len; i++) {
      System.out.print("[");
      for (int j = 0; j < len; j++) {
        System.out.print(arr[i][j] + ",");
      }
      System.out.println("]");
    }
  }
}
