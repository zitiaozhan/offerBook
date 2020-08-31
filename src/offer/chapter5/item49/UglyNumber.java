/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item49;

import java.util.Arrays;

/**
 * P240
 * 丑数
 *
 * @author xingye
 * @created 2020/8/29
 */
public class UglyNumber {

    /**
     * 获取第N个丑数
     */
    private long[] uglyNumber(int n) {
        if (n < 1) {
            return null;
        }
        long[] nums = new long[n];
        nums[0] = 1;
        int pos2 = 0, pos3 = 0, pos5 = 0;
        int nextUgly = 1;

        while (nextUgly < n) {
            nums[nextUgly] = min(2 * nums[pos2], 3 * nums[pos3], 5 * nums[pos5]);
            while (nums[nextUgly] >= 2 * nums[pos2]) {
                pos2++;
            }
            while (nums[nextUgly] >= 3 * nums[pos3]) {
                pos3++;
            }
            while (nums[nextUgly] >= 5 * nums[pos5]) {
                pos5++;
            }

            nextUgly++;
        }

        return nums;
    }

    private long min(long val2, long val3, long val5) {
        long min = Math.min(val2, val3);
        return Math.min(min, val5);
    }

    /**
     * 丑数判定
     */
    private boolean isUgly(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }

    public static void main(String... args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(Arrays.toString(uglyNumber.uglyNumber(100)));
    }
}