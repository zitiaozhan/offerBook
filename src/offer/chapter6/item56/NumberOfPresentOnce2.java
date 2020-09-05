/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item56;

/**
 * 数组中唯一只出现一次的数字，其他数字都出现三次
 * P278
 *
 * @author xingye
 * @created 2020/9/3
 */
public class NumberOfPresentOnce2 {
    public static void main(String... args) {
        NumberOfPresentOnce2 presentOnce2 = new NumberOfPresentOnce2();
        System.out.println(presentOnce2.numberOfPresentOnce2(new int[]{1, 1, 1, 2}));
        System.out.println(presentOnce2.numberOfPresentOnce2(new int[]{1, 2, 3, 2, 1, 1, 2}));
    }

    private Integer numberOfPresentOnce2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        int[] bitSum = new int[32];
        for (int i = 0; i < 32; i++) {
            int bitMask = 1 << i;
            for (int num : nums) {
                bitSum[i] += (num & bitMask) >> i;
            }
        }

        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }

}