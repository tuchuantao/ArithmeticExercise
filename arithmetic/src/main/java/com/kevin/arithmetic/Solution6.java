package com.kevin.arithmetic;

/**
 * Kevin-Tu on 2018/5/14.
 */
public class Solution6 {

    public static void main(String[] args) {
        String result = solution("aabcc,dbbca,aadbbcbcac");
        //String result = solution("aabcc,dbbca,aadbbbaccc");
        System.out.print(result);
    }

    private static String solution(String line) {
        String[] array = line.split(",");
        int oneStrLength = array[0].length();
        int twoStrLength = array[1].length();
        if (oneStrLength + twoStrLength != array[2].length()) {
            return "false";
        }
        boolean result = calculate(0, 0, 0, array[0].toCharArray(), array[1].toCharArray(), array[2].toCharArray());
        return String.valueOf(result);
    }

    /**
     * 递归永远是最没办法的办法，会存在调用栈溢出的问题
     *
     * @param indexOne
     * @param indexTwo
     * @param indexThree
     * @param oneCharArr
     * @param twoCharArr
     * @param threeCharArr
     * @return
     */
    private static boolean calculate(int indexOne, int indexTwo, int indexThree, char[] oneCharArr, char[] twoCharArr, char[] threeCharArr) {
        if (indexOne < oneCharArr.length) {
            char oneChar = oneCharArr[indexOne];
            char threeChar = threeCharArr[indexThree];
            indexThree++;
            if (indexTwo < twoCharArr.length) {
                char twoChar = twoCharArr[indexTwo];
                if (oneChar == threeChar) {
                    if (calculate(indexOne + 1, indexTwo, indexThree, oneCharArr, twoCharArr, threeCharArr)) {
                        return true;
                    } else if (twoChar == threeChar) {
                        return calculate(indexOne, ++indexTwo, indexThree, oneCharArr, twoCharArr, threeCharArr);
                    } else {
                        return false;
                    }
                } else if (twoChar == threeChar) {
                    return calculate(indexOne, ++indexTwo, indexThree, oneCharArr, twoCharArr, threeCharArr);
                } else {
                    return false;
                }
            } else {
                if (oneChar == threeChar) {
                    return calculate(++indexOne, indexTwo, indexThree, oneCharArr, twoCharArr, threeCharArr);
                } else {
                    return false;
                }
            }
        } else if (indexTwo < twoCharArr.length) {
            char twoChar = twoCharArr[indexTwo];
            char threeChar = threeCharArr[indexThree];
            indexThree++;
            if (twoChar == threeChar) {
                return calculate(indexOne, ++indexTwo, indexThree, oneCharArr, twoCharArr, threeCharArr);
            } else {
                return false;
            }
        } else {
            return indexThree == threeCharArr.length;
        }
    }

    // Other people solution
    // 用三个栈去保存当时有异议的操作
    /*private static String solution(String line) {
        String[] params = line.split(",");
        String deque1 = params[0], deque2 = params[1], deque = params[2];
        if (deque.length() != deque1.length() + deque2.length()) return "false";
        java.util.Stack<Integer> stack1 = new java.util.Stack<Integer>();
        java.util.Stack<Integer> stack2 = new java.util.Stack<Integer>();
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        int index1 = 0, index2 = 0, index = 0;
        while (index < deque.length()) {
            if (index1 < deque1.length() && deque.charAt(index) == deque1.charAt(index1) && index2 < deque2.length() && deque.charAt(index) == deque2.charAt(index2)) {
                stack1.push(index1);
                stack2.push(index2);
                stack.push(index);
                index++;
                index1++;
            } else if (index1 < deque1.length() && deque.charAt(index) == deque1.charAt(index1)) {
                index++;
                index1++;
            } else if (index2 < deque2.length() && deque.charAt(index) == deque2.charAt(index2)) {
                index++;
                index2++;
            } else {
                if (stack.isEmpty()) return "false";
                index1 = stack1.pop();
                index2 = stack2.pop() + 1;
                index = stack.pop() + 1;
            }
        }
        // 返回处理后的结果
        return "true";
    }*/
}
