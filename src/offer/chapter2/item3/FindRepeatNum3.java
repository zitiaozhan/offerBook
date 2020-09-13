/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item3;

/**
 * P39
 * 数组中重复的数字
 *
 * @author xingye
 * @created 2020/9/10
 */
public class FindRepeatNum3 {

    // 时间复杂度O(N)，时间复杂度O(N)，散列表原理
    private Integer findRepeatNum(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }

        // 数字计数数组
        int[] numCounter = new int[nums.length];
        for (int num : nums) {
            numCounter[num]++;
        }

        // 找到重复数字
        for (int i = 0; i < numCounter.length; i++) {
            if (numCounter[i] > 1) {
                return i;
            }
        }
        return null;
    }

    // 时间复杂度O(N)，时间复杂度O(1)，利用数字在0 ~ n-1区间内
    private Integer findRepeatNum2(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }

        int index = 0;
        while (index < nums.length) {
            // 当前元素与下标是否相等
            if (nums[index] != index) {
                // 交换元素
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
        return null;
    }

    public static void main(String... args) {
        FindRepeatNum3 repeatNum3 = new FindRepeatNum3();
        System.out.println(repeatNum3.findRepeatNum2(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

}