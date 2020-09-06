/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item15;

/**
 * 1的个数
 * P100
 *
 * @author xingye
 * @created 2020/7/21
 */
public class NumberOf1 {

    public static void main(String... args) {
        NumberOf1 numberOf1 = new NumberOf1();
        System.out.println(numberOf1.numberOf12(-10));
        System.out.println(numberOf1.numberOf13(-10));
    }

    /**
     * 时间复杂度固定为O(32)=O(1)的
     * 将位于的数由开始的0不断右移不断位与获得第X位是否为1
     *
     * @param n
     * @return
     */
    private int numberOf12(int n) {
        int flag = 1, count = 0;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 利用特性，n&(n-1)结果为n二进制去除最低位1
     *
     * @param n
     * @return
     */
    private int numberOf13(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n & (n - 1));
        }
        return count;
    }
}