package com.easy;

/**
 * Created by xhans on 2016/2/21.
 */
public class MinStack {
    private Node head;
    public void push(int x) {
        if (head == null){
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node{
        private int min;
        private int val;
        private Node next;

        private Node(int val, int min, Node node){
            this.min = min;
            this.val = val;
            this.next = node;
        }
    }
}
