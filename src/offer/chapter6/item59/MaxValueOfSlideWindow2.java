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
 * 滑动窗口的最大值
 *
 * @author xingye
 * @created 2020/9/23
 */
public class MaxValueOfSlideWindow2 {

    private List<Integer> maxValInSlidWindow(int[] nums, int windowSize) {
        List<Integer> res = new ArrayList<>();
        if (null == nums || windowSize > nums.length) {
            return res;
        }
        if (windowSize == 1) {
            for (int num : nums) {
                res.add(num);
            }
            return res;
        }

        int index;
        // 记录下标
        Deque<Integer> valIndexDeque = new ArrayDeque<>();
        // 滑动窗口
        Deque<Integer> window = new ArrayDeque<>(windowSize);

        // 1.初始化，入队 窗口大小 个元素
        for (index = 0; index < nums.length; index++) {
            if (window.isEmpty()) {
                window.offer(nums[index]);
                valIndexDeque.offer(index);
            } else {
                while (!window.isEmpty() && nums[index] > window.getLast()) {
                    // 出栈
                    window.removeLast();
                    valIndexDeque.removeLast();
                }
                window.offer(nums[index]);
                valIndexDeque.offer(index);
                if (index >= windowSize - 1) {
                    while (!valIndexDeque.isEmpty() && valIndexDeque.peek() <= index - windowSize) {
                        // 出队
                        valIndexDeque.poll();
                    }
                    if (!valIndexDeque.isEmpty()) {
                        res.add(nums[valIndexDeque.peek()]);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String... args) {
        MaxValueOfSlideWindow2 slideWindow2 = new MaxValueOfSlideWindow2();
        System.out.println(slideWindow2.maxValInSlidWindow(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
        System.out.println(slideWindow2.maxValInSlidWindow(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 2));
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        System.out.println(deque.peek());
        System.out.println(deque.removeLast());
        System.out.println(deque.peek());
        System.out.println(deque.poll());
        System.out.println(deque.peek());
    }

}