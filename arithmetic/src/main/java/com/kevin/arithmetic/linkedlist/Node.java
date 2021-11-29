package com.kevin.arithmetic.linkedlist;

public class Node {

    public int value;
    public Node nextNode;
    public Node lastNode;

    public int val;
    public Node left;
    public Node right;

    public Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}