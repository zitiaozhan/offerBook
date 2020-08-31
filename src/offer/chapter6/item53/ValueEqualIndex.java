/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item53;

/**
 * P267
 * 数组中数值和下标相等的元素
 *
 * @author xingye
 * @created 2020/8/31
 */
public class ValueEqualIndex {
    public static void main(String... args) {
        ValueEqualIndex valueEqualIndex = new ValueEqualIndex();
        System.out.println(valueEqualIndex.findValueEqualIndex(new int[]{-3, -1, 1, 3, 5}));
        System.out.println(valueEqualIndex.findValueEqualIndex(new int[]{-5, -2, 2}));
        System.out.println(valueEqualIndex.findValueEqualIndex(new int[]{0, 6, 8}));
        System.out.println(valueEqualIndex.findValueEqualIndex(new int[]{1, 2, 3}));
        System.out.println(valueEqualIndex.findValueEqualIndex(new int[]{-3, -2, 0}));
    }

    private Integer findValueEqualIndex(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (mid == nums[mid]) {
                return mid;
            } else if (mid > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}