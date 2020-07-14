/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item9;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 *
 * @author xingye
 * @created 2020/7/14
 */
public class CStack {
    private Queue<Integer> mainQueue = new LinkedList<>();
    private Queue<Integer> helpQueue = new LinkedList<>();

    public void addTail(int value) {
        mainQueue.add(value);
    }

    public int pop() {
        if (mainQueue.isEmpty()) {
            return -1;
        }

        while (mainQueue.size() > 1) {
            helpQueue.add(mainQueue.poll());
        }
        int res = mainQueue.poll();

        // 交换引用
        Queue<Integer> temp = mainQueue;
        mainQueue = helpQueue;
        helpQueue = temp;
        return res;
    }

    public static void main(String... args) {
        CStack stack = new CStack();
        stack.addTail(1);
        stack.addTail(2);
        stack.addTail(3);
        System.out.println(stack.pop());
        stack.addTail(4);
        System.out.println(stack.pop());
        stack.addTail(5);
        System.out.println(stack.pop());
        stack.addTail(6);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}