/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.bsearch;

/**
 * 查找最后一个小于等于给定值的元素
 *
 * @author xingye
 * @created 2020/9/26
 */
public class BiSearch4 {

    public Integer searchLast(int[] nums, int x) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] <= x) {
                if (mid < nums.length - 1 && nums[mid + 1] <= x) {
                    low = mid + 1;
                } else {
                    return mid;
                }
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String... args) {
        BiSearch4 biSearch4 = new BiSearch4();
        System.out.println(biSearch4.searchLast(new int[]{1, 2, 3, 3, 3, 4}, 3));
        System.out.println(biSearch4.searchLast(new int[]{1, 2, 3, 3, 3}, 3));
        System.out.println(biSearch4.searchLast(new int[]{3, 3, 4, 6}, 3));
        System.out.println(biSearch4.searchLast(new int[]{5, 7, 9}, 3));
        System.out.println(biSearch4.searchLast(new int[]{2, 2, 5, 7, 9}, 3));
    }

}