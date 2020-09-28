/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item44;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * <p>
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xingye
 * @created 2020/9/28
 */
public class FindNthDigit3 {

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }

        // 第n个数字所在数字的位数
        int bitNum = 1;
        while (n > countOfNum(bitNum)) {
            n -= countOfNum(bitNum++);
        }

        // 整除结果
        long multiple = n / bitNum;
        // 整除余数
        int remainder = n % bitNum;
        // 位数的起始值
        long startNum = startNum(bitNum);

        if (remainder == 0) {
            // startNum+multiple-1 的最后一个数字
            return getRes(startNum + multiple - 1, remainder);
        } else {
            // startNum+multiple 的第 bitNum-remainder 个数字
            return getRes(startNum + multiple, bitNum - remainder);
        }
    }

    private long countOfNum(int bitNum) {
        return bitNum * (long) (9 * Math.pow(10, bitNum - 1));
    }

    private long startNum(int bitNum) {
        return (long) Math.pow(10, bitNum - 1);
    }

    private int getRes(long number, int bitNum) {
        while (bitNum > 0) {
            number /= 10;
            bitNum--;
        }
        return (int) (number % 10);
    }

    public static void main(String... args) {
        FindNthDigit3 findNthDigit3 = new FindNthDigit3();
        System.out.println(findNthDigit3.findNthDigit(10));
        System.out.println(findNthDigit3.findNthDigit(11));
        System.out.println(findNthDigit3.findNthDigit(12));
        System.out.println(findNthDigit3.findNthDigit(13));
        System.out.println(findNthDigit3.findNthDigit(19));

        // 5
        System.out.println(findNthDigit3.findNthDigit(100));
        // 2
        System.out.println(findNthDigit3.findNthDigit(2147483647));
        // 1
        System.out.println(findNthDigit3.findNthDigit(1000000000));
    }

}