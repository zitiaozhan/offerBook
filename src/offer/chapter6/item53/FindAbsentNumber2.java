/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item53;

/**
 * 0~n-1中缺失的数字
 *
 * @author xingye
 * @created 2020/9/21
 */
public class FindAbsentNumber2 {

    private int findAbsentNumber(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return -1;
        }

        int left = 0, right = nums.length - 1, mid = (left + right) >> 1;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] != mid) {
                if (mid > 0 && nums[mid - 1] != mid - 1) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else {
                left = mid + 1;
            }
        }
        if (mid == 0) {
            return 0;
        }
        return -1;
    }

    public static void main(String... args) {
        FindAbsentNumber2 absentNumber2 = new FindAbsentNumber2();
        System.out.println(absentNumber2.findAbsentNumber(new int[]{0, 1, 3}));
        System.out.println(absentNumber2.findAbsentNumber(new int[]{1, 2, 3}));
        System.out.println(absentNumber2.findAbsentNumber(new int[]{0, 1, 2, 5, 7}));
    }

}