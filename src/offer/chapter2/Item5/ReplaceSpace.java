/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.Item5;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 * @author xingye
 * @created 2020/7/12
 */
public class ReplaceSpace {
    public static void main(String... args) {
        System.out.println(new ReplaceSpace().replaceSpace(" "));
    }

    public String replaceSpace(String s) {
        if (null == s || s.length() < 1) {
            return s;
        }
        char[] target = s.toCharArray();
        // 计算空格数量
        int spaceNum = 0;
        for (char c : target) {
            if (c == ' ') {
                spaceNum++;
            }
        }
        int oldPtr = target.length;
        int newPtr = oldPtr + 2 * spaceNum;
        char[] newArray = new char[newPtr];

        // 两个指针
        oldPtr--;
        newPtr--;
        while (oldPtr >= 0) {
            if (target[oldPtr] == ' ') {
                newArray[newPtr--] = '0';
                newArray[newPtr--] = '2';
                newArray[newPtr--] = '%';
            } else {
                newArray[newPtr--] = target[oldPtr];
            }
            oldPtr--;
        }
        return new String(newArray);
    }
}