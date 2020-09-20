/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item51;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 *
 * @author xingye
 * @created 2020/9/20
 */
public class ReversePairs {
    int count = 0;

    public int reversePairs(int[] nums) {
        count = 0;
        if (null == nums || 0 == nums.length) {
            return count;
        }

        // 利用归并排序原理
        countReversePairs(nums, 0, nums.length - 1);
        return count;
    }

    private void countReversePairs(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            countReversePairs(nums, start, mid);
            countReversePairs(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int left = mid, right = end, index = end - start;
        int[] help = new int[end - start + 1];
        while (left >= start && right > mid) {
            if (nums[left] > nums[right]) {
                help[index--] = nums[left--];
                count += right - mid;
            } else {
                help[index--] = nums[right--];
            }
        }
        while (left >= start) {
            help[index--] = nums[left--];
        }
        while (right > mid) {
            help[index--] = nums[right--];
        }
        index = 0;
        for (int i = start; i <= end; i++) {
            nums[i] = help[index++];
        }
    }

    public static void main(String... args) {
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(new int[]{7, 5, 6, 4}));
        System.out.println(reversePairs.reversePairs(new int[]{1, 3, 2, 3, 1}));
    }

}