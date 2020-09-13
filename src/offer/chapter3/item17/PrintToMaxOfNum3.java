/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item17;

import java.util.Arrays;

/**
 * P114
 * 打印从1到最大的n位数
 *
 * @author xingye
 * @created 2020/9/13
 */
public class PrintToMaxOfNum3 {

    // 字符串模拟加法运算
    public void printNumbers(int n) {
        if (n < 1) {
            return;
        }

        char[] curNum = new char[n];
        Arrays.fill(curNum, '0');
        while (!increaseOne(curNum)) {
            printNumber(curNum);
        }
    }

    private boolean increaseOne(char[] curNum) {
        boolean overFlow = false;
        int nTakeOver = 0;
        for (int i = curNum.length - 1; i >= 0; i--) {
            int nSum = curNum[i] - '0' + nTakeOver;
            if (i == curNum.length - 1) {
                // 最低位加一
                nSum++;
            }

            if (nSum >= 10) {
                // 产生进位
                if (i == 0) {
                    // 最高位进位
                    overFlow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    curNum[i] = (char) (nSum + '0');
                }
            } else {
                // 无进位
                curNum[i] = (char) (nSum + '0');
                break;
            }
        }
        return overFlow;
    }

    private void printNumber(char[] curNum) {
        int index = 0, bound = 0;
        for (int i = 0; i < curNum.length; i++) {
            if (curNum[i] != '0') {
                bound = i;
                break;
            }
        }
        char[] num = new char[curNum.length - bound];
        for (int i = bound; i < curNum.length; i++) {
            num[index++] = curNum[i];
        }
        System.out.println(new String(num));
    }

    public static void main(String... args) {
        PrintToMaxOfNum3 printToMaxOfNum3 = new PrintToMaxOfNum3();
        printToMaxOfNum3.printNumbers(3);
    }

}