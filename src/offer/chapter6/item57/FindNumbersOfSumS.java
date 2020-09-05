/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item57;

import java.util.Arrays;

/**
 * P280
 * 和为S的两个数字(数组递增)
 *
 * @author xingye
 * @created 2020/9/3
 */
public class FindNumbersOfSumS {
    public static void main(String... args) {
        FindNumbersOfSumS numbersOfSumS = new FindNumbersOfSumS();
        System.out.println(Arrays.toString(numbersOfSumS.findNumbersOfSumS(new int[]{1, 2, 3, 4, 5, 6, 7}, 5)));
        System.out.println(Arrays.toString(numbersOfSumS.findNumbersOfSumS(new int[]{1, 2, 4, 7, 11, 15}, 15)));
        System.out.println(Arrays.toString(numbersOfSumS.findNumbersOfSumS(new int[]{1, 2}, 0)));
    }

    private int[] findNumbersOfSumS(int[] nums, int s) {
        if (null == nums || nums.length < 2) {
            return null;
        }

        // 左右双指针，利用数组递增有序特性
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == s) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < s) {
                // left右移，增大sum
                left++;
            } else {
                // sum>s,则right左移，减小sum
                right--;
            }
        }
        return null;
    }
}