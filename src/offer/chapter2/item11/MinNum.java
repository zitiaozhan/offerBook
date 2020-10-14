/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item11;

/**
 * P82
 * 旋转数组中的最小数字
 *
 * @author xingye
 * @created 2020/9/12
 */
public class MinNum {

    private Integer minNum(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            // 画出波形在分析，一共四种波形
            if (nums[mid] < nums[right]) {
                // 递增
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String... args) {
        MinNum minNum = new MinNum();
        System.out.println(minNum.minNum(new int[]{2, 3, 4, 5, 1}));
    }

}