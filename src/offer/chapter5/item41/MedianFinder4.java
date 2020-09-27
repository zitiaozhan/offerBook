/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item41;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xingye
 * @created 2020/9/27
 */
public class MedianFinder4 {
    private Queue<Integer> maxHeap = new PriorityQueue<>((v2, v1) -> v1 - v2);
    private Queue<Integer> minHeap = new PriorityQueue<>();
    private int size = 0;

    public MedianFinder4() {

    }

    public void addNum(int num) {
        size = size + 1;

        if ((size & 1) == 1) {
            // 奇数，放到最大堆
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (size == 0) {
            throw new IllegalArgumentException("无数据");
        }

        if ((size & 1) == 1) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

}