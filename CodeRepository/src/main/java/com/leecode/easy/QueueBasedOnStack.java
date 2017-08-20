package com.leecode.easy;

import java.util.Stack;

/**
 * Created by xhans on 2016/2/14.
 */
public class QueueBasedOnStack {

    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        filledOutStack();
        out.pop();
    }

    // Get the front element.
    public int peek() {
        filledOutStack();
        return out.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    //如果out栈空了，就把in栈的元素填充到out中
    private void filledOutStack() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
    }
}
