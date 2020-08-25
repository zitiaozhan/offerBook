/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item45;

import java.util.Arrays;

/**
 * P227
 * 把数组排成最小的数
 *
 * @author xingye
 * @created 2020/8/25
 */
public class SortArrayAsMin {

    private void sortArrayAsMin(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }

        // 最小值的下标
        int x;
        for (int i = 0; i < nums.length; ++i) {
            x = i;
            for (int j = i; j < nums.length; j++) {
                x = compare(nums[x], nums[j]) > 0 ? x : j;
            }
            if (x != i) {
                swap(nums, i, x);
            }
        }
    }

    private int compare(int num1, int num2) {
        long left = Long.parseLong(num1 + "" + num2);
        long right = Long.parseLong(num2 + "" + num1);
        if (left <= right) {
            return 1;
        }
        return -1;
    }

    private void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public static void main(String... args) {
        SortArrayAsMin sortArrayAsMin = new SortArrayAsMin();
        int[] nums = new int[]{3, 32, 321};
        sortArrayAsMin.sortArrayAsMin(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{10, 109, 22};
        sortArrayAsMin.sortArrayAsMin(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{18, 178, 1633};
        sortArrayAsMin.sortArrayAsMin(nums);
        System.out.println(Arrays.toString(nums));
    }
}