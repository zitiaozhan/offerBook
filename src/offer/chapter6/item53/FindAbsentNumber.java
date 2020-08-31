/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item53;

/**
 * P266
 * 0~n-1中缺失的数字
 *
 * @author xingye
 * @created 2020/8/31
 */
public class FindAbsentNumber {

    public static void main(String... args) {
        FindAbsentNumber findAbsentNumber = new FindAbsentNumber();
        System.out.println(findAbsentNumber.findAbsentNumber(new int[]{0, 1, 2, 4, 5, 6}));
        System.out.println(findAbsentNumber.findAbsentNumber(new int[]{0, 1, 3, 4, 5, 6}));
        System.out.println(findAbsentNumber.findAbsentNumber(new int[]{1, 2}));
        System.out.println(findAbsentNumber.findAbsentNumber(new int[]{0, 1}));
    }

    private int findAbsentNumber(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return -1;
        }

        // 利用二分元素与下标相等判断
        return findAbsentNumberCore(nums);
    }

    private int findAbsentNumberCore(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (mid == nums[mid]) {
                if (mid == nums.length - 1) {
                    // 最右都相等
                    return nums[mid] + 1;
                }
                left = mid + 1;
            } else {
                // 实际元素大于下标情况
                if (mid == 0 || mid - 1 == nums[mid - 1]) {
                    // 最左边 或 左边元素与下边相等，直接返回
                    return nums[mid] - 1;
                }
                // 左边元素也大于下标，则right收缩
                right = mid - 1;
            }
        }
        return -1;
    }
}