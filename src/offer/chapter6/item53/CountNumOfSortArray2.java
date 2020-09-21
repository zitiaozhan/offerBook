/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item53;

/**
 * 数字在排序数组中出现的次数
 *
 * @author xingye
 * @created 2020/9/21
 */
public class CountNumOfSortArray2 {

    private int countNum(int[] nums, int x) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        int left = 0, right = nums.length - 1, mid = -1;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] == x) {
                break;
            } else if (nums[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int count = 0;
        int index = mid;
        while (index < nums.length && nums[index] == x) {
            count++;
            index++;
        }
        index = mid - 1;
        while (index >= 0 && nums[index] == x) {
            count++;
            index--;
        }
        return count;
    }

    public static void main(String... args) {
        CountNumOfSortArray2 ofSortArray2 = new CountNumOfSortArray2();
        System.out.println(ofSortArray2.countNum(new int[]{1, 5, 6, 7, 7, 7, 7, 8, 10}, 1));
        System.out.println(ofSortArray2.countNum(new int[]{1, 5, 6, 7, 7, 7, 7, 8, 10}, 10));
    }

}