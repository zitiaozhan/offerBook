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
 * @author xinyeguo
 * @created 2020/10/10
 */
public class MyPower3 {
    public double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent == -1) {
            return 1 / base;
        }

        double half = power(base, exponent >> 1);
        return half * half * power(base, exponent % 2);
    }

    public static void main(String... args) {
        MyPower3 myPower3 = new MyPower3();
        System.out.println(myPower3.power(3, 3));
        System.out.println(myPower3.power(2, -2));
    }
}