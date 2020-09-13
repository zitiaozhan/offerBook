/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item9;

import java.util.Stack;

/**
 * P68
 * 用两个栈实现队列
 *
 * @author xingye
 * @created 2020/9/12
 */
public class MyQueue {
    private Stack<Integer> addStack = new Stack<>();
    private Stack<Integer> pollStack = new Stack<>();

    public void push(int val) {
        addStack.push(val);
    }

    public int poll() {
        if (!pollStack.isEmpty()) {
            return pollStack.pop();
        }
        if (addStack.isEmpty()) {
            throw new IllegalArgumentException("队列已空");
        }
        while (!addStack.isEmpty()) {
            pollStack.add(addStack.pop());
        }
        return pollStack.pop();
    }

    public static void main(String... args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.poll());
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        myQueue.push(5);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
    }
}