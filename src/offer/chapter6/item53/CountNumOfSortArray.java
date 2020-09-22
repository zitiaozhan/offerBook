/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item53;

/**
 * 数字在排序数组中出现的次数
 * P263
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * @author xingye
 * @created 2020/8/31
 */
public class CountNumOfSortArray {

    public static void main(String... args) {
        CountNumOfSortArray countNumOfSortArray = new CountNumOfSortArray();
        System.out.println(countNumOfSortArray.countNum(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
        System.out.println(countNumOfSortArray.countNum(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 7));
        System.out.println(countNumOfSortArray.countNum(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, -2));
        System.out.println(countNumOfSortArray.countNum(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 4));
        System.out.println(countNumOfSortArray.countNum(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 5));
        // 无序
        System.out.println(countNumOfSortArray.countNum(new int[]{1, 2, 1}, 1));
        System.out.println(countNumOfSortArray.countNum(new int[]{1, 1, 2}, 1));
    }

    private int countNum(int[] nums, int num) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int leftBorder = findLeftBorder(nums, num);
        int rightBorder = findRightBorder(nums, num);
        if (-1 == leftBorder || -1 == rightBorder) {
            return 0;
        }
        return rightBorder - leftBorder + 1;
    }

    private int findLeftBorder(int[] nums, int num) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == num) {
                if (mid > 0 && nums[mid - 1] == num) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private int findRightBorder(int[] nums, int num) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == num) {
                if (mid < nums.length - 1 && nums[mid + 1] == num) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

}