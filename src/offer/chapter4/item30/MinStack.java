/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item30;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * @author xingye
 * @created 2020/8/1
 */
public class MinStack {
    public static void main(String... args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }

    private Stack<Integer> values = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        values.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            Integer lastMin = minStack.peek();
            minStack.push(Math.min(lastMin, x));
        }
    }

    public void pop() {
        values.pop();
        minStack.pop();
    }

    public int top() {
        return values.peek();
    }

    public int min() {
        return minStack.peek();
    }
}