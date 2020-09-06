/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item17;

import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 * P114
 *
 * @author xingye
 * @created 2020/7/22
 */
public class PrintToMaxOfNum {
    public static void main(String... args) {
        PrintToMaxOfNum printToMaxOfNum = new PrintToMaxOfNum();
        printToMaxOfNum.printToMaxOfNum2(4);
    }

    /**
     * 最坏时间复杂度：10^n * n * n = 10^3n
     * 字符串表示数字计算加法
     *
     * @param n
     */
    private void printToMaxOfNum(int n) {
        if (n < 1) {
            return;
        }

        char[] num = new char[n];
        Arrays.fill(num, '0');
        while (!increment(num)) {
            printNum(num);
        }
    }

    /**
     * 数组的0表示大数的最高位
     * 1.增加的始终为最低位,高位依靠低位进位增加
     * 2.当产生进位且已经到达最高位时，表示数字已经溢出
     * 时间复杂度：最坏O(N),最好O(1)
     *
     * @param num
     * @return
     */
    private boolean increment(char[] num) {
        // 是否溢出
        boolean isOverflow = false;
        // 进位
        int nTakeOver = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int nSum = num[i] - '0' + nTakeOver;
            // 增加1
            if (i == num.length - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                // 产生进位
                if (i == 0) {
                    // 进位到了最高位，溢出
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    num[i] = (char) ('0' + nSum);
                }
            } else {
                num[i]++;
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 排列组合的方式
     * 时间复杂度：10^n
     *
     * @param n
     */
    private void printToMaxOfNum2(int n) {
        if (n < 1) {
            return;
        }

        char[] num = new char[n];
        Arrays.fill(num, '0');
        for (int i = 0; i < 10; i++) {
            num[0] = (char) (i + '0');
            printToMaxOfNum2Core(num, 0);
        }
    }

    private void printToMaxOfNum2Core(char[] num, int index) {
        if (index == num.length - 1) {
            // 到达最低位，打印数字
            printNum(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            num[index + 1] = (char) (i + '0');
            printToMaxOfNum2Core(num, index + 1);
        }
    }

    // 时间复杂度：O(N)
    private void printNum(char[] num) {
        boolean isBegin = false;
        for (char c : num) {
            if (!isBegin && c != '0') {
                isBegin = true;
            }
            if (isBegin) {
                System.out.print(c);
            }
        }
        System.out.println();
    }
}