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
 * P292
 * 队列的最大值
 *
 * @author xingye
 * @created 2020/9/5
 */
public class MaxValueOfQueue {
    private static class InternalData {
        private int index;
        private int val;

        public InternalData(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    private Deque<InternalData> indexDeque = new ArrayDeque<>();
    private List<InternalData> queue = new ArrayList<>();
    private int curIndex = 0;

    private int max() {
        if (queue.isEmpty()) {
            throw new IllegalArgumentException("队列已空");
        }
        return indexDeque.getFirst().val;
    }

    private void pushBack(int num) {
        while (!indexDeque.isEmpty() && num >= indexDeque.getLast().val) {
            indexDeque.removeLast();
        }
        InternalData data = new InternalData(curIndex++, num);
        queue.add(data);
        indexDeque.addLast(data);
    }

    private void popFront() {
        if (queue.isEmpty()) {
            throw new IllegalArgumentException("队列已空");
        }
        InternalData data = queue.get(0);
        if (data.index == indexDeque.getFirst().index) {
            indexDeque.removeFirst();
        }
        queue.remove(0);
    }

    public static void main(String... args) {
        MaxValueOfQueue valueOfQueue = new MaxValueOfQueue();
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