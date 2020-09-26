/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.bsearch;

/**
 * 查找最后一个等于给定值的元素
 *
 * @author xingye
 * @created 2020/9/26
 */
public class BiSearch2 {

    private Integer searchLast(int[] nums, int x) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == x) {
                if (mid < nums.length - 1 && nums[mid + 1] == x) {
                    low = mid + 1;
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
        BiSearch2 biSearch2 = new BiSearch2();
        System.out.println(biSearch2.searchLast(new int[]{1, 2, 2, 3, 3, 3, 5, 7, 9}, 3));
        System.out.println(biSearch2.searchLast(new int[]{3, 3, 3, 5, 7, 9}, 3));
        System.out.println(biSearch2.searchLast(new int[]{1, 2, 2, 3, 3, 3}, 3));
        System.out.println(biSearch2.searchLast(new int[]{6, 7, 8, 9, 10}, 3));
        System.out.println(biSearch2.searchLast(new int[]{-1, -2, 0, 1, 2}, 3));
    }

}