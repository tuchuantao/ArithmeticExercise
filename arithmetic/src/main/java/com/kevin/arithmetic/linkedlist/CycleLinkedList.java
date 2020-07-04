package com.kevin.arithmetic.linkedlist;

/**
 * 1、链表是否有环？
 * 2、环的长度？
 * 3、环的起点在那？
 */
public class CycleLinkedList {

    public static void main(String[] args) {

        Node header = createLinkedList();
        boolean result = haveCycle(header);
        System.out.println("result=" + result);
        header = createCycleLinkedList();
        result = haveCycle(header);
        System.out.println("result=" + result);

        int cycleLength = cycleLength(createCycleLinkedList());
        System.out.println("cycleLength=" + cycleLength);

        Node cycleStart = findCycleStartIndex(createCycleLinkedList());
        if (cycleStart == null) {
            System.out.println("Linked list no cycle!!");
        } else {
            System.out.println("Linked list have cycle, start index=" + cycleStart.value);
        }
    }

    /**
     * 1、判断是否有环
     *
     * @param header
     * @return
     */
    public static boolean haveCycle(Node header) {
        if (header == null || header.nextNode == null) {
            return false;
        }

        Node oneStep = header;
        Node twoStep = header;
        do {
            oneStep = oneStep.nextNode;
            if (twoStep.nextNode == null) {
                twoStep = null;
            } else {
                twoStep = twoStep.nextNode.nextNode;
            }
        } while (oneStep != twoStep && twoStep != null);

        return oneStep == twoStep;
    }

    /**
     * 2、环的长度
     *
     * @param header
     * @return
     */
    public static int cycleLength(Node header) {
        if (header == null || header.nextNode == null) {
            return -1;
        }

        Node oneStep = header;
        Node twoStep = header;
        do {
            oneStep = oneStep.nextNode;
            if (twoStep.nextNode == null) {
                twoStep = null;
            } else {
                twoStep = twoStep.nextNode.nextNode;
            }
        } while (oneStep != twoStep && twoStep != null);


        if (oneStep == twoStep) { // 有环，此时两个指针在环内的同一位置，
            int stepCount = 0;
            do {
                oneStep = oneStep.nextNode;
                twoStep = twoStep.nextNode.nextNode;
                stepCount++;
            } while (oneStep != twoStep); // 接着再转一圈，


            int length = stepCount * 2 - stepCount; // 快指针比慢指针多走了一圈
            return length;
        }

        return -1;
    }

    /**
     * 3、环的起点
     *
     * @param header
     * @return
     */
    public static Node findCycleStartIndex(Node header) {
        if (header == null || header.nextNode == null) {
            return null;
        }

        Node oneStep = header;
        Node twoStep = header;
        do {
            oneStep = oneStep.nextNode;
            if (twoStep.nextNode == null) {
                twoStep = null;
            } else {
                twoStep = twoStep.nextNode.nextNode;
            }
        } while (oneStep != twoStep && twoStep != null);


        // len 代表环的长度   len1 代码从起点到环的起点的长度   len2代表从环的起点到环内相遇点的长度
        // oneStep   stepCount = len1 + len2
        // twoStep   stepCount * 2 = len1 + len2 + n * len   可能在环内转动的多圈
        // len1 = n * len - len2
        // 所以 用两个1补的指针，同时从header 和 环内相遇的position同时出发，相遇的点就是环的起点
        if (oneStep == twoStep) { // 有环
            oneStep = header;
            do {
                oneStep = oneStep.nextNode;
                twoStep = twoStep.nextNode;
            } while (oneStep != twoStep);
        }

        return oneStep;
    }

    public static Node createLinkedList() {
        Node header = new Node();
        Node lastNode = header;

        for (int i = 0; i < 100; i++) {
            Node node = new Node(i);
            lastNode.nextNode = node;
            lastNode = node;
        }

        return header;
    }

    public static Node createCycleLinkedList() {
        Node header = new Node();
        Node lastNode = header;

        for (int i = 0; i < 100; i++) {
            Node node = new Node(i);
            lastNode.nextNode = node;
            lastNode = node;
        }

        // 创建环
        Node cycleStart = header;
        for (int i = 0; i < 80; i++) {
            cycleStart = cycleStart.nextNode;
        }
        lastNode.nextNode = cycleStart;

        System.out.println("cycle start index=" + cycleStart.value + "  end index=" + lastNode.value);

        return header;
    }
}
