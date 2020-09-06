/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item16;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * @author xingye
 * @created 2020/9/6
 */
public class MyPower {

    /**
     * 利用公式：
     * 1.n为偶数，X^n = X^(n/2) * X^(n/2)
     * 2.n为奇数，X^n = X^(n-1/2) * X^(n-1/2) * n
     * exponent 为无符号数
     * 时间复杂度：O(lgN)
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }

        // 负数右移问题
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }

    public static void main(String... args) {
        MyPower myPower = new MyPower();
//        System.out.println(myPower.myPow(2, 10));
//        System.out.println(myPower.myPow(2.1, 3));
//        System.out.println(myPower.myPow(2, -2));
        System.out.println(myPower.myPow(2, -2147483648));
    }

}