/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item59;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/10/10
 */
public class MaxValueOfQueue3 {
    /** 正常队列 */
    private Deque<Integer> queue;
    /** 单调队列 */
    private Deque<Integer> help;

    public MaxValueOfQueue3() {
        queue = new ArrayDeque<>();
        help = new ArrayDeque<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : help.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!help.isEmpty() && value > help.peekLast()) {
            help.pollLast();
        }
        help.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int val = queue.pop();
        if (help.peek() == val) {
            help.pop();
        }
        return val;
    }
}