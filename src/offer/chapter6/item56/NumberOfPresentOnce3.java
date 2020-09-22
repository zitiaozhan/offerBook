/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item56;

import java.util.Arrays;

/**
 * 数组中只出现一次的两个数字
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * @author xingye
 * @created 2020/9/22
 */
public class NumberOfPresentOnce3 {

    private int[] numberOfPresentOnce(int[] nums) {
        if (null == nums || nums.length < 2) {
            return new int[]{};
        }

        // 1.异或所有数字
        int allElementRes = nums[0];
        for (int i = 1; i < nums.length; i++) {
            allElementRes = allElementRes ^ nums[i];
        }
        if (allElementRes == 0) {
            return new int[]{};
        }
        // 2.得到异或结果为1的位数
        int bit = 1, tmp = 1;
        while (bit < 32) {
            if ((allElementRes & tmp) == tmp) {
                break;
            }
            tmp = tmp << 1;
            bit++;
        }

        // 3.根据bit将数组划分为两个部分
        int num0 = 0, num1 = 0;
        for (int num : nums) {
            if (isOneOnBit(num, bit)) {
                num1 = num1 ^ num;
            } else {
                num0 = num0 ^ num;
            }
        }
        return new int[]{num0, num1};
    }

    private boolean isOneOnBit(int number, int bit) {
        int tmp = 1;
        while (bit > 1) {
            tmp = tmp << 1;
            bit--;
        }

        return (number & tmp) == tmp;
    }

    public static void main(String... args) {
        NumberOfPresentOnce3 presentOnce3 = new NumberOfPresentOnce3();
        System.out.println(Arrays.toString(presentOnce3.numberOfPresentOnce(new int[]{4, 5, 2, 2, 4, 5, 0, 7})));
        System.out.println(Arrays.toString(presentOnce3.numberOfPresentOnce(new int[]{1, 9})));
        System.out.println(Arrays.toString(presentOnce3.numberOfPresentOnce(new int[]{3, 5, 3, 5})));
        System.out.println(Arrays.toString(presentOnce3.numberOfPresentOnce(new int[]{1})));
        System.out.println(Arrays.toString(presentOnce3.numberOfPresentOnce(new int[]{23, 19, 6, 8, 19, 8, 23, 9})));
    }

}