package com.leaf.leetcode;

import java.util.Stack;

/**
 * @author tongshujian
 * @date 2020/5/12
 */
public class Lc155 {

    Stack<Integer> dataStack ;
    Stack<Integer> minStack;



    /** initialize your data structure here. */
    public Lc155() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        dataStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
