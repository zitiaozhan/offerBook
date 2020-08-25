/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item44;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * P225
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 *
 * @author xingye
 * @created 2020/8/25
 */
public class FindNthDigit {

    public int findNthDigit(long n) {
        if (n < 0) {
            return -1;
        }

        n++;
        int pos = 1;
        while (n > pos * countOfNPosition(pos)) {
            n -= pos * countOfNPosition(pos);
            pos++;
        }

        // 该数为pos位数的数字中的一个数
        long num1 = n / pos;
        int num2 = (int) n % pos;
        long startNum = getStartNum(pos);
        if (num2 == 0) {
            return getRes(startNum + num1 - 1, pos);
        } else {
            return getRes(startNum + num1, num2);
        }
    }

    private int getRes(long num, int index) {
        char[] chars = String.valueOf(num).toCharArray();
        return chars[index - 1] - '0';
    }

    private long getStartNum(int pos) {
        if (pos == 1) {
            return 0;
        }
        return (long) Math.pow(10, pos - 1);
    }

    /**
     * N位数字的数量
     *
     * @param n 位数
     */
    private long countOfNPosition(int n) {
        if (n == 1) {
            return 10;
        }
        return 9 * (long) Math.pow(10, n - 1);
    }

    public static void main(String... args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(findNthDigit.findNthDigit(2147483647));
    }
}