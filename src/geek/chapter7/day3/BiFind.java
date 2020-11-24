/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day3;

/**
 * 实现一个有序数组的二分查找算法
 * 实现模糊二分查找算法（比如大于等于给定值的第一个元素）
 *
 * @author xingye
 * @created 2020/11/24
 */
public class BiFind {
    private int biFind(int[] nums, int x) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == x) {
                return mid;
            } else if (nums[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int biFindLargeEquals(int[] nums, int x) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= x) {
                if (mid == 0 || nums[mid - 1] < x) {
                    return nums[mid];
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String... args) {
        BiFind biFind = new BiFind();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15};
        System.out.println(biFind.biFind(nums, 5));
        System.out.println(biFind.biFindLargeEquals(nums, 13));
    }
}