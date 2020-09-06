/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item16;

/**
 * 数值的整数次方
 * P110
 *
 * @author xingye
 * @created 2020/7/21
 */
public class Power {
    public static void main(String... args) {
        Power power = new Power();
        // CASE1
        System.out.println(power.power(-2, -2));
        System.out.println(power.power(0, 2));

        System.out.println(power.power(2, 0));
        System.out.println(power.power(-2, 0));
        System.out.println(power.power(1.1, 3));
        System.out.println(Math.pow(1.1, 3.0));
        System.out.println(power.power(1.1, -3));
        System.out.println(Math.pow(1.1, -3.0));

        // CASE2
        //System.out.println(power.power(0, -2));
        System.out.println(Math.pow(0, -2));
    }

    /**
     * 数值的整数次方
     * 注意：
     * 1.exponent为负数的情况
     * 2.exponent为负数且base为0的情况
     *
     * @param base     数值
     * @param exponent 次幂
     * @return 结果
     */
    private double power(double base, int exponent) {
        double res = 1;
        boolean isNegative = false;
        if (exponent < 0) {
            isNegative = true;
            exponent = Math.abs(exponent);
            if (base == 0) {
                throw new IllegalArgumentException("不合法的计算参数");
            }
        }
        //res = power2WithUnSigned(base, exponent);
        res = power2WithUnSigned2(base, exponent);

        return isNegative ? 1 / res : res;
    }

    // 时间复杂度：O(N)
    private double power2WithUnSigned(double base, int exponent) {
        double res = 1;
        for (int i = 0; i < exponent; i++) {
            res *= base;
        }
        return res;
    }

    /**
     * 利用公式：
     * 1.n为偶数，X^n = X^(n/2) * X^(n/2)
     * 2.n为奇数，X^n = X^(n-1/2) * X^(n-1/2) * n
     * exponent 为无符号数
     * 时间复杂度：O(lgN)
     */
    private double power2WithUnSigned2(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (base == 1) {
            return 1;
        }

        // X^n/2 或 X^(n-1/2)
        double res = power2WithUnSigned(base, exponent >> 1);
        res *= res;
        if ((exponent & 1) == 1) {
            // 奇数
            res *= base;
        }

        return res;
    }
}