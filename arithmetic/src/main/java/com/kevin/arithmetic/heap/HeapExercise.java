package com.kevin.arithmetic.heap;

import java.util.Arrays;

/**
 * Create by Kevin-Tu on 2020/4/17.
 *
 * 满二叉树的总节点数：  2^h - 1   h为层数
 *
 * 完全二叉树的特点：
 *      第i个节点：
 *          1、左子节点为： 2 * i + 1
 *             右子节点为： 2 * i + 2
 *          2、父节点为： (i - 1) / 2
 *
 *
 *          0
 *       1     2
 *    3    4  5 6
 *   7 8  9
 */
public class HeapExercise {

    public static void main(String[] args) {
        int[] arr = new int[]{100, 3, 1, 17, 35, 56, 89, 43, 65, 2};

//          buildMaxHeap(arr);
        buildMaxHeapOptimize(arr);
        printArr(arr);

//        arr = insertFoMaxHeap(arr, 80);
//        printArr(arr);
//        arr = insertFoMaxHeap(arr, 101);
//        printArr(arr);

        arr = deleteForMaxHeap(arr);
        printArr(arr);

//        buildMinHeap(arr);
//        printArr(arr);
    }

    /**
     * 构建最大堆
     *
     * 缺点： 会有一直交换操作
     *      int temp = arr[parent];
     *      arr[parent] = arr[bigIndex];
     *      arr[bigIndex] = temp;
     */
    private static void buildMaxHeap(int[] arr) {
        int lastIndex = arr.length - 1;
        // 从最后一个节点的父节点开始
        for(int i = (lastIndex - 1) / 2; i >= 0; i--) {
            System.out.println("i=" + i);
            int parent = i;
            while (parent * 2 + 1 <= lastIndex) { // 有左子节点
                int leftIndex = parent * 2 + 1;
                int rightIndex = leftIndex + 1;
                int bigIndex = leftIndex;
                // 找出子节点最大值
                if (rightIndex <= lastIndex && arr[rightIndex] > arr[leftIndex]) {
                    bigIndex = rightIndex;
                }
                // 将最大值移动到顶
                if (arr[bigIndex] > arr[parent]) {
                    int temp = arr[parent];
                    arr[parent] = arr[bigIndex];
                    arr[bigIndex] = temp;
                    parent = bigIndex; // 节点改变后，需要重新调整子树，使其成为最大堆
                } else {
                    break;
                }
            }
        }
    }

    private static void buildMaxHeapOptimize(int[] arr) {
        int lastIndex = arr.length - 1;
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int beginParent = arr[i]; // 缓存最开始的父节点，在调整子树时，不用每次都将父节点写入左右孩子中的最大位置
            int parentIndex = i;
            while (parentIndex * 2 + 1 <= lastIndex) {
                int leftIndex = parentIndex * 2 + 1;
                int rightIndex = leftIndex + 1;
                int bigIndex = leftIndex;

                if (rightIndex <= lastIndex && arr[rightIndex] > arr[leftIndex]) {
                    bigIndex = rightIndex;
                }
                if (arr[bigIndex] > beginParent) {
                    arr[parentIndex] = arr[bigIndex];
                    parentIndex = bigIndex;
                } else {
                    break;
                }
            }
            arr[parentIndex] = beginParent;
        }
    }

    /**
     * 构建最小堆
     */
    private static void buildMinHeap(int[] arr) {
        int lastIndex = arr.length - 1;
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int originParent = arr[i];
            int parent = i;
            while (parent * 2 + 1 <= lastIndex) { // 有左子节点
                int leftIndex = parent * 2 + 1;
                int rightIndex = leftIndex + 1;
                int minIndex = leftIndex;
                if (rightIndex <= lastIndex && arr[rightIndex] < arr[minIndex]) {
                    minIndex = rightIndex;
                }
                if (arr[minIndex] < originParent) {
                    arr[parent] = arr[minIndex];
                    parent = minIndex; // 节点改变后，需要调整相应子节点的顶
                } else {
                    break;
                }
            }
            arr[parent] = originParent;
        }
    }

    /**
     * 树尾插入，然后调整
     *
     * @param arr
     * @param item
     * @return
     */
    private static int[] insertFoMaxHeap(int[] arr, int item) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[arr.length] = item;

        int index = newArr.length - 1;
        while ((index - 1) / 2 >= 0 && newArr[index] > newArr[(index - 1) / 2]) {
            int temp = newArr[index];
            newArr[index] = newArr[(index - 1) / 2];
            newArr[(index - 1) / 2] = temp;
            if (index == 0) {
                break;
            } else {
                index = (index - 1) / 2;
            }
        }
        return newArr;
    }

    /**
     * 最大堆的删除操作，总是从堆的根结点删除元素，然后将最后一个节点移动到根节点，再去构建大根堆
     * @param arr
     * @return
     */
    private static int[] deleteForMaxHeap(int[] arr) {
        int len = arr.length;
        arr[0] = arr[--len];
        int[] newArr = Arrays.copyOf(arr, len);
        int parentIndex = 0;
        int left;
        int right;
        int bigIndex;
        while (parentIndex * 2 + 1 < len) {
            left = parentIndex * 2 + 1;
            right = left + 1;
            bigIndex = left;
            if (right < len && newArr[right] > newArr[bigIndex]) {
                bigIndex = right;
            }
            if (newArr[bigIndex] > newArr[parentIndex]) {
                int temp = newArr[parentIndex];
                newArr[parentIndex] = newArr[bigIndex];
                newArr[bigIndex] = temp;
                parentIndex = bigIndex;
            }
        }
        return newArr;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d, ", i, arr[i]);
        }
        System.out.println("");
        System.out.println("========");
    }
}
