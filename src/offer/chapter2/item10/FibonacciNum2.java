/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item10;

/**
 * P74
 * 斐波那切数列
 *
 * @author xingye
 * @created 2020/9/12
 */
public class FibonacciNum2 {

    public Integer fibonacciNum(int n) {
        if (n < 0) {
            return null;
        }
        if (n < 2) {
            return n;
        }
        int n_1 = 1, n_2 = 0, res = 0;
        for (int i = 2; i <= n; i++) {
            res = n_1 + n_2;
            n_2 = n_1;
            n_1 = res;
        }
        return res;
    }

    public static void main(String... args) {
        FibonacciNum2 fibonacciNum2 = new FibonacciNum2();
        System.out.println(fibonacciNum2.fibonacciNum(3));
        System.out.println(fibonacciNum2.fibonacciNum(4));
        System.out.println(fibonacciNum2.fibonacciNum(5));
    }

}