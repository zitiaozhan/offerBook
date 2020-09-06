/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item15;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * @author xingye
 * @created 2020/9/6
 */
public class OneOfNumInBinary {
    public int hammingWeight(int n) {
        // 右移n的话有可能会出现死循环，负数右移有补1
        int flag = 1, count = 0;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static void main(String... args) {
        OneOfNumInBinary numInBinary = new OneOfNumInBinary();
        System.out.println(numInBinary.hammingWeight(1));
        System.out.println(numInBinary.hammingWeight(2));
        System.out.println(numInBinary.hammingWeight(3));
        System.out.println(numInBinary.hammingWeight(-10));
    }
}