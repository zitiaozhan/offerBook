/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.sub;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/10/11
 */
public class SubString1 {

    public int subString(String a, String b) {
        if (null == a || null == b) {
            return -1;
        }

        int start = 0, end = 0, index = 0;
        while (end < a.length()) {
            char aChar = a.charAt(end);
            char bChar = b.charAt(index);

            if (aChar != bChar) {
                start++;
                end = start;
                index = 0;
                continue;
            }

            if (index == b.length() - 1) {
                return start;
            }

            end++;
            index++;
        }
        return -1;
    }

    public static void main(String... args) {
        SubString1 subString1 = new SubString1();
        System.out.println(subString1.subString("abcdefghi", "cde"));
        System.out.println(subString1.subString("cdabcdefgcdhi", "cdh"));
        System.out.println(subString1.subString("cdabcdefgcdh", "cdh"));
        System.out.println(subString1.subString("cdabcdefgcd", "cdh"));
    }

}