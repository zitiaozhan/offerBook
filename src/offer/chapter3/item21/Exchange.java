/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item21;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * @author xingye
 * @created 2020/7/27
 */
public class Exchange {
    public static void main(String... args) {
        Exchange exchange = new Exchange();
        System.out.println(Arrays.toString(exchange.exchange(new int[]{2, 1})));
        System.out.println(Arrays.toString(exchange.exchange2(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(exchange.exchange3(new int[]{1, 2, 3, 4})));
    }

    public int[] exchange(int[] nums) {
        if (null == nums || nums.length < 2) {
            return nums;
        }

        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            if (!judge(nums[head]) && judge(nums[tail])) {
                // 如果前者不满足条件，后者满足条件，则交换
                int temp = nums[tail];
                nums[tail] = nums[head];
                nums[head] = temp;
            }
            if (judge(nums[head])) {
                // 前者满足条件则前者前进
                head++;
            }
            if (!judge(nums[tail])) {
                // 后者不满足条件则前进
                tail--;
            }
        }

        return nums;
    }

    public int[] exchange2(int[] nums) {
        if (null == nums || nums.length < 2) {
            return nums;
        }

        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            while (head < tail && judge(nums[head])) {
                head++;
            }
            while (head < tail && !judge(nums[tail])) {
                tail--;
            }
            if (head < tail) {
                int temp = nums[tail];
                nums[tail] = nums[head];
                nums[head] = temp;
            }
        }

        return nums;
    }

    public int[] exchange3(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while ((nums[i] & 1) == 1 && i < j) {
                i++;
            }
            while ((nums[j] & 1) == 0 && i < j) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    /**
     * 奇数判断
     *
     * @param num 数字
     * @return
     */
    private boolean judge(int num) {
        return (num & 1) == 1;
    }
}