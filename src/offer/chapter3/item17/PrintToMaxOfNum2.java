/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item17;

import java.util.Arrays;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * @author xingye
 * @created 2020/9/6
 */
public class PrintToMaxOfNum2 {

    private int index = 0;

    public int[] printNumbers(int n) {
        if (n < 1) {
            return null;
        }

        // 全排列
        int[] nums = new int[(int) (Math.pow(10, n) - 1)];
        printNumbers(n, nums, "");
        return nums;
    }

    private void printNumbers(int n, int[] nums, String num) {
        if (n == 0) {
            int number = Integer.parseInt(num);
            if (number != 0) {
                nums[index++] = number;
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            printNumbers(n - 1, nums, num + i);
        }
    }

    public static void main(String... args) {
        PrintToMaxOfNum2 print = new PrintToMaxOfNum2();
        System.out.println(Arrays.toString(print.printNumbers(5)));
    }

}