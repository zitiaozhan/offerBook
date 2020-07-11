/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item3;

/**
 * 剑指offer第2题
 * 不修改数组找出重复的数字
 * 在一个长度为n的数组里的所有数字都在1~n的范围内，
 * 所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}，
 * 那么对应的输出是重复的数字2或者3
 *
 * @author xingye
 * @created 2020/7/6
 */
public class FindRepeatNumber2 {

    // n lgn
    public static int findRepeatNumber2(int[] nums) {
        if (null == nums || nums.length < 2) {
            return -1;
        }
        int start = 1, end = nums.length + 1, mid;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            int count = countNumberRange(nums, start, mid);
            if (count > 1 && start == end) {
                return start;
            }
            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int countNumberRange(int[] nums, int start, int mid) {
        if (nums == null || nums.length < 2 || mid < 1) {
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            if (num <= mid && num >= start) {
                count++;
            }
        }
        return count;
    }

    public static void main(String... args) {
        int[] nums = new int[]{2, 1, 2, 3, 4};
        System.out.println(findRepeatNumber2(nums));
        int[] nums1 = new int[]{2, 3, 1, 3, 2, 5, 3};
        System.out.println(findRepeatNumber2(nums1));
        int[] nums2 = new int[]{1};
        System.out.println(findRepeatNumber2(nums2));
        int[] nums3 = new int[]{3, 3, 3, 3, 3, 3};
        System.out.println(findRepeatNumber2(nums3));
    }
}