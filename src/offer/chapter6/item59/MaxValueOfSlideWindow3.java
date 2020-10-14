/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item59;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * @author xingye
 * @created 2020/10/10
 */
public class MaxValueOfSlideWindow3 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || k < 1) {
            return new int[]{};
        }

        if (k == 1) {
            return nums;
        }

        int[] res = new int[nums.length - k + 1];
        int index = 0;

        Deque<Integer> indexDeque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 小于窗口大小，直接添加
            if (i < k - 1) {
                // 保持单调队列
                while (!indexDeque.isEmpty() && nums[i] >= nums[indexDeque.getLast()]) {
                    indexDeque.removeLast();
                }
                indexDeque.offer(i);
                continue;
            }

            // 队首超出窗口范围，出队
            if (!indexDeque.isEmpty() && i - indexDeque.getFirst() >= k) {
                indexDeque.removeFirst();
            }

            // 保持单调队列
            while (!indexDeque.isEmpty() && nums[i] >= nums[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.offer(i);
            res[index++] = nums[indexDeque.getFirst()];
        }

        return res;
    }

    public static void main(String... args) {
        MaxValueOfSlideWindow3 slideWindow3 = new MaxValueOfSlideWindow3();
        System.out.println(Arrays.toString(slideWindow3.maxSlidingWindow(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3)));
        System.out.println(Arrays.toString(slideWindow3.maxSlidingWindow(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 2)));
    }
}