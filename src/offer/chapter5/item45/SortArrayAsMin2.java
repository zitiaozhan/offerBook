/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item45;

import java.util.Arrays;

/**
 * P45
 * 把数组排成最小的数
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * @author xingye
 * @created 2020/9/20
 */
public class SortArrayAsMin2 {

    private String sort(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }

        // 归并排序
        mergeSort(nums, 0, nums.length - 1);
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }
        return builder.toString();
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int left = start, right = mid + 1;
        int[] help = new int[end - start + 1];
        int index = 0;
        while (left <= mid && right <= end) {
            help[index++] = less(nums[left], nums[right]) ? nums[left++] : nums[right++];
        }
        while (left <= mid) {
            help[index++] = nums[left++];
        }
        while (right <= end) {
            help[index++] = nums[right++];
        }
        // 复制到原数组
        index = 0;
        for (int i = start; i <= end; i++) {
            nums[i] = help[index++];
        }
    }

    private boolean less(int num1, int num2) {
        String left = num1 + "" + num2;
        String right = num2 + "" + num1;
        return left.compareTo(right) < 0;
    }

    public static void main(String... args) {
        SortArrayAsMin2 min2 = new SortArrayAsMin2();
        int[] nums = new int[]{3, 32, 321};
        min2.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}