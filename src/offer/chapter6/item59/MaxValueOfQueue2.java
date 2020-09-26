/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item59;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 队列的最大值
 *
 * @author xingye
 * @created 2020/9/25
 */
public class MaxValueOfQueue2 {
    private static class InternalData {
        private int index;
        private int val;

        public InternalData(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    /** 下标 */
    private Deque<InternalData> maxDeque = new ArrayDeque<>();
    private List<InternalData> queue = new ArrayList<>();
    private int curIndex = 0;

    private void pushBack(int num) {
        while (!maxDeque.isEmpty() && num >= maxDeque.getLast().val) {
            maxDeque.removeLast();
        }
        // 入队
        InternalData curData = new InternalData(curIndex++, num);
        maxDeque.offer(curData);
        queue.add(curData);
    }

    private int popFront() {
        if (queue.isEmpty()) {
            throw new IllegalArgumentException("队列已空");
        }

        InternalData internalData = queue.remove(0);
        if (internalData.index == maxDeque.getFirst().index) {
            maxDeque.pop();
        }
        return internalData.val;
    }

    private int max() {
        if (queue.isEmpty()) {
            throw new IllegalArgumentException("队列已空");
        }
        return maxDeque.getFirst().val;
    }

    public static void main(String... args) {
        MaxValueOfQueue2 valueOfQueue = new MaxValueOfQueue2();
        valueOfQueue.pushBack(2);
        valueOfQueue.pushBack(3);
        valueOfQueue.pushBack(6);
        valueOfQueue.pushBack(1);
        valueOfQueue.pushBack(2);
        valueOfQueue.pushBack(4);

        valueOfQueue.popFront();
        System.out.println(valueOfQueue.max());
        valueOfQueue.popFront();
        System.out.println(valueOfQueue.max());
        valueOfQueue.popFront();
        System.out.println(valueOfQueue.max());

        valueOfQueue.pushBack(5);
        valueOfQueue.popFront();
        System.out.println(valueOfQueue.max());
        valueOfQueue.pushBack(8);
        valueOfQueue.popFront();
        System.out.println(valueOfQueue.max());
    }
}