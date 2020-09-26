/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.bsearch;

/**
 * 查找第一个大于等于给定值的元素
 *
 * @author xingye
 * @created 2020/9/26
 */
public class BiSearch3 {

    public Integer searchFirst(int[] nums, int x) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] >= x) {
                if (mid > 0 && nums[mid - 1] >= x) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public static void main(String... args) {
        BiSearch3 biSearch3 = new BiSearch3();
        System.out.println(biSearch3.searchFirst(new int[]{1, 2, 2, 3, 3, 5, 7, 9}, 3));
        System.out.println(biSearch3.searchFirst(new int[]{3, 3, 5, 7, 9}, 3));
        System.out.println(biSearch3.searchFirst(new int[]{1, 2, 2, 3, 3}, 3));
        System.out.println(biSearch3.searchFirst(new int[]{1, 2, 2, 3, 3}, 3));
        System.out.println(biSearch3.searchFirst(new int[]{1, 2, 2}, 3));
        System.out.println(biSearch3.searchFirst(new int[]{7, 8, 9}, 3));
    }

}