/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item21;

import java.util.Arrays;

/**
 * P129
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * @author xingye
 * @created 2020/9/13
 */
public class Exchange2 {

    public int[] exchange(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return nums;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            if ((nums[left] & 1) == 1) {
                left++;
            } else {
                if ((nums[right] & 1) == 1) {
                    swap(nums, left, right);
                    left++;
                }
                right--;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

    public static void main(String... args) {
        Exchange2 exchange2 = new Exchange2();
        System.out.println(Arrays.toString(exchange2.exchange(new int[]{1, 2, 3, 4, 5, 6, 7})));
        System.out.println(Arrays.toString(exchange2.exchange(new int[]{1})));
        System.out.println(Arrays.toString(exchange2.exchange(new int[]{2})));
    }

}