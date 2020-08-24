/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item41;

import java.util.LinkedList;
import java.util.List;

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
public class MedianFinder {
    /** 解法1：插入排序 */
    private List<Integer> nums;
    /** size */
    private int size;
    /** 中位数指针-左 */
    private int left;
    /** 中位数指针-右 */
    private int right;
    // 解法2：最大堆+最小堆


    public MedianFinder() {
        nums = new LinkedList<>();
        size = 0;
        left = 0;
        right = 0;
    }

    // O(N)
    public void addNum(int num) {
        int index = 0;
        for (int number : nums) {
            if (num <= number) {
                break;
            }
            index++;
        }
        nums.add(index, num);
        size++;

        index = 0;
        for (int number : nums) {
            if (size % 2 == 0) {
                if (index == size / 2 - 1) {
                    left = number;
                } else if (index == size / 2) {
                    right = number;
                }
            } else {
                if (index == size / 2) {
                    left = number;
                    right = left;
                }
            }
            index++;
        }
    }

    // O(1)
    public double findMedian() {
        return (left + right) / 2D;
    }

    public static void main(String... args) {
        MedianFinder finder = new MedianFinder();
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