/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item57;

import java.util.Arrays;

/**
 * 和为S的数字
 *
 * @author xingye
 * @created 2020/9/23
 */
public class FindNumbersOfSumS2 {

    private int[] find(int[] nums, int sum) {
        if (null == nums || nums.length < 2) {
            return new int[]{};
        }

        // 升序数组+双指针
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int tmp = nums[low] + nums[high];
            if (tmp == sum) {
                return new int[]{nums[low], nums[high]};
            }
            while (tmp > sum && low < high) {
                high--;
                tmp = nums[low] + nums[high];
            }
            while (tmp < sum && low < high) {
                low++;
                tmp = nums[low] + nums[high];
            }
        }
        return new int[]{};
    }

    public static void main(String... args) {
        FindNumbersOfSumS2 numbersOfSumS2 = new FindNumbersOfSumS2();
        System.out.println(Arrays.toString(numbersOfSumS2.find(new int[]{1, 2, 4, 7, 11, 15}, 15)));
        System.out.println(Arrays.toString(numbersOfSumS2.find(new int[]{1, 2, 4, 7, 11, 15}, 16)));
        System.out.println(Arrays.toString(numbersOfSumS2.find(new int[]{1, 2, 4, 7, 11, 15}, 14)));
        System.out.println(Arrays.toString(numbersOfSumS2.find(new int[]{1, 2, 4, 7, 11, 15}, 13)));
        System.out.println(Arrays.toString(numbersOfSumS2.find(new int[]{1, 2, 4, 7, 11, 15}, 17)));
        System.out.println(Arrays.toString(numbersOfSumS2.find(new int[]{1, 2, 4, 7, 11, 15}, 19)));
        System.out.println(Arrays.toString(numbersOfSumS2.find(new int[]{1, 2, 4, 7, 11, 15}, 26)));
        System.out.println(Arrays.toString(numbersOfSumS2.find(new int[]{1, 2, 4, 7, 11, 15}, 30)));
    }

}