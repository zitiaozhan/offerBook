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
 * P288
 * 滑动窗口的最大值
 *
 * @author xingye
 * @created 2020/9/5
 */
public class MaxValueOfSlideWindow {

    public static void main(String... args) {
        MaxValueOfSlideWindow slideWindow = new MaxValueOfSlideWindow();
        System.out.println(Arrays.toString(slideWindow.maxValueOfSlideWindow(new int[]{2, 3, 6, 1, 2, 1, 5, 8}, 3)));
        System.out.println(Arrays.toString(slideWindow.maxValueOfSlideWindow(new int[]{2, 3, 6, 1, 2, 4, 5, 8}, 3)));
    }

    private int[] maxValueOfSlideWindow(int[] nums, int size) {
        if (null == nums || 0 == nums.length || size > nums.length) {
            return null;
        }
        // 滑动窗口的数量
        int len = size > nums.length ? 1 : nums.length - size + 1;
        int[] maxVal = new int[len];
        int index = 0;
        // 下标双端队列
        Deque<Integer> indexDeque = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!indexDeque.isEmpty() && nums[i] >= nums[indexDeque.getLast()]) {
                // 利用了插排原理，但保存的是下标,双端队列的first为最大值下标
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }

        for (int i = size; i < nums.length; i++) {
            // 添加最大值
            maxVal[index++] = nums[indexDeque.getFirst()];

            while (!indexDeque.isEmpty() && nums[i] >= nums[indexDeque.getLast()]) {
                // 利用了插排原理，但保存的是下标,双端队列的first为最大值下标
                indexDeque.removeLast();
            }
            if (!indexDeque.isEmpty() && indexDeque.getFirst() <= i - size) {
                // 旧的最大值滑出窗口
                indexDeque.removeFirst();
            }
            indexDeque.addLast(i);
        }
        // 添加最大值
        maxVal[index] = nums[indexDeque.getFirst()];
        return maxVal;
    }

}