/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item20;

/**
 * 表示数值的字符串
 * P127
 *
 * @author xingye
 * @created 2020/7/23
 */
public class NumberString {
    private int pos = 0;

    public static void main(String... args) {
        System.out.println(new NumberString().numberString("1 "));
        System.out.println(new NumberString().numberString("+ "));
        System.out.println(new NumberString().isNumber("+ "));
        /*System.out.println(new NumberString().numberString("+100"));
        System.out.println(new NumberString().numberString("5e2"));
        System.out.println(new NumberString().numberString("-123"));
        System.out.println(new NumberString().numberString("-1E-16"));*/

        System.out.println("--------------------------------");
        /*System.out.println(new NumberString().numberString("12e"));
        System.out.println(new NumberString().numberString("1a3.14"));
        System.out.println(new NumberString().numberString("1.2.3"));
        System.out.println(new NumberString().numberString("+-5"));
        System.out.println(new NumberString().numberString("12e+5.4"));*/
    }

    /**
     * 符合 A[.[B]][e|EC] 或者 .B[e|EC]
     *
     * @param target
     * @return
     */
    private boolean numberString(String target) {
        if (null == target || target.length() == 0) {
            return false;
        }
        target = target.trim();

        // 判断A的部分
        boolean res = scanInteger(target);
        if (pos < target.length() && target.charAt(pos) == '.') {
            // 判断B的部分
            pos++;
            // A存在 或者 A存在B存在 或者 A不存在B存在
            boolean bExist = scanUnSignInteger(target);
            res = res || bExist;
        }

        if (pos < target.length() && (target.charAt(pos) == 'e' || target.charAt(pos) == 'E')) {
            // 判断C的部分
            pos++;
            res = res && scanInteger(target);
        }

        return res && pos == target.length();
    }

    /**
     * 存在自然数即为true
     *
     * @param target
     * @return
     */
    private boolean scanInteger(String target) {
        if (pos < target.length() && (target.charAt(pos) == '+' || target.charAt(pos) == '-')) {
            pos++;
        }
        return scanUnSignInteger(target);
    }

    /**
     * 存在至少一位无符号数即为true
     *
     * @param target
     * @return
     */
    private boolean scanUnSignInteger(String target) {
        int oldIndex = pos;
        while (pos < target.length()) {
            char charAt = target.charAt(pos);
            if (charAt >= '0' && charAt <= '9') {
                pos++;
            } else {
                break;
            }
        }
        return pos > oldIndex;
    }

    /**
     * ‘.’出现正确情况：只出现一次，且在e的前面
     * ‘e’出现正确情况：只出现一次，且出现前有数字
     * ‘+’‘-’出现正确情况：只能在开头和e后一位
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //去掉首尾空格
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                //判定为数字，则标记numFlag
                numFlag = true;
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                //判定为.  需要没出现过.并且没出现过e
                dotFlag = true;
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                //判定为e，需要没出现过e，并且出过数字了
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                //判定为+-符号，只能出现在第一位或者紧接e后面

            } else {
                //其他情况，都是非法的
                return false;
            }
        }
        return numFlag;
    }
}