/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item3;

/**
 * 剑指offer第1题
 * 找出数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0~N-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是重复的数字2或者3
 *
 * @author xingye
 * @created 2020/7/6
 */
public class FindRepeatNumber {

    public static int findRepeatNumber(int[] nums) {
        if (null == nums || nums.length < 2) {
            return -1;
        }
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != index) {
                int temp = nums[index];
                if (nums[temp] == temp) {
                    return temp;
                }
                nums[index] = nums[temp];
                nums[temp] = temp;
            } else {
                index++;
            }
        }
        return -1;
    }

    public static void main(String... args) {
        int[] nums = new int[]{0, 1, 2, 3, 4};
        System.out.println(findRepeatNumber(nums));
        int[] nums1 = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums1));
        int[] nums2 = new int[]{1};
        System.out.println(findRepeatNumber(nums2));
        int[] nums3 = new int[]{3, 3, 3, 3, 3, 3};
        System.out.println(findRepeatNumber(nums3));
    }
}