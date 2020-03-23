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
        //quickSort(arr);
        //mergeSort(arr);
        heapSort(arr);
        //baseSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d, ", i, arr[i]);
        }
    }

    /**
     * 直接插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int temp = 0;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;

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
     * <p>
     * 1.下标为i的节点，父节点坐标为(i-1)/2；
     * <p>
     * 2.下标为i的节点，左子节点坐标为2*i+1，右子节点为2*i+2。
     *
     * @param arr
     */
    public static void  heapSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) { // len - 1
            // 构建大堆
            buildMaxHeap(arr, len - 1 - i);

            // 交换堆顶和最后一个元素
            int temp = arr[0];
            arr[0] = arr[len - 1 -i];
            arr[len - 1 - i] = temp;
        }
    }

    /**
     * 构建大堆
     *
     * @param arr       待排序列
     * @param lastIndex
     */
    private static void buildMaxHeap(int[] arr, int lastIndex) {
        // 从lastIndex处节点（最后一个节点）的父节点开始
        for (int i = (lastIndex - 1) / 2; i >= 0; ) {
            // parent保存正在判断的节点
            int parent = i;
            // 如果当前k节点的子节点存在
            while (parent * 2 + 1 <= lastIndex) {
                // parent节点的左子节点的索引
                int biggerIndex = parent * 2 + 1;
                // 存在右子节点，判断左右子节点的大小
                if (biggerIndex + 1 <= lastIndex && arr[biggerIndex] < arr[biggerIndex + 1]) {
                    biggerIndex++;
                }
                // 如果父节点别子节点的最大值要小
                if (arr[parent] < arr[biggerIndex]) {
                    int temp = arr[parent];
                    arr[parent] = arr[biggerIndex];
                    arr[biggerIndex] = temp;

                    // 将biggerIndex赋予k，开始while循环的下一次循环，重新保证parent节点的值大于其左右子节点的值
                    parent = biggerIndex;
                } else {
                    break;
                }
            }

            i = i - 2;
            if (i == -1) {
                i = 0;
            }
        }
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
     *
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
     *
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
                    for (int k = i * mergeLen; k < j; k++) {
                        if (arr[k] > arr[j]) {
                            temp = arr[j];
                            for (int l = j; l > k; l--) {
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
     *
     * @param arr
     */
    public static void baseSort(int[] arr) {

    }
}
