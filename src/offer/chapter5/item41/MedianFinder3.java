/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item41;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * @author xingye
 * @created 2020/9/19
 */
public class MedianFinder3 {
    /** initialize your data structure here. */
    public MedianFinder3() {
    }

    /** 默认是小根堆，实现大根堆需要重写一下比较器。 */
    private Queue<Integer> maxHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);
    private Queue<Integer> minHeap = new PriorityQueue<>();
    /** 元素数量 */
    private int size = 0;

    public void addNum(int num) {
        // 最大堆保存较小的一半的最大值
        // 最小堆保存较大的一半的最小值
        size++;

        if ((size & 1) == 1) {
            // 奇数时应该放到 大根堆中
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            // 偶数时应该放到 小根堆中
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (size == 0) {
            throw new IllegalArgumentException("数据为空");
        }

        if ((size & 1) == 1) {
            // 奇数时
            return maxHeap.peek();
        } else {
            // 偶数时
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    // 自实现的堆结构
    // DONE:重做标签
    public static class Heap {
        private int[] arrays;
        private int offset = 0;
        private boolean isAsc;

        public Heap(int size, boolean isAsc) {
            this.arrays = new int[size + 1];
            this.isAsc = isAsc;
        }

        public void add(int val) {
            offset += 1;
            arrays[offset] = val;

            int parent;
            int current = offset;
            while ((parent = (current / 2)) != 0 && needReplace(val, arrays[parent])) {
                arrays[current] = arrays[parent];
                arrays[parent] = val;
                current = parent;
            }
        }

        private boolean needReplace(int current, int target) {
            if (isAsc) {
                return current < target;
            } else {
                return current > target;
            }
        }

        public int peek() {
            return arrays[1];
        }

        public int size() {
            return offset;
        }

        public int pop() {
            if (size() == 0) {
                throw new IllegalArgumentException("Empty");
            }

            int val = arrays[1];
            int lastVal = arrays[offset];
            arrays[offset] = 0;
            offset--;

            arrays[1] = lastVal;

            int current = 1;
            do {
                int leftOffset = current * 2;
                if (leftOffset > offset) {
                    break;
                }

                int targetOffset;
                int rightOffset = leftOffset + 1;
                if (rightOffset > offset) {
                    targetOffset = leftOffset;
                } else {
                    targetOffset = needReplace(arrays[leftOffset], arrays[rightOffset]) ? leftOffset : rightOffset;
                }
                if (needReplace(arrays[targetOffset], arrays[current])) {
                    arrays[current] = arrays[targetOffset];
                    arrays[targetOffset] = lastVal;
                    current = targetOffset;
                } else {
                    break;
                }
            } while (true);
            return val;
        }
    }

    public static void main(String... args) {
        MedianFinder3 finder3 = new MedianFinder3();
        finder3.addNum(1);
        System.out.println(finder3.findMedian());
        finder3.addNum(2);
        System.out.println(finder3.findMedian());
    }

}