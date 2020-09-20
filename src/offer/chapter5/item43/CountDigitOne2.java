/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item43;

/**
 * 剑指 Offer 43. 1～n整数中1出现的次数
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * @author xingye
 * @created 2020/9/20
 */
public class CountDigitOne2 {

    public int countDigitOne(int n) {
        if (n < 1) {
            return 0;
        }

        return countCore(n);
    }

    // n=2005
    private int countCore(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        // 数字位数
        int numLen = String.valueOf(n).length();
        int highestUnit = (int) Math.pow(10, numLen - 1);
        int numOfHighest = n / highestUnit;
        // 1.先算最高位出现的次数, （先计算千位）
        int count = countOneOfHighestBit(n, highestUnit, numOfHighest);
        // 2.再计算其他位出现次数,例如n为四位数，则其他位数次数为 0-9在三个位置的排列组合，（再计算1-999的出现次数*2）
        count += numOfHighest * ((numLen - 1) * Math.pow(10, numLen - 2));
        // 3.最后递归计算 零头部分，（最后计算零头 5）
        return count + countCore(n - numOfHighest * highestUnit);
    }

    private int countOneOfHighestBit(int n, int highestUnit, int numOfHighest) {
        if (numOfHighest == 1) {
            return n - highestUnit + 1;
        }
        return highestUnit;
    }

    public static void main(String... args) {
        CountDigitOne2 countDigitOne2 = new CountDigitOne2();
        System.out.println(countDigitOne2.countDigitOne(10));
        System.out.println(countDigitOne2.countDigitOne(2005));
        System.out.println(countDigitOne2.countDigitOne(12));
        System.out.println(countDigitOne2.countDigitOne(13));
    }

}