package com.kevin.arithmetic.sort;

/**
 * Kevin-Tu on 2018-03-09 0009.
 * <p>
 * JAVA常用的八种排序算法
 */
public class SortArithmetic {

    public static void main(String[] args) {
        int[] arr = new int[]{100, 3, 1, 17, 35, 56, 89, 43, 65, 2};
        //insertSort(arr);
        //shellSort(arr);
        //selectSort(arr);
        //bubbleSort(arr);
        //quickSort(arr, 0, arr.length - 1);
        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d, ", i, arr[i]);
        }
    }

    /**
     * 直接插入排序
     *
     * @param arr
     */
    public static void insertSort(String[] arr) {
        int temp = 0;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            temp = Integer.valueOf(arr[i]);
            int j = i - 1;
            while (j >= 0 && Integer.valueOf(arr[j]) > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = String.valueOf(temp);

            /*for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    if (j == 0) {
                        arr[j] = temp;
                    }
                } else {
                    arr[j + 1] = temp;
                    break;
                }
            }*/
        }
    }

    /**
     * 希尔排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        int skipLen = len / 2;
        int temp;
        while (skipLen != 0) {
            for (int i = 0; i < skipLen; i++) {
                for (int j = i + skipLen; j < len; j += skipLen) {
                    temp = arr[j];
                    int k = j - skipLen;
                    while (k >= 0 && temp < arr[k]) {
                        arr[k + skipLen] = arr[k];
                        k -= skipLen;
                    }
                    arr[k + skipLen] = temp;
                }
            }
            skipLen = skipLen / 2;
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        int len = arr.length;
        int minIndex;
        int temp;
        for (int i = 0; i < len; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr) {

    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int len = arr.length; // 单独把数组长度拿出，提高效率，不用每次循环都去去数组的长度
        int temp;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     * @param arr
     */
    public static void quickSort(int[] arr, int begin, int end) {
        int oldBegin = begin;
        int oldEnd = end;
        int temp = arr[begin];
        while (begin < end) {
            while (begin < end && temp < arr[end]) { // 先扫描右端
                end--;
            }
            if (begin < end) {
                arr[begin] = arr[end];
                begin++;
            }
            while (begin < end && temp >= arr[begin]) {
                begin++;
            }
            if (begin < end) {
                arr[end] = arr[begin];
                end--;
            }
        }
        arr[begin] = temp;

        if (begin - oldBegin > 1) {
            quickSort(arr, oldBegin, begin - 1);
        }
        if (oldEnd - end > 1) {
            quickSort(arr, end + 1, oldEnd);
        }
    }

    /**
     * 归并排序
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int len = arr.length;
        int mergeLen = 1;
        int temp;
        while (mergeLen <= len) {
            mergeLen *= 2;
            for (int i = 0; i < len / mergeLen + 1; i++) {
                int maxIndex = i * mergeLen + mergeLen >= len ? len : i * mergeLen + mergeLen;
                for (int j = i * mergeLen + mergeLen / 2; j < maxIndex; j++) {
                    for (int k= i * mergeLen; k < j; k++) {
                        if (arr[k] > arr[j]) {
                            temp = arr[j];
                            for (int l = j; l > k ; l--) {
                                arr[l] = arr[l - 1];
                            }
                            arr[k] = temp;
                        }
                    }
                }
            }
        }
    }

    /**
     * 基数排序
     * @param arr
     */
    public static void baseSort(int[] arr) {

    }
}
