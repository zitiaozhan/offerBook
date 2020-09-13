/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item16;

/**
 * P110
 * 数值的整数次方
 *
 * @author xingye
 * @created 2020/9/13
 */
public class MyPower2 {

    // x^n = x^n/2 * x^n/2,n为偶数
    // x^n = x^n/2 * x^n/2 * x,n为奇数
    public double myPow(double x, int n) {
        if (0 == n) {
            return 1;
        }
        if (1 == n) {
            return x;
        }
        if (-1 == n) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }

    public static void main(String... args) {
        MyPower2 myPower2 = new MyPower2();
        System.out.println(myPower2.myPow(2, -2));
        System.out.println(myPower2.myPow(2, -3));
        System.out.println(myPower2.myPow(5, 2));
        System.out.println(myPower2.myPow(5, 3));
    }

}