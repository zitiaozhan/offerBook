/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item51;

/**
 * P249
 * 数组中的逆序对
 *
 * @author xingye
 * @created 2020/8/30
 */
public class ArrayReverseOrder {

    private int count = 0;

    private void countReverseOrder(int[] nums) {
        count = 0;
        if (null == nums || nums.length == 0) {
            return;
        }

        countReverseOrderCore(nums, 0, nums.length - 1);
    }

    private void countReverseOrderCore(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            countReverseOrderCore(nums, left, mid);
            countReverseOrderCore(nums, mid + 1, right);
            // 归并排序
            mergeSort(nums, left, mid, right);
        }
    }

    private void mergeSort(int[] nums, int left, int mid, int right) {
        int l = mid, r = right, index = right - left;
        int[] help = new int[right - left + 1];

        while (l >= left && r > mid) {
            if (nums[r] < nums[l]) {
                // 发现逆序对
                count += r - mid;
            }
            help[index--] = nums[r] >= nums[l] ? nums[r--] : nums[l--];
        }

        while (l >= left) {
            help[index--] = nums[l--];
        }
        while (r > mid) {
            help[index--] = nums[r--];
        }

        // 赋值到原数组
        index = 0;
        for (int i = left; i <= right; i++) {
            nums[i] = help[index++];
        }
    }

    public static void main(String... args) {
        ArrayReverseOrder order = new ArrayReverseOrder();
        order.countReverseOrder(new int[]{7, 5, 6, 4});
        System.out.println(order.count);
        order.countReverseOrder(new int[]{7, 5});
        System.out.println(order.count);
        order.countReverseOrder(new int[]{5, 6});
        System.out.println(order.count);
        order.countReverseOrder(new int[]{7});
        System.out.println(order.count);
    }

}