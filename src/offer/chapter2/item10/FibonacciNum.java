/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item10;

/**
 * 斐波那契数列，P74
 *
 * @author xingye
 * @created 2020/7/14
 */
public class FibonacciNum {
    private int fibonacciNum(int n) {
        if (n < 0) {
            return -1;
        }
        if (n < 2) {
            return n;
        }

        int n_2 = 0;
        int n_1 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = n_1 + n_2;
            n_2 = n_1;
            n_1 = res;
        }

        return res;
    }

    public static void main(String... args) {
        FibonacciNum fibonacciNum = new FibonacciNum();
        System.out.println(fibonacciNum.fibonacciNum(10));
    }
}