/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item49;

/**
 * P49
 * 丑数
 *
 * @author xingye
 * @created 2020/9/20
 */
public class UglyNumber2 {

    private int uglyNumber(int n) {
        if (n < 1) {
            return -1;
        }
        if (n < 6) {
            return n;
        }

        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;

        int index = 5;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while (index < n) {
            while (2 * nums[index2] <= nums[index - 1]) {
                index2++;
            }
            while (3 * nums[index3] <= nums[index - 1]) {
                index3++;
            }
            while (5 * nums[index5] <= nums[index - 1]) {
                index5++;
            }
            nums[index++] = getRes(2 * nums[index2], 3 * nums[index3], 5 * nums[index5]);
        }

        return nums[n - 1];
    }

    private int getRes(int num2, int num3, int num5) {
        int min = num2;
        min = Math.min(min, num3);
        min = Math.min(min, num5);
        return min;
    }

    public static void main(String... args) {
        UglyNumber2 uglyNumber2 = new UglyNumber2();
        System.out.println(uglyNumber2.uglyNumber(5));
        System.out.println(uglyNumber2.uglyNumber(6));
        System.out.println(uglyNumber2.uglyNumber(7));
        System.out.println(uglyNumber2.uglyNumber(8));
        System.out.println(uglyNumber2.uglyNumber(9));
        System.out.println(uglyNumber2.uglyNumber(10));
        System.out.println(uglyNumber2.uglyNumber(11));
    }

}