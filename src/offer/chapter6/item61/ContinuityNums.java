/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item61;

import java.util.Arrays;

/**
 * P298
 * 扑克牌中的顺子
 *
 * @author xingye
 * @created 2020/9/8
 */
public class ContinuityNums {

    // 不能保证没有重复数字，如：1 2 2 3 5
    private boolean continuityNums(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return false;
        }

        // 最大值、最小值、0的个数
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                min = Math.min(num, min);
                max = Math.max(num, max);
            }
        }

        // 不考虑0的个数超过2
        if (zeroCount == nums.length) {
            return true;
        }
        return max - min + 1 + zeroCount == nums.length;
    }

    // 时间复杂度：O(NlogN)
    private boolean continuityNums2(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return false;
        }
        //1.排序
        Arrays.sort(nums);
        //2.统计0个数+查看空缺数量
        int zeroCount = 0;
        int absent = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                if (nums[i + 1] == nums[i]) {
                    // 含有重复数字，不可能是顺子
                    return false;
                } else if (nums[i + 1] - nums[i] > 1) {
                    absent += nums[i + 1] - nums[i] - 1;
                }
            }
        }
        return zeroCount >= absent;
    }

    public static void main(String... args) {
        ContinuityNums continuityNums = new ContinuityNums();
        System.out.println(continuityNums.continuityNums2(new int[]{1, 2, 2, 3, 4}));
        System.out.println(continuityNums.continuityNums2(new int[]{1, 0, 2, 3, 4}));
        System.out.println(continuityNums.continuityNums2(new int[]{1, 0, 0, 3, 5}));
        System.out.println(continuityNums.continuityNums2(new int[]{1, 5, 3, 0, 4}));
        System.out.println(continuityNums.continuityNums2(new int[]{1, 5, 3, 2, 4}));
    }

}