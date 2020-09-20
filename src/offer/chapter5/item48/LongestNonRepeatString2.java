/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item48;

import java.util.Arrays;

/**
 * P48
 * 最长不含重复字符的子字符串
 *
 * @author xingye
 * @created 2020/9/20
 */
public class LongestNonRepeatString2 {

    private int longestSubString(String target) {
        if (null == target || 0 == target.length()) {
            return 0;
        }
        char[] chars = target.toCharArray();
        // 哈希表存储上次出现的位置
        int[] position = new int[26];
        Arrays.fill(position, -1);
        int left = 0, right = 1;
        position[chars[left] - 'a'] = left;
        int maxLen = 1;
        while (right < chars.length) {
            int lastPosition = position[chars[right] - 'a'];
            if (lastPosition != -1 && lastPosition >= left) {
                left = lastPosition + 1;
            }
            position[chars[right] - 'a'] = right;
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static void main(String... args) {
        LongestNonRepeatString2 repeatString2 = new LongestNonRepeatString2();
        System.out.println(repeatString2.longestSubString("arabcacfr"));
        System.out.println(repeatString2.longestSubString("abcdefghsdbcas"));
    }

}