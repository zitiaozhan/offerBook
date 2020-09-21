/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item53;

/**
 * 数组中数值和下标相等的元素
 *
 * @author xingye
 * @created 2020/9/21
 */
public class ValueEqualIndex2 {

    private Integer valueEqualIndex(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }

        int left = 0, right = nums.length - 1, mid = (left + right) >> 1;
        while (left <= right) {
            mid = (right + left) >> 1;
            if (nums[mid] == mid) {
                return mid;
            } else if (nums[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return null;
    }

    public static void main(String... args) {
        ValueEqualIndex2 valueEqualIndex = new ValueEqualIndex2();
        System.out.println(valueEqualIndex.valueEqualIndex(new int[]{-1, 0, 2, 5, 6}));
        System.out.println(valueEqualIndex.valueEqualIndex(new int[]{7, 8, 9, 10}));
        System.out.println(valueEqualIndex.valueEqualIndex(new int[]{-10, -9}));
    }

}