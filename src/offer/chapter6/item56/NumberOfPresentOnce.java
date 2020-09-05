/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item56;

import java.util.Arrays;

/**
 * P275
 * 数组中只出现一次的两个数字，其他数字都出现两次
 *
 * @author xingye
 * @created 2020/9/3
 */
public class NumberOfPresentOnce {

    public static void main(String... args) {
        NumberOfPresentOnce presentOnce = new NumberOfPresentOnce();
        System.out.println(Arrays.toString(presentOnce.numberOfPresentOnce(new int[]{2, 4, 3, 6, 3, 2, 5, 5})));
        System.out.println(Arrays.toString(presentOnce.numberOfPresentOnce(new int[]{0, 0})));
        System.out.println(Arrays.toString(presentOnce.numberOfPresentOnce(new int[]{1, 1})));
        System.out.println(Arrays.toString(presentOnce.numberOfPresentOnce(new int[]{1, 2})));
        System.out.println(Arrays.toString(presentOnce.numberOfPresentOnce(new int[]{1, 1, 2})));
        System.out.println(Arrays.toString(presentOnce.numberOfPresentOnce(new int[]{1, 1, 2, 4, 6, 8, 2, 6})));
    }

    private int[] numberOfPresentOnce(int[] nums) {
        if (null == nums || nums.length < 2) {
            return null;
        }

        int exclusiveOrRes = 0;
        for (int num : nums) {
            exclusiveOrRes ^= num;
        }
        // 得到两个数的异或结果
        if (0 == exclusiveOrRes) {
            return null;
        }
        int position = getPosition(exclusiveOrRes);
        if (-1 == position) {
            return null;
        }
        int x1 = 0, x2 = 0;
        // 数组一分为二，求得两个只出现一次的数字
        for (int num : nums) {
            if (isOneOnPosition(num, position)) {
                x1 ^= num;
            } else {
                x2 ^= num;
            }
        }

        return new int[]{x1, x2};
    }

    private boolean isOneOnPosition(int num, int position) {
        int pos = 0;
        while (num > 0) {
            pos++;
            if (position == pos) {
                return (num & 1) == 1;
            }
            num = num >> 1;
        }
        return false;
    }

    private int getPosition(int exclusiveOrRes) {
        int pos = 0;
        while (exclusiveOrRes > 0) {
            pos++;
            if ((exclusiveOrRes & 1) == 1) {
                return pos;
            }
            exclusiveOrRes = exclusiveOrRes >> 1;
        }
        return -1;
    }
}