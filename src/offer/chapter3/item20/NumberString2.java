/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item20;

/**
 * P127
 * 剑指 Offer 20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * @author xingye
 * @created 2020/9/13
 */
public class NumberString2 {
    private int pos = 0;

    // A[.[B]][e|EC]  .B[e|EC]
    private boolean isNumber(String target) {
        if (null == target || 0 == target.length()) {
            return false;
        }
        target = target.trim();

        // 是否存在小数点前的整数
        boolean res = scanNumber(target);
        if (pos < target.length() && target.charAt(pos) == '.') {
            // 有小数点的情况
            pos++;
            res = res | scanUnSignNumber(target);
        }
        if (pos < target.length() && (target.charAt(pos) == 'e' || target.charAt(pos) == 'E')) {
            // 有E部分
            pos++;
            res = res && scanNumber(target);
        }
        return res && pos == target.length();
    }

    private boolean scanNumber(String target) {
        if (pos < target.length() && (target.charAt(pos) == '-' || target.charAt(pos) == '+')) {
            // 跳过最前面正负号
            pos++;
        }

        return scanUnSignNumber(target);
    }

    private boolean scanUnSignNumber(String target) {
        int oldPos = pos;
        while (pos < target.length()) {
            char charAt = target.charAt(pos);
            if (charAt >= '0' && charAt <= '9') {
                pos++;
            } else {
                break;
            }
        }
        return pos > oldPos;
    }

    public boolean isNumber2(String target) {
        if (null == target || 0 == target.length()) {
            return false;
        }
        target = target.trim();

        // 数字是否出现过
        boolean numberFlag = false;
        boolean pointFlag = false;
        boolean eFlag = false;

        for (int i = 0; i < target.length(); i++) {
            char charAt = target.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                numberFlag = true;
            } else if (charAt == '.' && !pointFlag && !eFlag) {
                pointFlag = true;
            } else if ((charAt == 'e' || charAt == 'E') && numberFlag && !eFlag) {
                eFlag = true;
                numberFlag = false;
            } else if ((charAt == '+' || charAt == '-') && (i == 0 || target.charAt(i - 1) == 'e' || target.charAt(i - 1) == 'E')) {

            } else {
                return false;
            }
        }
        return numberFlag;
    }
}