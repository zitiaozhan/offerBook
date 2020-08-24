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
 * P214
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * @author xingye
 * @created 2020/8/24
 */
public class MedianFinder2 {
    /** initialize your data structure here. */
    public MedianFinder2() {

    }

    /** 默认是小根堆，实现大根堆需要重写一下比较器。 */
    private Queue<Integer> maxHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);
    private Queue<Integer> minHeap = new PriorityQueue<>();
    /** 元素数量 */
    private int size = 0;

    // 时间复杂度：O(logN)
    public void addNum(int num) {
        size++;
        if (size % 2 != 0) {
            // 奇数个，加入最大堆

            // 先加入最小堆，得到最小值再加入最大堆
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            // 偶数个，加入最小堆

            // 先加入最大堆，得到最大值再加入最小堆
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    // 时间复杂度：O(1)
    public double findMedian() {
        if (size <= 0) {
            throw new IllegalArgumentException();
        }
        if (size % 2 != 0) {
            // 奇数个，直接最大堆
            return (double) maxHeap.peek();
        } else {
            // 偶数个，左边最大值+右边最小值 / 2
            return (maxHeap.peek() + minHeap.peek()) / 2D;
        }
    }

    public static void main(String... args) {
        MedianFinder2 finder = new MedianFinder2();
        finder.addNum(3);
        System.out.println(finder.findMedian());
        finder.addNum(5);
        System.out.println(finder.findMedian());
        finder.addNum(8);
        System.out.println(finder.findMedian());
        finder.addNum(9);
        System.out.println(finder.findMedian());
        finder.addNum(4);
        System.out.println(finder.findMedian());
        finder.addNum(7);
        System.out.println(finder.findMedian());
    }
}