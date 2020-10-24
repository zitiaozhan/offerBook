/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.timer;

/**
 * 队列
 *
 * @author xingye
 * @created 2020/10/24
 */
public class CustomQueue {
    /** 容量 */
    private int capacity;
    /** 长度 */
    private volatile int size;
    /** 数组 */
    private final CustomTask[] customTasks;

    public CustomQueue(int capacity) {
        this.capacity = capacity;
        customTasks = new CustomTask[capacity];
        this.size = 0;
    }

    public void offer(CustomTask customTask) {
        if (null == customTask) {
            return;
        }
        if (size >= capacity) {
            throw new IllegalArgumentException();
        }

        synchronized (customTasks) {
            int curIndex = size;
            customTasks[size++] = customTask;

            while (curIndex > 0 && customTask.getRunTime() < customTasks[(curIndex - 1) >> 1].getRunTime()) {
                swap(curIndex, (curIndex - 1) >> 1);
                curIndex = (curIndex - 1) >> 1;
            }
        }
    }

    public CustomTask peek() {
        if (size > 0) {
            return customTasks[0];
        }
        throw new IllegalArgumentException();
    }

    public CustomTask poll() {
        // 目标任务
        CustomTask target = peek();

        synchronized (customTasks){
            // 出队逻辑
            customTasks[0] = customTasks[size];
            customTasks[size--] = null;

            // 调整堆结构
            heapify();
        }

        return target;
    }

    private void heapify() {
        int index = 0, left = (index << 1) + 1;
        while (index <= size && left <= size) {
            int small = left + 1 <= size && customTasks[left + 1].getRunTime() < customTasks[left].getRunTime() ? left + 1 : left;
            small = customTasks[small].getRunTime() < customTasks[index].getRunTime() ? small : index;
            if (small == index) {
                break;
            }
            swap(index, small);
            index = small;
            left = (index << 1) + 1;
        }
    }

    private void swap(int a, int b) {
        if (a == b) {
            return;
        }
        CustomTask tmp = customTasks[a];
        customTasks[a] = customTasks[b];
        customTasks[b] = tmp;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }
}