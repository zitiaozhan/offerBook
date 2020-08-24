/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item43;

/**
 * 剑指 Offer 43. 1～n整数中1出现的次数
 * P221
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * @author xingye
 * @created 2020/8/24
 */
public class CountDigitOne {

    public int countDigitOne(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }

        // 1.先求最高位1的数量
        // 2.再求1-最大量级数除最高位之外的1的数量，如n=3117，则求0001-3000
        // 3.最后递归求剩余，如n=3117，则求1-117
        int count = 0;
        char[] chars = String.valueOf(n).toCharArray();

        int firstNum = Integer.parseInt(String.valueOf(chars[0]));
        // 1
        if (firstNum == 1) {
            count = n - (int) Math.pow(10, chars.length - 1) + 1;
        } else {
            count = (int) Math.pow(10, chars.length - 1);
        }

        // 2
        count += firstNum * (chars.length - 1) * (int) Math.pow(10, chars.length - 2);

        // 3
        count += countDigitOne(n - firstNum * (int) Math.pow(10, chars.length - 1));
        return count;
    }

    public static void main(String... args) {
        CountDigitOne countDigitOne = new CountDigitOne();
        System.out.println(countDigitOne.countDigitOne(10));
        System.out.println(countDigitOne.countDigitOne(17));
        System.out.println(countDigitOne.countDigitOne(100));
        System.out.println(countDigitOne.countDigitOne(117));
        System.out.println(countDigitOne.countDigitOne(3117));
    }
}