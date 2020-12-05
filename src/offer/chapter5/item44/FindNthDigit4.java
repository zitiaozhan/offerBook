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
 * @created 2020/12/4
 */
public class FindNthDigit4 {

    public int find(int n) {
        if (n < 10) {
            return n;
        }

        int nBit = 1;
        while (n > countOfN(nBit)) {
            n -= countOfN(nBit++);
        }

        // 位置
        int pos = n % nBit;
        // 哪个数
        long num = beginNum(nBit) + n / nBit;
        if (pos == 0) {
            // 整除取上个数的最后一位
            char[] chars = String.valueOf(num - 1).toCharArray();
            return chars[chars.length - 1] - '0';
        }

        char[] chars = String.valueOf(num).toCharArray();
        return chars[pos - 1] - '0';
    }

    private long countOfN(int nBit) {
        return (long) (nBit * (9 * Math.pow(10, nBit - 1)));
    }

    private long beginNum(int nBit) {
        return (long) Math.pow(10, nBit - 1);
    }

    public static void main(String... args) {
        FindNthDigit4 findNthDigit2 = new FindNthDigit4();
        System.out.println(findNthDigit2.find(100));
        System.out.println(findNthDigit2.find(2147483647));
        System.out.println(findNthDigit2.find(1000000000));
    }

}