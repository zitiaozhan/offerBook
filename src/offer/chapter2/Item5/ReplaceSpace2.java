/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.Item5;

/**
 * P51
 * 替换字符串中的空格
 *
 * @author xingye
 * @created 2020/9/12
 */
public class ReplaceSpace2 {

    private String replaceSpace(String target) {
        if (null == target || 0 == target.length()) {
            return target;
        }

        //1.统计空格数量
        int count = 0;
        char[] chars = target.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' ') {
                count++;
            }
        }
        if (0 == count) {
            return target;
        }

        //2.替换空格
        char[] newChars = new char[target.length() + 2 * count];
        int index = chars.length - 1;
        for (int i = newChars.length - 1; i >= 0; i--) {
            char curChar = chars[index];
            if (curChar == ' ') {
                newChars[i--] = '0';
                newChars[i--] = '2';
                newChars[i] = '%';
            } else {
                newChars[i] = curChar;
            }
            index--;
        }

        return new String(newChars);
    }

    public static void main(String... args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace(" I am a robot "));
        System.out.println(replaceSpace.replaceSpace("This % 20 is %2 0 test"));
    }

}