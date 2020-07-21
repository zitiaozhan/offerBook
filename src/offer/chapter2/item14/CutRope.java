/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item14;

/**
 * 剪绳子
 * P96
 * 贪婪算法
 *
 * @author xingye
 * @created 2020/7/21
 */
public class CutRope {
    public static void main(String... args) {
        CutRope cutRope = new CutRope();
        System.out.println(cutRope.cutRope(10));
        System.out.println(cutRope.cutRope2(10));
    }

    /**
     * 剪绳子，使用贪婪算法
     */
    private int cutRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int res = 1;
        while (n > 3) {
            if (n > 4) {
                res *= 3;
                n -= 3;
            } else {
                res *= 4;
                break;
            }
            if (n <= 3) {
                res *= n;
                break;
            }
        }
        return res;
    }

    // 时间复杂度:O(1)
    private int cutRope2(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int timesOf3 = n / 3;
        if (n - 3 * timesOf3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (n - (3 * timesOf3)) / 2;
        return (int) (Math.pow(3.0, timesOf3) * Math.pow(2.0, timesOf2));
    }
}