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
 *
 * @author xingye
 * @created 2020/9/20
 */
public class SortArrayAsMin2 {

    private void sort(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return;
        }

        // 归并排序
        mergeSort(nums, 0, nums.length - 1);
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
        int positive = Integer.parseInt(num1 + "" + num2);
        int negative = Integer.parseInt(num2 + "" + num1);
        return positive <= negative;
    }

    public static void main(String... args) {
        SortArrayAsMin2 min2 = new SortArrayAsMin2();
        int[] nums = new int[]{3, 32, 321};
        min2.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

}