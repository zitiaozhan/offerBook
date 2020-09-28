/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item44;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 *
 * @author xingye
 * @created 2020/9/20
 */
public class FindNthDigit2 {

    // DONE:重做标签
    public int findNthDigit(int n) {
        if(n == 0) {
            return 0;
        }
        int digit = 1;
        long start = 1;
        long count = 9;
        while(n > count) {
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        int res = n / digit;
        int rem = n % digit;
        if(rem == 0) {
            return (int)((start + res - 1) % 10);
        } else {
            long num = start + res;
            return Long.toString(num).charAt(rem - 1) - '0';
        }

    }

    public static void main(String... args) {
        FindNthDigit2 findNthDigit2 = new FindNthDigit2();
        System.out.println(findNthDigit2.findNthDigit(100));
        System.out.println(findNthDigit2.findNthDigit(2147483647));
        System.out.println(findNthDigit2.findNthDigit(1000000000));
    }

}