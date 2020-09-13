/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item15;

/**
 * P100
 * 二进制中1的个数
 *
 * @author xingye
 * @created 2020/9/13
 */
public class OneOfNum2 {


    private int countOne(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    public static void main(String... args) {
        OneOfNum2 oneOfNum2 = new OneOfNum2();
        System.out.println(oneOfNum2.countOne(7));
        System.out.println(oneOfNum2.countOne(6));
    }

}