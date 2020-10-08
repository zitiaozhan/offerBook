/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item39;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/10/8
 */
public class MajorityElement4 {

    public Integer findMajority(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        int curNum = nums[0], curCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curNum) {
                curCount++;
            } else {
                if (curCount == 0) {
                    curNum = nums[i];
                    curCount = 1;
                } else {
                    curCount--;
                }
            }
        }
        return curNum;
    }

    public static void main(String... args) {
        MajorityElement4 element4 = new MajorityElement4();
        System.out.println(element4.findMajority(new int[]{1, 6, 3, 6, 6, 7, 6}));
    }

}