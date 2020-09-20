/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item39;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * REDO:重做标签
 *
 * @author xingye
 * @created 2020/9/19
 */
public class MajorityElement2 {

    public int majorityElement(int[] nums) {
        // 覆盖计数法
        int count = 1, num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (count == 0) {
                count++;
                num = cur;
            } else if (cur == num) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }

}