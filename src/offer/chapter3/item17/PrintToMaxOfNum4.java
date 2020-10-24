/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item17;

import java.util.Arrays;

/**
 * 在这里编写类的功能描述
 *
 * @author xinyeguo
 * @created 2020/10/10
 */
public class PrintToMaxOfNum4 {

    public void print(int n) {
        char[] number = new char[n];
        Arrays.fill(number, '0');

        while (!mockPlusOne(number)) {
            System.out.println(new String(number));
        }
    }

    private boolean mockPlusOne(char[] number) {
        int carryNum = 0;
        boolean carryFlag = false;

        for (int i = number.length - 1; i >= 0; i--) {
            int curNum = number[i] - '0';
            if (i == number.length - 1) {
                curNum = curNum + 1;
            }
            curNum = carryFlag ? curNum + carryNum : curNum;

            if (curNum > 9) {
                // 有进位
                if (i == 0) {
                    return true;
                }
                carryNum = 1;
                carryFlag = true;
                number[i] = '0';
            } else {
                number[i] = (char) ('0' + curNum);
                return false;
            }
        }

        return false;
    }

    public static void main(String... args) {
        PrintToMaxOfNum4 printToMaxOfNum4 = new PrintToMaxOfNum4();
        printToMaxOfNum4.print(3);
    }

}