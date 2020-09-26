/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.bsearch;

/**
 * 查找第一个等于给定值的元素（升序数组）
 *
 * @author xingye
 * @created 2020/9/26
 */
public class BiSearch1 {

    private Integer searchFirst(int[] nums, int x) {
        if (null == nums || 0 == nums.length) {
            return null;
        }

        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            // 防止low+high溢出int
            mid = low + ((high - low) >> 1);
            if (nums[mid] == x) {
                if (mid > 0 && nums[mid - 1] == x) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public static void main(String... args) {
        BiSearch1 biSearch1=new BiSearch1();
        System.out.println(biSearch1.searchFirst(new int[]{1, 2, 2, 3, 3, 3, 5, 7, 9}, 3));
        System.out.println(biSearch1.searchFirst(new int[]{3, 3, 3, 5, 7, 9}, 3));
        System.out.println(biSearch1.searchFirst(new int[]{1, 2, 2, 3, 3, 3}, 3));
        System.out.println(biSearch1.searchFirst(new int[]{6, 7, 8, 9, 10}, 3));
        System.out.println(biSearch1.searchFirst(new int[]{-1, -2, 0, 1, 2}, 3));
    }

}