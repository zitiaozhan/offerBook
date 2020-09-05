/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item57;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列(至少含有两个数)
 *
 * @author xingye
 * @created 2020/9/5
 */
public class ContinuityArrayOfSumS {

    public static void main(String... args) {
        ContinuityArrayOfSumS arrayOfSumS = new ContinuityArrayOfSumS();
        System.out.println(arrayOfSumS.continuityArrayOfSumS(5));
        System.out.println(arrayOfSumS.continuityArrayOfSumS(6));
        System.out.println(arrayOfSumS.continuityArrayOfSumS(7));
        System.out.println(arrayOfSumS.continuityArrayOfSumS(8));
        System.out.println(arrayOfSumS.continuityArrayOfSumS(9));
        System.out.println(arrayOfSumS.continuityArrayOfSumS(10));
        System.out.println(arrayOfSumS.continuityArrayOfSumS(11));
        System.out.println(arrayOfSumS.continuityArrayOfSumS(12));
        System.out.println(arrayOfSumS.continuityArrayOfSumS(13));
        System.out.println(arrayOfSumS.continuityArrayOfSumS(14));
        System.out.println(arrayOfSumS.continuityArrayOfSumS(15));
        System.out.println(arrayOfSumS.continuityArrayOfSumS(16));
    }

    private List<List<Integer>> continuityArrayOfSumS(int s) {
        if (s < 3) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        int small = 1, big = 2, sum = small + big;
        // 循环处理,直到small=s/2
        while (small <= s / 2 && small < big) {
            if (sum == s) {
                result.add(genSequenceOfSumS(small, big));
                sum -= small;
                small++;
            } else if (sum < s) {
                big++;
                sum += big;
            } else {
                sum -= small;
                small++;
            }
        }
        return result;
    }

    private List<Integer> genSequenceOfSumS(int small, int big) {
        List<Integer> res = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            res.add(i);
        }
        return res;
    }

}